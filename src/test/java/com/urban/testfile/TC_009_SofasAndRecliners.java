package com.urban.testfile;
 
import java.util.ArrayList;
import java.util.List;
 
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
 
import com.urban.base.BaseClass;
import com.urban.base.BaseClass2;
import com.urban.pageObject.HomePage;
import com.urban.utillities.ExcelUtil;
 
public class TC_009_SofasAndRecliners extends BaseClass2 {
	
	
	
	@Test
	public void testRun() {
		HomePage home = new HomePage(BaseClass2.driver);
		home.moveToElement();
		home.listItems();
//		List<List<WebElement>> resultList = home.listItems();
//		List<WebElement> items = new ArrayList<>();
//		int r = 1;
//		int c = 0;
//		for(int i = 0 ; i < resultList.size() ; i++) {
//			int r = 1;
//			items = resultList.get(i);
//			for(int j = 0 ; j < items.size() ; j++) {
//				ExcelUtil.writeDataIntoExcel("SofasAndRecliners", r, c, items.get(j).getText());
//				r++;
//			}
//			c++;
//		}
	}
	
}