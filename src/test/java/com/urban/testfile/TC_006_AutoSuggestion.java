package com.urban.testfile;
 
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.urban.base.BaseClass2;
import com.urban.pageObject.HomePage;
import com.urban.utillities.ExcelUtil;
 
public class TC_006_AutoSuggestion extends BaseClass2{
    
    HomePage home;
 
    @Test
    public void testAutoSuggestionsAndExportToExcel() {
    	home = new HomePage(BaseClass2.driver);
        String keyword = "bed";
//        page.closePopupIfVisible();
        home.search(keyword);
 
        List<WebElement> suggestions = home.getSuggestions();
        System.out.println("Auto-suggestions found: " + suggestions.size());
 
        String[] suggestionTexts = new String[suggestions.size()];
        int r=0;
        for (int i = 0; i < suggestions.size(); i++) {
        	int rowNum=r+1;
            String text = suggestions.get(i).getText();
            suggestionTexts[i] = text;
            System.out.println("Suggestion: " + suggestionTexts[i]);
            ExcelUtil.writeDataIntoExcel("AutoSuggestion", rowNum, 1, suggestionTexts[i]);
            r++;
        }
    }
 
}
 
 
 