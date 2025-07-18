package com.urban.testfile;
 
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.urban.base.BaseClass2;
import com.urban.pageObject.HomePage;
import com.urban.utillities.ExcelUtil;
 
public class TC_003_Cities extends BaseClass2{
 
    WebDriver driver;
    HomePage home;
 
    @Test
    public void testStoreStatesDisplay() throws InterruptedException {
    	home = new HomePage(BaseClass2.driver);
        home.hoverOverStoresTab();
        List<String> states= home.getStoreStates(); // This prints all store locations
        int r=1;
        for(String state: states) {
        	ExcelUtil.writeDataIntoExcel("Cities", r++, 0, state);
        }
    }
 
    
}