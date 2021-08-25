package com.softserve.edu.opencart.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.User;

public class RegisterTest extends TestRunner {

    @DataProvider
    public Object[][] dataRegister() {
        //
        User user = new User(); // TODO
        return new Object[][] {
            { user },
        };
    }

    @Test(dataProvider = "dataRegister")
    public void checkRegister(User user) {
        //
        // TODO
        //
    }
    
}
