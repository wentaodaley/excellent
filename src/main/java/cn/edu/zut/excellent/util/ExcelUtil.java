package cn.edu.zut.excellent.util;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
public class ExcelUtil {

    public static HSSFWorkbook excelFactory(Excel excel){
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(excel.getSheet());
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        if(excel.getValue()==0) {
            HSSFRow row = sheet.createRow(0);

            style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

            HSSFCell cell;
            for (int i = 0, l = excel.getHeader().length; i < l; i++) {
                cell = row.createCell(i);
                cell.setCellValue(excel.getHeader()[i]);
                cell.setCellStyle(style);
            }

            // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
            for (int i = 0, l = excel.getCount().length; i < l; i++) {
                row = sheet.createRow(i + 1);
                for (int j = 0, k = excel.getCount()[i].length; j < k; j++) {
                    row.createCell(j).setCellValue("" + excel.getCount()[i][j]);
                }

            }
        }else{
            HSSFRow row;
            HSSFCell cell;
            int n = 0;
//            for (int i = 0,l=excel.getRowNodes().size(); i<l;i++) {
//                r = excel.getRowNodes().get(i);
//                row = sheet.createRow(r.get(i).get);
//            }
            row = sheet.createRow(0);
//            cell = row.createCell(0);
//            cell.setCellValue("2016届毕业设计（论文）答辩成绩汇总表");
//            cell.setCellStyle(style);
//            row = sheet.createRow(1);
//            cell = row.createCell(0);
//            cell.setCellValue("部门盖章：            院长（主任）审核签字：                   指导教师：                       年  月  日\t\t\t\t\t\t\t\t\t\t\t\t");
//            cell.setCellStyle(style);
            for (int i = n, l = excel.getHeader().length; i < l; i++) {
                cell = row.createCell(i);
                cell.setCellValue(excel.getHeader()[i]);
                cell.setCellStyle(style);
            }
            n++;
            // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
            for (int i = n, l = excel.getCount().length; i < l; i++) {
                row = sheet.createRow(i + 1);
                for (int j = 0, k = excel.getCount()[i].length; j < k; j++) {
                    row.createCell(j).setCellValue("" + excel.getCount()[i][j]);
                }

            }
        }
        return wb;
    }

    public static void main(String[] args) {
        // 第六步，将文件存到指定位置
        try
        {
            Excel excel = new Excel();
            excel.setSheet("sheel");
            excel.setHeader(new String[10]);
            excel.setCount(new String[10][10]);
            for (int i = 0, l = 10 ;i <l ;i ++){
                excel.getHeader()[i] = ""+i;
            }
            for (int i = 0, l = 10 ;i <l ;i ++){
                for (int j=0; j<l; j++){
                    excel.getCount()[i][j] = ""+i*j;
                }
            }
            FileOutputStream fout = new FileOutputStream(new File("str.xls"));
            ExcelUtil.excelFactory(excel).write(fout);
            
            fout.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
