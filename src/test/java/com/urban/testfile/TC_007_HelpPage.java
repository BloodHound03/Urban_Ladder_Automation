package com.urban.testfile;

import java.util.List;

import org.testng.annotations.Test;

import com.urban.base.BaseClass;
import com.urban.base.BaseClass2;
import com.urban.pageObject.HelpPage;
import com.urban.utillities.ExcelUtil;

public class TC_007_HelpPage extends BaseClass2{
	HelpPage helpPage;
	
	@Test()
    public void writeHelpFAQsToSheet2() throws InterruptedException {
		
		helpPage = new HelpPage(BaseClass2.driver);
        helpPage.navigateToHelpSection();
        helpPage.expandAllAnswers();
 
        List<String> questions = helpPage.getQuestionsList();
        List<String> answers = helpPage.getCleanAnswersList(questions);
 
        String filePath = System.getProperty("user.dir") + "/src/test/resources/ProjectData.xlsx";
        ExcelUtil.appendHelpFAQsToSheet(filePath, "Sheet2", questions, answers);
    }
}
