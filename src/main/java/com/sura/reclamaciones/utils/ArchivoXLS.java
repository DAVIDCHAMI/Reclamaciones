package com.sura.reclamaciones.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ArchivoXLS {

  private static XSSFSheet hojaXls;
  private static XSSFWorkbook libroXls;
  private static XSSFCell celda;
  private static XSSFRow fila;

  public static void abrirArchivoXls(String rutaArchivoXls, String nombreHojaArchivoXls)
      throws Exception {
    FileInputStream archivoXls = new FileInputStream(rutaArchivoXls);
    libroXls = new XSSFWorkbook(archivoXls);
    hojaXls = libroXls.getSheet(nombreHojaArchivoXls);
  }

  public static String getCellData(int RowNum, int ColNum) throws Exception {
    String CellData = "";
    try {
      celda = hojaXls.getRow(RowNum).getCell(ColNum);
      if (celda.getCellType() == 1) {
        CellData = celda.getStringCellValue();
      }
      if (celda.getCellType() == 0) {
        CellData = celda.getRawValue();
      }
      return CellData;
    } catch (Exception e) {
      return "";
    }
  }

  public static void setCellData(int RowNum, int ColNum, String valorObtenido) throws Exception{
    try{
      boolean valorCorrecto = valorObtenido.matches("^(?:3[01]|[12][0-9]|0?[1-9])([\\-/.])(0?[1-9]|1[1-2])\\1\\d{4}$");
      if(valorCorrecto){
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(valorObtenido);
        CellStyle cellStyle = libroXls.createCellStyle();
        cellStyle.setDataFormat(libroXls.createDataFormat().getFormat("dd/mm/yyyy"));
        hojaXls.getRow(RowNum).createCell(ColNum).setCellValue(date1);
        hojaXls.getRow(RowNum).getCell(ColNum).setCellStyle(cellStyle);
      }else {
        hojaXls.getRow(RowNum).createCell(ColNum).setCellValue(valorObtenido);
        hojaXls.getRow(RowNum).getCell(ColNum).setCellStyle(hojaXls.getColumnStyle(ColNum));
      }
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  public static int contarFilas() throws Exception {
    int NumFilas = hojaXls.getLastRowNum();
    return NumFilas;
  }

  public static int contarColumnasEncabezado() throws Exception {
    fila = hojaXls.getRow(0);
    int NumColum = fila.getLastCellNum();
    return NumColum;
  }

  public static void removerFilaSinEncabezado() throws Exception {
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
          Guardar(rutaArchivoXls);
          i++;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void Guardar(String rutaArchivoXls) throws IOException {
    try {
      FileOutputStream outputStream = new FileOutputStream(rutaArchivoXls);
      libroXls.write(outputStream);
      outputStream.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
