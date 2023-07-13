package manager;
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }
    public void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
      //  element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size() > 0;

    }
    //HW:10
    //1. доработать метод заполнения формы добавления автомобиля в проекте ILCarro так, чтобы поле Car registration number
    // заполнялось через клик по координатам
    public void typeByXY(By locator, String RegNumb) {

      WebElement element=wd.findElement(locator);
        Actions actions = new Actions(wd);
        actions.moveToElement(element);
        element.clear();
        element.sendKeys(RegNumb);


   // ne pravilno
//         Rectangle rect = wd.findElement(locator).getRect();
//
//        int x = rect.getX() + rect.getWidth() / 2 + 20;
//        int y = rect.getY() + rect.getHeight() / 2 + 10;
//        Actions actions = new Actions(wd);
//        actions.moveByOffset(x, y).click().sendKeys(RegNumb);
    }

public  void  takeScreenshot(String link){
        File tmp=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        File screenshot=new File(link);
    try {
        Files.copy(tmp, screenshot);
    } catch (IOException e) {
        e.printStackTrace();
    }
}






}
