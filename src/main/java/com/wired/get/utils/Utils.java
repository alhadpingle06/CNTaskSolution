package com.wired.get.utils;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;
/**
 * @author Alhad Pingle
 * This class handles on-demand screenshot of AUT and some other general utilities
 */


public class Utils {

	static ArrayList<String> testCaseNames = new ArrayList<String>();

	public static String getDateTimeStamp(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date).toString().replace(" ", "").replace(":","").replace("/", "");
	}

	public static String getScreenshotPath(String str) throws IOException, AWTException{
		String fileName = str+"_"+ getDateTimeStamp();
		String fileAt = GlobalVariables.screenshotsFolder+"\\"+fileName+".png";
		
		File srcFile = ((TakesScreenshot)GlobalVariables.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(fileAt));



		return  new File(fileAt).getAbsolutePath();

	}
	public static  void reportLogScreenshot(File file) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");

		String absolute = file.getAbsolutePath(); 

		String relative = absolute.replace(".\\","");
		String screenShot = relative.replace('\\','/');

		Reporter.log("<a href=\"" + screenShot + "\"><p align=\"left\">Error screenshot at " + new Date()+ "</p>");
		Reporter.log("<p><img width=\"1024\" src=\"" + file.getAbsoluteFile()  + "\" alt=\"screenshot at " + new Date()+ "\"/></p></a><br />"); 
		
//		GlobalVariables.extentTestAndroid.log("Screenshot captured -> " + "<a href='file:///"+folderName + currentMTA + "-"+ fileName+ ".png'>Screenshot</a>");
		GlobalVariables.extentTestAndroid.log(Status.INFO, "Screenshot captured -> " + "<a href=\"" + screenShot + "\">Screenshot</a>");
	}

	public static String getScreenShot(String str){
		try {
			String path=Utils.getScreenshotPath(str);
			Utils.reportLogScreenshot(new File(path));
			return path;
		} 
		catch (IOException e) {
			e.printStackTrace();
			return "";
		} 
		catch (AWTException e) {
			e.printStackTrace();
			return "";
		}
	}
	public static String getResultFolder(){
		String timeStamp = getDateTimeStamp();
		String resultFolder = "target\\reports\\"+"TestRunID_"+timeStamp;	          
		new File(resultFolder).mkdir();
		return resultFolder;
	}
	public static void staticWait(long time){
		try {
			Thread.sleep(time);			
		}
		catch (InterruptedException ie){
			ie.printStackTrace();
		}
	}



	public static ArrayList<String> getExecutableTestCases() {
		// TODO Auto-generated method stub

		if (testCaseNames.isEmpty()) {

			try {
				Sheet loginSheet = Utils.getExcelSheet();
				//Find number of rows in excel file
				int rowCount = loginSheet.getLastRowNum()-loginSheet.getFirstRowNum();

				//Create a loop over all the rows of excel file to read it
				for (int i = 1; i < rowCount+1; i++) {
					Row row = loginSheet.getRow(i);
					if (row.getCell(1).getStringCellValue().equalsIgnoreCase("Yes")) {
						testCaseNames.add(row.getCell(0).getStringCellValue());
					}

				}
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
		return testCaseNames;
	}

	public static Sheet getExcelSheet() {
		// TODO Auto-generated method stub

		Sheet loginSheet = null;

		try {

			//			Read an excel file sheet as per the suite name.

			//Create a object of File class to open xlsx file

			String fileName = "TestExecutor.xlsx";

			File file =    new File("src\\test\\resources\\TestConfig" + "\\" + fileName);


			//Create an object of FileInputStream class to read excel file
			FileInputStream inputStream = new FileInputStream(file);

			Workbook loginWorkbook = null;
			//Find the file extension by spliting file name in substring and getting only extension name
			String fileExtensionName = fileName.substring(fileName.indexOf("."));

			//Check condition if the file is xlsx file
			if(fileExtensionName.equals(".xlsx")){

				//If it is xlsx file then create object of XSSFWorkbook class
				loginWorkbook = new XSSFWorkbook(inputStream);
			}

			//Check condition if the file is xls file
			else if(fileExtensionName.equals(".xls")){
				//If it is xls file then create object of XSSFWorkbook class
				loginWorkbook = new HSSFWorkbook(inputStream);
			}
			
			loginSheet = loginWorkbook.getSheet(GlobalVariables.suiteName);

		}
		catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}

		return loginSheet;
	}

}




