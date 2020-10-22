package com.Sample;


import com.sample.pageFactory.DriverHelper;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;


public class Hooks {

    Scenario scenario;
    DriverHelper driverHelper;

    public Hooks(DriverHelper diHelper){
        this.driverHelper=diHelper;
    }


    @Before("@web")
    public void openBrowser(Scenario _scenario) throws IOException {
        this.scenario = _scenario;
        driverHelper.openBrowser( scenario );
    }
    @After("@web")
    public void close(){
        driverHelper.closeBrowser();
    }
}
