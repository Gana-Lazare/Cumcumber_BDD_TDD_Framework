package common;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.io.FileInputStream;
import java.util.ArrayList;

public class DataReader {


    public static int rowNUmber=0,numofCol=0,numofRows=0;

    public  String[] getDataFromeExcelFile(){
        String[] mydata={};
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\micromedia\\IdeaProjects\\SeleniumFrameWorkGana\\Unitedhealth\\AmazonUtility\\dataProvide.xlsx");
            HSSFWorkbook wb = new HSSFWorkbook(fis);
            HSSFSheet sheet = wb.getSheetAt(0);
            numofRows =sheet.getLastRowNum();
            numofCol=sheet.getRow(0).getLastCellNum();
         mydata=new String[numofRows+1];

        }
        catch (Exception e ){}
        return mydata;
    }
    public String getCellValue(XSSFCell cell){
        Object value = null;
        CellType dataType = cell.getCellType();
        switch (dataType){
            case NUMERIC:
                value=cell.getNumericCellValue();
            break;
            case BOOLEAN:
                value=cell.getBooleanCellValue();
            break;
            case STRING:
                value=cell.getStringCellValue();
            break;
        }
        return value.toString();
    }
}
