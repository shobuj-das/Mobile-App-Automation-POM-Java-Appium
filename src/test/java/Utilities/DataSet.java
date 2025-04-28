package Utilities;

import org.testng.annotations.DataProvider;

public class DataSet {
    @DataProvider(name = "invalidLoginData")
    public Object[][] getInvalidLoginData(){
        return new Object[][]{
                {"","","Username is required"},
                {"","10203040","Username is required"},
                {"bob@example.com", "", "Password is required"},
                {"bob@example.com", "32342343", "Provided credentials do not match any user in this service."},
                {"invalid@example.com", "10203040", "Provided credentials do not match any user in this service."}
        };
    }
}
