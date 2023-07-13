package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
Logger logger= LoggerFactory.getLogger(ApplicationManager.class);
   // WebDriver wd;
   EventFiringWebDriver wd;
    HelperUser user;
    HelperCar car;
    HelperSearch search;

    public HelperSearch getSearch() {
        return search;
    }

    String browser;
    public ApplicationManager(String browser) {
        this.browser = browser;
    }
    public HelperUser getUser() {
        return user;
    }
    public HelperCar getCar() {
        return car;
    }

    @BeforeSuite
    public void init(){
       // wd = new ChromeDriver();
        if(browser.equals(BrowserType.CHROME)){
            wd=new EventFiringWebDriver(new ChromeDriver());
        }
        else if (browser.equals(BrowserType.FIREFOX))
        {
            wd=new EventFiringWebDriver(new FirefoxDriver());
        }

        wd.register(new WdListener());
        user = new HelperUser(wd);
        car = new HelperCar(wd);
        search=new HelperSearch(wd);
       wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.web.app/search");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown(){
      //  wd.quit();
    }
}