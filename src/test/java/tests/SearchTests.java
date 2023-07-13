package tests;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class SearchTests extends  TestBase {
    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        if (app.getUser().isLogged()) app.getUser().logout();

    }
    @Test(groups={"search","positive"})
    public void searchPositive(){
        Car car= Car.builder()
                .searchCity("Tel Aviv, Israel")
                .searchDate("10/21/2023-11/7/2023")
                . build();
        app.getSearch().fillSearchForm(car);
        app.getUser().submitLogin();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//label[.=' Search ']")));

    }
 //   @Test(groups={"search","positive"})
    public void searchPositive1(){

        Car car= Car.builder()
                .searchCity("Tel Aviv, Israel")
                .searchDate("10/21/2023-11/7/2023")
                . build();
        app.getSearch().fillSearchForm(car);
        app.getUser().submitLogin();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//label[.=' Search ']")));

    }
  //  @Test
    public void searchNegativeCity(){
        Car car= Car.builder()
                .searchCity("")
                .searchDate("10/21/2023-11/7/2023")
                . build();
        app.getSearch().fillSearchForm(car);

        app.getUser().submitLogin();

       // Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//div[contains(text(),'City is required')]")));

    }
   // @Test
    public void searchNegativeDate(){
        Car car= Car.builder()
                .searchCity("Tel Aviv, Israel")
                .searchDate("10/21/2023-11/7/2023")
                . build();
        app.getSearch().fillSearchForm(car);
        app.getUser().submitLogin();

        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//label[.=' Search ']")));

    }
}