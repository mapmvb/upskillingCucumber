package task2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends CommonPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;

    }

    public WebElement getElement(String name) {
        WebElement obj = null;
        try {
            switch (name) {
                case "login":
                    obj = driver.findElement(By.xpath("//a[text()='Login']"));
                    break;
                case "my forum":
                    obj = driver.findElement(By.xpath("//a[text()='My Forum']"));
                    break;
                case "test1 thread":
                    obj = driver.findElement(By.xpath("//*[text()='test1 thread']"));
                    break;
                case "post thread":
                    obj = driver.findElement(By.xpath("//a[@class='button new_thread_button']"));
                    break;
                case "thread subject":
                    obj = driver.findElement(By.xpath("//input[@name='subject']"));
                    break;
                case "your message":
                    obj = driver.findElement(By.xpath("//body[@dir='ltr']"));
                    break;
                case "username":
                    obj = driver.findElement(By.id("quick_login_username"));
                    break;
                case "password":
                    obj = driver.findElement(By.id("quick_login_password"));
                    break;
                case "login_button":
                case "post thread submit":
                    obj = driver.findElement(By.name("submit"));
                    break;
                case "my first test message":
                    obj = driver.findElement(By.xpath("//div[contains(text(),'my first test message')]"));
                    break;
                case "logout":
                    obj = driver.findElement(By.cssSelector(".icon-signout"));
                    break;
            }
        } catch (
                NoSuchElementException e) {
//            Assertions.fail("element "+ name + " not found at the page");
            return null;
        }
        return obj;
    }
}
