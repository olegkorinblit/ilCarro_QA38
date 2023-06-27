package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {


    public HelperUser(WebDriver wd) {

        super(wd);
    }

    public void openLoginForm() {
        wd.findElement(By.xpath("//a[.=' Log in ']")).click();
    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
    }

    public void fillLoginForm(User user) {
        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"), user.getPassword());
    }

    //public  void submitRegistration() {
    //      wd.findElement(By.xpath("//button[@type='submit']")).click();
//}
    public void submitLogin() {
        // click(By.xpath("//button[@type='submit']"));
        wd.findElement(By.xpath("//button[@type='submit']")).submit();
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[@href='/logout?url=%2Fsearch']"));
    }////button[.='Ok']

    public void logout() {
        //wd.findElement(By.xpath("//a[@href='/logout?url=%2Fsearch']")).click();
        click(By.xpath("//*[.=' Logout ']"));
    }

    public void clickOKButton() {
        click(By.xpath("//button[.='Ok']"));
    }

    public boolean isLoggedSuccess() {

        return isElementPresent(By.xpath("//h2[contains(text(),'success')]"));
    }

public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submitLogin();
        clickOKButton();
}
    public void openRegistrationForm(){
        wd.findElement(By.xpath("//*[.=' Sign up ']")).click();
    }
    public void fillRegistrationForm(User user){
        type(By.xpath("//input[@id='name']"), user.getName());
        type(By.xpath("//input[@id='lastName']"), user.getLastName());
        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"), user.getPassword());
        click(By.cssSelector("label[for='terms-of-use']"));
    }

    public boolean isRegistrationSuccess() {

        return isElementPresent(By.cssSelector("div.ng-star-inserted[contains(text(),'1 lowercase letter')]"));
    }
}



