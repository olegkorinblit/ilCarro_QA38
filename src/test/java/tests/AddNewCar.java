package tests;

import models.Car;
import models.User;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCar extends TestBase{

    @BeforeMethod
    public void precondition() {
        if(app.getUser().isLogged()==false)
        {
app.getUser().login(new User().withEmail("oleg@mail.ru")
        .withPassword("Oleg1980!"));
app.getUser().pause(3000);
app.getUser().click(By.xpath("//a[.=' Let the car work ']"));
        }
    }
    @Test
    public void addNewCarPositive()  {

        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Car car= Car.builder()
                .location("Tel Aviv")
                .make("Lada")
                .model("Eclipse")
                .year("2020")
                .fuel("Petrol")
                .seats("5")
                .carClass("Sedan")
                .carReqNumber("12-20-"+i)
                .price("100")
                .about("")

                .build();

        app.getCar().fillCarForm(car);
        app.getUser().submitLogin();
    }
}
