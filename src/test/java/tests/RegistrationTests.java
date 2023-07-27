package tests;

import manager.ProviderData;
import manager.TestNgListener;
import models.User;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestNgListener.class)
public class RegistrationTests extends TestBase{
    EventFiringWebDriver wd;
    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(app.getUser().isLogged())
            app.getUser().logout();

    }

    @Test(groups = {"regress,positive"},alwaysRun = true)
    public void registrationAbPositive(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .withName("John")
                .withLastName("Snow")
                .withEmail("ajjgyt_" + i + "@mail.com")
                .withPassword("$Asdf1234");

        app.getUser().openRegistrationForm();
        logger.info("openRegistrationForm invoked");
        app.getUser().fillRegistrationForm(user);
        logger.info("fillRegistrationForm invoked");
        app.getUser().submitLogin();
        logger.info("submitLogin invoked");
        logger.info("RegistrationPositive starts with credentials:login  "
                + user.getEmail()+" and password:  "+ user.getPassword());
        Assert.assertTrue(app.getUser().isLoggedSuccess());
       // app.getUser().clickOkButton();

    }
    @Test(groups ={"regress,negative"},alwaysRun = true)
    public void registrationNegativePassword(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .withName("John")
                .withLastName("Snow")
                .withEmail("nalc_" + i + "@mail.com")
                .withPassword("Asdf1234");

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitLogin();
logger.info("RegistrationNegativePassword starts with credentials"
        + user.getEmail()+" and "+ user.getPassword());
        Assert.assertTrue(app.getUser().isRegistrationSuccess());
      //  app.getUser().clickOkButton();
    }
    @Test(groups ={"smoke,negative"},alwaysRun = true)
    public void registrationAzNegativeWrongEmail(){
       // int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .withName("John")
                .withLastName("Snow")
                .withEmail("@mail.com")
                .withPassword("!Asdf1234");

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitLogin();
        logger.info("RegistrationNegativePassword starts with credentials"
                + user.getEmail()+" and "+ user.getPassword());
        Assert.assertTrue(app.getUser().isRegistrationSuccessEmailWrong());
      //  app.getUser().clickOkButton();
    }
    //@Test(groups = {"smoke,positive"},dataProvider ="userDtoCSV",dataProviderClass = ProviderData.class,alwaysRun = true)
    public void registrationPositiveDTO(User user){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
//        User user = new User()
//                .withName("John")
//                .withLastName("Snow")
//                .withEmail("oleg_" + i + "@mail.com")
//                .withPassword("$Asdf1234");

        app.getUser().openRegistrationForm();
        logger.info("openRegistrationForm invoked");
        app.getUser().fillRegistrationForm(user);
        logger.info("fillRegistrationForm invoked");
        app.getUser().submitLogin();
        logger.info("submitLogin invoked");
        logger.info("RegistrationPositive starts with credentials:login  "
                + user.getEmail()+" and password:  "+ user.getPassword());
        Assert.assertTrue(app.getUser().isLoggedSuccess());
       // app.getUser().clickOkButton();
    }
//    @Test
//    public void registrationNegativeWrongEmail() {
//        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
//        String email = "oleg" + i + "@mail.ru";
//        String password = "Oleg1980!";
//        app.getUser().openLoginForm();
//        app.getUser().fillLoginForm(email, password);
//        app.getUser().submitLogin();
//        app.getUser().clickOkButton();
//        Assert.assertTrue();
//    }
    @AfterMethod(alwaysRun = true)

    public void postcondition(){
        app.getUser().clickOkButton();
        if (app.getUser().isRegistrationSuccess()==true)
        app.getUser().clickOkButton();
        app.getUser().pause(3000);


    }

}
