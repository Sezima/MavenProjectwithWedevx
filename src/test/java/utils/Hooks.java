package utils;

import io.cucumber.java.*;
import utils.DBUtils;
import utils.Driver;

import static utils.Driver.getDriver;

public class Hooks {

    @Before()
    public void establishConnectionToDB(Scenario scenario){
        DBUtils.establishConnection();
    }

//    @Before("not @Registration")
//    public void the_user_is_on_dbank_homepage() {
//
//        getDriver().get("https://dbank-qa.wedevx.co/bank/login");
//    }


    @After("not @NegativeRegistrationCases")
    public void afterEachScenario(Scenario scenario){
        Driver.takeScreenShot(scenario);
        Driver.closeDriver();
    }

    @AfterAll()
    public static void closeConnectionToDB(){
        DBUtils.closeConnection();
    }



//    @Before(order = 3)
//    public void setUp(){
//        System.out.println("Setting up in Cucumber before hooks");
//    }
//
//    @Before(order = 1)
//    public void setUpDatabase() {
//        // Code to set up database
//        System.out.println("Code to set up database before hooks");
//    }
//
//    @Before(order = 2, value = "@ui")
//    public void setUpWebdriver() {
//        // Code to set up webdriver
//        System.out.println("Code to set up webdriver before hooks");
//    }
//
//    @After
//    public void cleanUp(){
//        System.out.println("Clean up in Cucumber");
//    }
//
//    @BeforeAll
//    public static void globalSetup(){
//        System.out.println("It should run once before the entire suite");
//    }
}
