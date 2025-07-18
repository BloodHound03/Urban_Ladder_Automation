package com.urban.testfile;

import java.io.IOException;

import org.openqa.selenium.ElementNotInteractableException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.urban.base.BaseClass2;
import com.urban.pageObject.HomePage;
import com.urban.pageObject.Login;
import com.urban.utillities.ExcelUtil;

public class TC_004_Login extends BaseClass2 {
	HomePage home;
	Login login;

	@DataProvider(name = "LoginData")
	public String[][] loginDataProvider() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/resources/ProjectData.xlsx";
		int rowCount = ExcelUtil.getRowCount(path, "Sheet1");
		int colCount = ExcelUtil.getCellCount(path, "Sheet1", 0);

		String[][] loginData = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = ExcelUtil.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}

	@Test(dataProvider = "LoginData", priority = 0)
	public void loginTestFromExcel(String email, String password, String scenario) {
		home = new HomePage(BaseClass2.driver);
		login = new Login(BaseClass2.driver);

		home.hoverOverProfileIcon();
		System.out.println("Testing login with email: " + email);

		try {
			home.clickLogin();
		} catch (ElementNotInteractableException e) {
			System.out.println("Login button not interactable: " + e.getMessage());
		}

		scenario = scenario.trim().toLowerCase();

		login.clearEmailField();
		login.clearPasswordField();

		try {
			switch (scenario) {
			case "missing_email":
				login.enterPassword(password); // Only enter password
				break;
			case "missing_password":
				login.enterEmail(email); // Only enter email
				break;
			case "invalid_login":
			case "valid_login":
				login.enterEmail(email);
				login.enterPassword(password);
				break;
			default:
				System.out.println("Unknown scenario type: " + scenario);
			}

			login.submitLogin();

			switch (scenario) {
			case "missing_email":
				System.out.println("Email Error Message: " + login.getEmailErrorMessage());
				break;
			case "missing_password":
				System.out.println("Password Error Message: " + login.getPasswordErrorMessage());
				break;
			case "invalid_login":
				System.out.println("Login Error Message: " + login.getErrorMessage());
				break;
			case "valid_login":
				try {
					String loginError = login.getErrorMessage();
					System.out.println("Unexpected error message: " + loginError);
				} catch (Exception e) {
					System.out.println("Logged in Successfully");
					home.hoverOverProfileIcon();
					home.clickLogout();
					System.out.println("Logged out Successfully");
				}
				break;
			}
		} catch (Exception e) {
			System.out.println("Error handling login scenario: " + e.getMessage());
		}

		System.out.println("----------------------------------------");
	}
}
