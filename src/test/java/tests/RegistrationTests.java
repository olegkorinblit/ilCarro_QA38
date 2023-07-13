package tests;

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
    @BeforeMethod
    public void precondition(){
        if(app.getUser().isLogged()) app.getUser().logout();

    }

    @Test
    public void registrationPositive(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .withName("John")
                .withLastName("Snow")
                .withEmail("oleg_" + i + "@mail.com")
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

    }
    @Test
    public void registrationNegativePassword(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .withName("John")
                .withLastName("Snow")
                .withEmail("oleg_" + i + "@mail.com")
                .withPassword("Asdf1234");

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitLogin();
logger.info("RegistrationNegativePassword starts with credentials"
        + user.getEmail()+" and "+ user.getPassword());
        Assert.assertTrue(app.getUser().isRegistrationSuccess());
    }
    @Test
    public void registrationNegativeWrongEmail(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
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
    @AfterMethod

    public void postcondition(){
      //  if (app.getUser().isRegistrationSuccess()==true) return;
        app.getUser().clickOkButton();
        app.getUser().pause(3000);

    }

}
