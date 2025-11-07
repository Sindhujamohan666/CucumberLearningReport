package com.thetestingacademy.base;

import com.thetestingacademy.driver.DriverManagerTL;
//Note :This should be of cucumber else null pointer exception if it is of junit.
import io.cucumber.java.Before;
import io.cucumber.java.After;


public class CommonToAllTest {
    @Before
    public void setup(){
        DriverManagerTL.init();
    }
    @After
    public void teardown(){
        DriverManagerTL.down();
    }

}
