package com.sura.reclamaciones.utils;

import static org.terracotta.modules.ehcache.ToolkitInstanceFactoryImpl.LOGGER;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ArchivoExcel {

  private static XSSFSheet hojaExcel;
  private static XSSFWorkbook libroExcel;

  private ArchivoExcel() {
    //Constructor vacío
  }

  public static void abrirArchivoExcel(String rutaArchivoExcel, String nombreHojaArchivoExcel)
      throws IOException {
    FileInputStream archivoExcel = new FileInputStream(rutaArchivoExcel);
    libroExcel = new XSSFWorkbook(archivoExcel);
    hojaExcel = libroExcel.getSheet(nombreHojaArchivoExcel);
  }

  public static void modificarDatoCelda(int numeroFila, int numeroColumna, String valorObtenido) {
    try {
      boolean valorCorrecto =
          valorObtenido.matches("^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$");
      if (valorCorrecto) {
        Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(valorObtenido);
        CellStyle cellStyle = libroExcel.createCellStyle();
        cellStyle.setDataFormat(libroExcel.createDataFormat().getFormat("dd/mm/yyyy"));
        hojaExcel.getRow(numeroFila).createCell(numeroColumna).setCellValue(fecha);
        hojaExcel.getRow(numeroFila).getCell(numeroColumna).setCellStyle(cellStyle);
      } else {
        hojaExcel.getRow(numeroFila).createCell(numeroColumna).setCellValue(valorObtenido);
        hojaExcel
            .getRow(numeroFila)
            .getCell(numeroColumna)
            .setCellStyle(hojaExcel.getColumnStyle(numeroColumna));
      }
    } catch (Exception e) {
      LOGGER.info("No se envío el dato a la celda", e);
    }
  }

  public static int contarFilas() {
    return hojaExcel.getLastRowNum();
  }

  public static void removerFilaSinEncabezado() {
    int numeroFilasLlenas = contarFilas();
    for (int fila = 1; fila <= numeroFilasLlenas; fila++) {
      hojaExcel.removeRow(hojaExcel.getRow(fila));
    }
  }

  public static void escribirExcelXfila(List<String> lista2, String rutaArchivoExcel) {
    XSSFRow fila;
    try {
      int numeroFilaLlenas = contarFilas();
      fila = hojaExcel.createRow(numeroFilaLlenas + 1);
      int i = 0;
      while (i < lista2.size()) {
        for (String valorObtenido : lista2) {
          modificarDatoCelda(fila.getRowNum(), i, valorObtenido);
          guardarArchivoExcel(rutaArchivoExcel);
          i++;
        }
      }
    } catch (Exception e) {
      LOGGER.info("No fue posible escribir en la fila", e);
    }
  }

  public static void guardarArchivoExcel(String rutaArchivoExcel) {
    try {
      FileOutputStream outputStream = new FileOutputStream(rutaArchivoExcel);
      libroExcel.write(outputStream);
      outputStream.close();
    } catch (Exception e) {
      LOGGER.info("No fue posible guardar el archivo de Excel", e);
    }
  }
}
