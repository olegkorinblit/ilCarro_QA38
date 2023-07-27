package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperCar extends HelperBase{
    public  HelperCar(WebDriver wd) {
        super(wd);
    }


    public void openCarForm(){
        pause(2000);
        click(By.xpath("//a[.=' Let the car work ']"));

    }

    public void fillCarForm(Car car){
        pause(3000);
        if(isCarFormPresent()==false) return;
        typeLocation(car.getLocation());
        type(By.id("make"), car.getMake());
        type(By.id("model"), car.getModel());
        type(By.id("year"), car.getYear());
        select(By.id("fuel"), car.getFuel());
        type(By.id("seats"), car.getSeats());
        type(By.id("class"), car.getCarClass());
     // type(By.id("serialNumber"), car.getCarReqNumber());
        //clickSerialNumber(car.getCarReqNumber());
        typeByXY(By.id("serialNumber"), car.getCarReqNumber());
        pause(3000);
        type(By.id("price"), car.getPrice());
    }

    public void typeLocation(String address){
        type(By.id("pickUpPlace"), address);
        click(By.cssSelector("div.pac-item"));
    }

    public void select(By locator, String option){
        new Select(wd.findElement(locator)).selectByValue(option);
    }

    public boolean isCarFormPresent(){
//        return new WebDriverWait(wd, 5)
//                .until(ExpectedConditions
//                        .textToBePresentInElement(
//                                wd.findElement(By.cssSelector("h2")),
//                                "details"));
       return isElementPresent(By.xpath("//h2[.=' Write some details about your car to rent it out ']") );

   }

public  boolean isCarAdded(){
    return isElementPresent(By.xpath("//h1[.='Car added']"));
}
    public void clickSerialNumber(String text){

//        Rectangle rect = wd.findElement(By.id("serialNumber")).getRect();
        WebElement rect = wd.findElement(By.id("serialNumber"));
//        int x = rect.getX() + rect.getWidth() * 7 / 8;
//        int y = rect.getY() + rect.getHeight() / 2;
        Actions actions = new Actions(wd);
//        actions.moveByOffset(x, y).click().perform();
        actions.moveToElement(rect).click().perform();
        rect.clear();
        rect.sendKeys(text);
    }
}
