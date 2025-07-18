// Source code is decompiled from a .class file using FernFlower decompiler.
package com.urban.testfile;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.urban.base.BaseClass2;
import com.urban.pageObject.BasePage;
import com.urban.pageObject.BookshelfPage;
import com.urban.pageObject.HomePage;
import com.urban.utillities.ExcelUtil;
import com.urban.utillities.ScreenShot;

public class TC_001_BookShelves extends BaseClass2 {
	HomePage home;
	BookshelfPage shelf;

	@Test
	public void BookShelves() throws InterruptedException {
		home = new HomePage(BaseClass2.driver);
		home.clickBookshelf();
		BasePage.popupHandle();
		shelf = new BookshelfPage(BaseClass2.driver);
		shelf.setPriceFilter();
		shelf.selectOpenStorageType();
		shelf.filterInStock();
		ScreenShot.captureScreenshot(driver, "Products");
		BaseClass2.getLogger().info("Products displyed");
		LinkedHashMap<String, String> products = shelf.getTopProducts(6);
		int r = 0;

		for (Map.Entry<String, String> entry : products.entrySet()) {
			int rowNum = r + 1;
			ExcelUtil.writeDataIntoExcel("BookShelves", rowNum, 0, entry.getKey());
			ExcelUtil.writeDataIntoExcel("BookShelves", rowNum, 1, entry.getValue());
			r++;
		}

	}
}
