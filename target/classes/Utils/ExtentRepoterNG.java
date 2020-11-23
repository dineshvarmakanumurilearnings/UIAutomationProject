package Utils;

import java.util.Date;
import java.util.Locale;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.model.Author;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import jxl.write.DateFormat;

public class ExtentRepoterNG {
	 
	
	  
	public static ExtentReports extentReportGenerator() {
		Date date = new Date();
		java.text.DateFormat df = java.text.DateFormat.getDateInstance(0, Locale.UK);
		String rName = df.format(date);
		 String path = System.getProperty("user.dir")+"\\reports\\"+rName+".html";
		 ExtentSparkReporter repoter = new ExtentSparkReporter(path);
		 repoter.config().setReportName("Flipkart regression report");
		 repoter.config().setDocumentTitle("Flipkart results");
		 repoter.config().setTheme(Theme.DARK);
		 
		
		 ExtentReports extent = new ExtentReports();
		 extent.attachReporter(repoter);
		 extent.setSystemInfo("Tester", "Dinesh Varma");
		
		 
		  return extent;
	 }
	

}
