package com.urban.testfile;
 
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 
import com.urban.base.BaseClass;
import com.urban.base.BaseClass2;
import com.urban.pageObject.HomePage;
import com.urban.pageObject.TrackDetails;
import com.urban.utillities.ExcelUtil;
import com.urban.utillities.TrackOrderxml;
 
public class TC_010_TrackOrder extends BaseClass2 {
	
	
	@Test(priority = 1)
	public void beforerun() {
		HomePage home = new HomePage(BaseClass2.driver);
		home.click();
	}
	@Test(priority = 2)
	public void testRun() {
 
		TrackDetails td = new TrackDetails(BaseClass2.driver);
		String[] details = TrackOrderxml.getInput();
		int r = 1;
		for(int i = 0 ; i < details.length ; i = i+2) {
//			int c = 0;
			td.orderInput(details[i]);
			td.phoneNoInput(details[i+1]);
			td.Click();
			String msg = td.message();
			driver.navigate().refresh();
			for(int j = 0 ; j < (details.length / 2)+1 ; j++) {
				ExcelUtil.writeDataIntoExcel("TrackOrder", r, 0, details[i]);
				ExcelUtil.writeDataIntoExcel("TrackOrder", r, 1, details[i+1]);
				ExcelUtil.writeDataIntoExcel("TrackOrder", r, 2, msg);
//				c++;
			}
			r++;
		}
		
	}
 
	
}