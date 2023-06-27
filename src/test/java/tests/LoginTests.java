package tests;

import manager.HelperUser;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
/*
CW:7-8

https://github.com/QA38Rehovot/PhoneBook_QA38
https://github.com/QA38Rehovot/ILCarro_QA38

Ознакомиться с презентацией по архитектуре.

HW:

Task 1.
В проекте IlCarro создать 1 позитивный тестовый метод на логин в классе LoginTests с ассертами.
Task 2.
В проекте PhoneBook переписать позитивные тесты на логин и регистрацию в соответствии с новой архитектурой.


В теме письма (в поле subject) обязательно указывать группу и номер домашней работы
в формате: QA38_HWх (где х - номер лекции по которой сдается Д/З)
***все письма без корректного указания темы автоматически попадают в корзину. Задания, присланные позже 20.00 дня
накануне лекции, будут проверены по мере возможности, и только при условии, что студенту требуется помощь в решении
(должен быть представлен свой вариант решения и сформулирован конкретный вопрос).
 */
public class LoginTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogged()) {

           app.getUser().logout();
            app.getUser().pause(3000);
       }
    }
    /*
@Test
public void RegistrationPositive() {
        User user=new User()
                .withEmail("oleg@mail.ru").withPassword("Oleg1980!")
                .withPassword("Oleg")
                ;

}
@Test
public void registrationNegativeWrongEmail() {
        int i=(int)(System.currentTimeMillis()/1000)%3600;
    String email="oleg"+i+"@mail.ru";
    String password="Oleg1980!";
    app.getUser().openLoginForm();
    app.getUser().fillLoginForm(email, password);
    app.getUser().submitRegistration();


    }
*/
    @Test


    public void loginPositive() {
        String email = "oleg@mail.ru", password = "Oleg1980!";

        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLogin();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isLoggedSuccess());
    }

    @Test
    public void loginPositiveUser() {
        User user = new User().withEmail("oleg@mail.ru").withPassword("Oleg1980!");
        //  String email = "oleg@mail.ru", password = "Oleg1980!";
app.getUser().pause(5000);
        app.getUser().openLoginForm();
        app.getUser().pause(5000);
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button[.='Ok']")));
    }

    @AfterMethod
    public void postCondition() {
        if (app.getUser().isLogged()) {
            app.getUser().pause(3000);
            app.getUser().clickOKButton();
            app.getUser().pause(3000);
        }
    }
}