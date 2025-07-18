package com.urban.testfile;
 
import org.testng.annotations.Test;

import com.urban.base.BaseClass2;
import com.urban.pageObject.BasePage;
import com.urban.pageObject.BeingAtHome;
import com.urban.pageObject.HomePage;
import com.urban.utillities.Beingxml;
 
 
public class TC_008_BeingAtHome extends BaseClass2 {
	
	HomePage home;
	BeingAtHome bah;
	
	@Test
	public void testRun() throws InterruptedException {
		home = new HomePage(BaseClass2.driver);
		bah = new BeingAtHome(BaseClass2.driver);
		String searchTerm = Beingxml.getInput();
		home.searchField(searchTerm);
		home.clickSearchIcon();
		BasePage.popupHandle();
		bah.category();
		bah.categoryItems();
//		WaitUtils.waitForVisibility(driver, categoryItemsList.get(0), 10);
//		for(WebElement item : categoryItemsList) {
//			String itemName = item.getText();
//			System.out.println(item.getText());
//			ExcelUtil.writeDataIntoExcel("BeingAtHome", r, 1, itemName);
//			r++;
//		}
	}
}
 
 
	