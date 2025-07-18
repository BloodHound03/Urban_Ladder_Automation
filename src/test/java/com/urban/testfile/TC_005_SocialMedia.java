package com.urban.testfile;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.urban.base.BaseClass2;
import com.urban.pageObject.HomePage;

public class TC_005_SocialMedia extends BaseClass2 {

	HomePage home;

//	@Test()
//	public void testTwitterLink() throws InterruptedException {
//		home = new HomePage(BaseClass2.driver);
//		home.scrollToFooter();
//		Assert.assertTrue(home.validateSocialLink("x", "//a[contains(@href,'twitter')]"), "Twitter link failed.");
//		
//		Assert.assertTrue(home.validateSocialLink("youtube", "//a[contains(@href,'youtube')]"), "YouTube link failed.");
//		
//		Assert.assertTrue(home.validateSocialLink("pinterest", "//a[contains(@href,'pinterest')]"), "Pinterest link failed.");
//	}

    @Test(priority = 1)
    public void testTwitterLink() throws InterruptedException {
    	home = new HomePage(BaseClass2.driver);
        home.scrollToFooter();
        Assert.assertTrue(home.validateSocialLink("x", "//a[contains(@href,'twitter')]"), "Twitter link failed.");
    }
 
    @Test(priority = 2)
    public void testYoutubeLink() throws InterruptedException {
        Assert.assertTrue(home.validateSocialLink("youtube", "//a[contains(@href,'youtube')]"), "YouTube link failed.");
    }
 
    @Test(priority = 3)
    public void testPinterestLink() throws InterruptedException {
        Assert.assertTrue(home.validateSocialLink("pinterest", "//a[contains(@href,'pinterest')]"), "Pinterest link failed.");
    }
}