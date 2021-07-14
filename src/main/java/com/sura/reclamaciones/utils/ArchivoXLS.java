package com.sura.reclamaciones.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.sura.reclamaciones.exceptions.ExceptionAbrirArchivoXls;
import net.thucydides.core.steps.StepInterceptor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArchivoXLS {

  private static XSSFSheet hojaXls;
  private static XSSFWorkbook libroXls;
  private static XSSFRow fila;
  private static final Logger LOGGER = LoggerFactory.getLogger(StepInterceptor.class);

  private ArchivoXLS() {}

  public static void abrirArchivoXls(String rutaArchivoXls, String nombreHojaArchivoXls)
      throws ExceptionAbrirArchivoXls {
  try {
      FileInputStream archivoXls = new FileInputStream(rutaArchivoXls);
      libroXls = new XSSFWorkbook(archivoXls);
      hojaXls = libroXls.getSheet(nombreHojaArchivoXls);
  } catch (IOException e) {

      LOGGER.info("setCellData error", e);
  }

  }

  public static void setCellData(int rowNum, int colNum, String valorObtenido) {
    try {
      boolean valorCorrecto =
          valorObtenido.matches("^(?:3[01]|[12][0-9]|0?[1-9])([\\-/.])(0?[1-9]|1[1-2])\\1\\d{4}$");
      if (valorCorrecto) {
        Date date1 = new SimpleDateFormat("dd/mm/yyyy").parse(valorObtenido);
        CellStyle cellStyle = libroXls.createCellStyle();
        cellStyle.setDataFormat(libroXls.createDataFormat().getFormat("dd/mm/yyyy"));
        hojaXls.getRow(rowNum).createCell(colNum).setCellValue(date1);
        hojaXls.getRow(rowNum).getCell(colNum).setCellStyle(cellStyle);
      } else {
        hojaXls.getRow(rowNum).createCell(colNum).setCellValue(valorObtenido);
        hojaXls.getRow(rowNum).getCell(colNum).setCellStyle(hojaXls.getColumnStyle(colNum));
      }
    } catch (Exception e) {
      LOGGER.info("setCellData error", e);
    }
  }

  public static int contarFilas() {
    return hojaXls.getLastRowNum();
  }

  public static void removerFilaSinEncabezado() {
    int numeroFilasLLenas = contarFilas();
    for (int fila = 1; fila <= numeroFilasLLenas; fila++) {
      hojaXls.removeRow(hojaXls.getRow(fila));
    }
  }

  public static void escribirExcelXfila(List<String> lista2, String rutaArchivoXls) {
    try {
      int numeroFilaLLenas = contarFilas();
      fila = hojaXls.createRow(numeroFilaLLenas + 1);
      int i = 0;
      while (i < lista2.size()) {
        for (String valorObtenido : lista2) {
          setCellData(fila.getRowNum(), i, valorObtenido);
          guardar(rutaArchivoXls);
          i++;
        }
      }
    } catch (Exception e) {
      LOGGER.info("setCellData error", e);
    }
  }

  public static void guardar(String rutaArchivoXls) throws IOException {
    try {
      FileOutputStream outputStream = new FileOutputStream(rutaArchivoXls);
      libroXls.write(outputStream);
      outputStream.close();
    } catch (Exception e) {
      LOGGER.error("setCellData error", e);
    }
  }
}
