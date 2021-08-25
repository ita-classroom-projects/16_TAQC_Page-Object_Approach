package com.softserve.edu.opencart.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.pages.EditAccountPage;
import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.pages.UnsuccessfulLoginPage;

public class LoginTest extends TestRunner {

    @DataProvider
    public Object[][] dataSuccessful() {
        return new Object[][] {
            { "xdknxusqvjeovowpfk@awdrt.com", "awdrt123", "my" },
        };
    }

    @Test(dataProvider = "dataSuccessful")
    public void checkSuccessful(String email, String password, String firstName) {
        //
        // Steps
        EditAccountPage editAccountPage = loadApplication()
                .gotoLoginPage()
                .successfulLogin(email, password)
                .gotoEditAccountRight();
        presentationSleep();
        //
        // Check
        Assert.assertEquals(editAccountPage.getFirstNameFieldText(), firstName);
        //
        // Return to Previous State
        HomePage homePage = editAccountPage
                .gotoContinue() // optional
                .gotoLogoutRight()
                .gotoContinue();
        //
        // Check
        Assert.assertTrue(homePage
                .getSlideshow0FirstImageAttributeSrcText()
                .contains(HomePage.EXPECTED_IPHONE6));
        presentationSleep();
    }
    
    @DataProvider
    public Object[][] dataUnsuccessful() {
        return new Object[][] {
            { "invalid@awdrt.com", "pass", "not" },
        };
    }
    
    @Test(dataProvider = "dataUnsuccessful")
    public void checkUnsuccessful(String email, String password, String firstName) {
        //
        // TODO
        //
    }

}
