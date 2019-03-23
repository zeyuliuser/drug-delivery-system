package com.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.entity.Drug;



public class ExcelUtil {
	
	Drug drug =new Drug();
	
	public List<Drug> ExcelToList(String path) throws IOException {
		int i;
		List<Drug> array = new ArrayList<>();
		InputStream iStream= new FileInputStream(path);

		/*POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("C:\\Users\\LZY\\drug-delivery-system\\WebContent\\WEB-INF\\file/drugimport.xls"));*/
		@SuppressWarnings("resource")
		XSSFWorkbook workbook= new XSSFWorkbook(iStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int lastrow = sheet.getLastRowNum();
		if(lastrow>=1) {
			for(i=1;i<=lastrow;i++) {
				Drug drug= new Drug();
				drug.setDid((int)Double.parseDouble(sheet.getRow(i).getCell(0).toString()));
				drug.setDname(sheet.getRow(i).getCell(1).toString());
				drug.setSize_length_cm(Double.parseDouble(sheet.getRow(i).getCell(2).toString()));
				drug.setSize_width_cm(Double.parseDouble(sheet.getRow(i).getCell(3).toString()));
				drug.setSize_high_cm(Double.parseDouble(sheet.getRow(i).getCell(4).toString()));
				drug.setWeigth_g(Double.parseDouble(sheet.getRow(i).getCell(5).toString()));
				if (sheet.getRow(i).getCell(6)!=null) {										
					drug.setDpic(sheet.getRow(i).getCell(6).toString());
				}else {
					drug.setDpic(null);
				}
				
				drug.setDdesc(sheet.getRow(i).getCell(7).toString());
				drug.setPrice(Double.parseDouble(sheet.getRow(i).getCell(8).toString()));
				drug.setFirstclass(sheet.getRow(i).getCell(9).toString());
				drug.setSecondclass(sheet.getRow(i).getCell(10).toString());
				drug.setThirdclass(sheet.getRow(i).getCell(11).toString());
				drug.setIsrx(sheet.getRow(i).getCell(12).toString());
				array.add(drug);		
			}
		}
		else {
			System.out.println("null");
		}
		              
		return array;
	}

}
