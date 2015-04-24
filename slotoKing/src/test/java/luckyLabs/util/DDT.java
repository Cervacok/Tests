package luckyLabs.util;

import java.io.File;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DDT {

  String filePath = null;
  private Sheet sheet = null;

  public DDT(String filePath) throws IOException {
    this.filePath = filePath;
    getDataFromXL(this.filePath);
  }

  public String getData(int row, int cell) {
    return sheet.getCell(row, cell).getContents();
  }

  private void getDataFromXL(String filePath) throws IOException {
    File inputWorkbook = new File(filePath);
    Workbook w;
    try {
      w = Workbook.getWorkbook(inputWorkbook);
      sheet = w.getSheet(0);
    } catch (BiffException e) {
      e.printStackTrace();
    }

  }
}