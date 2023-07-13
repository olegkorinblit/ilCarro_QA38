package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperSearch extends  HelperBase{
    public HelperSearch(WebDriver wd) {
        super(wd);
    }
    public void openSearchForm(){
        pause(3000);
        click(By.xpath("//a[@href='/search']"));

    }
    public void fillSearchForm(Car car) {
     //   if(isSearchFormPresent()==false) return;

        typeSearcCity(car.getSearchCity());
        type(By.id("dates"),car.getSearchDate());
    }

    private void typeSearcCity(String searchCity) {

            type(By.id("city"), searchCity);
            click(By.cssSelector("div.pac-item"));
        }


    public boolean isSearchFormPresent(){
        return new WebDriverWait(wd, 10)
                .until(ExpectedConditions
                        .textToBePresentInElement(
                                wd.findElement(By.xpath("h1")),
                                "Find your car now!"));
    }

public void ClickYalla( ){
    wd.findElement(By.xpath("//button[@type='submit']")).click();
}
    }

