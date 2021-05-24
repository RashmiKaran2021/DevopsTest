package cpqDevops;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readReleaseNum {


	private static String strStatus,strStatusValue,current_Input_dri,current,status,strRuleValue,ReleaseNum;	
	//static String downloadFilepath = "C:\\Users\\subhajit.pal\\workspace\\Cpq_Automation\\workspace\\"; 
	static String excelFilePath,propertiesfile;
	public static Logger logger = Logger.getLogger("OIC Migration Logs"); 	
	
	public static void main(String[] agrs)throws Exception  
    {
    try {
    	excelFilePath = agrs[0];
    	propertiesfile = agrs[1];	
    	readReleaseNum rNum = new readReleaseNum();
    	rNum.excelScrFold();
		current = System.getProperty("user.dir");
	    //current_Input_dri = current +"\\" ;	
		propertiesfile = propertiesfile +"/" ;	
	    FileWriter writerSh = new FileWriter(propertiesfile+"reNum.properties");
	    writerSh.write(ReleaseNum);
	    writerSh.close();
    }
    catch(Exception e) {
    	e.printStackTrace();
    }
}
	public String excelScrFold() throws Exception 
	
	{

			//String excelFilePath = downloadFilepath+"CPQ_Component.xlsx"; 
			 try{				 
				  InputStream ExcelFileToRead = new FileInputStream(excelFilePath);
					XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
					//XSSFWorkbook test = new XSSFWorkbook(); 
				    XSSFSheet sheet = wb.getSheetAt(0);
				    XSSFRow row,rowvalue;
				    Iterator<Row> rows = sheet.rowIterator();
				    row = sheet.getRow(0);
				    int i=0;
				    int j=0;
				    try {
				    	
							if(row.getCell(0).toString().equalsIgnoreCase("Release Number=")){
							ReleaseNum = row.getCell(1).toString().trim();
							//System.out.println(ReleaseNum);
							}else {
							System.out.println("Incorrect format");
							}						
					   } 
					    catch (NullPointerException e) 
					    {
					    	logger.info("System Error: "+e.toString());
					   }  
				    }
			 
			 
			 catch(Exception ioe) 
			 {
				 logger.info("System Error: "+ioe.toString());
				 ioe.printStackTrace();
			 }			 
			 return ReleaseNum;	  
	}
}
