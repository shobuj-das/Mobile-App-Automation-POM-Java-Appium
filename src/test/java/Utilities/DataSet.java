package Utilities;

import org.testng.annotations.DataProvider;

public class DataSet {
    @DataProvider(name = "invalidLoginData")
    public Object[][] getInvalidLoginData(){
        return new Object[][]{
                // username, password, error message , type
                {"","","Username is required","username"},
                {"","10203040","Username is required","username"},
                {"bob@example.com", "", "Password is required", "password"},
                {"bob@example.com", "32342343", "Provided credentials do not match any user in this service.", "login"},
                {"invalid@example.com", "10203040", "Provided credentials do not match any user in this service.", "login"}
        };
    }
}
