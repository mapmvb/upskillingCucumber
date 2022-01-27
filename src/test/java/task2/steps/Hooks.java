package task2.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

//    @Before(value = "@web")
    @Before
    public void startUpDriver(){
        if(Auxillary.driver==null){
            WebDriverManager.chromedriver().setup();
            Auxillary.driver = new ChromeDriver();
            Auxillary.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            Auxillary.driver.navigate().to("http://localhost/upload/index.php");
        }
    }

    @After(value = "@web")
//    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        Thread.sleep((3000));
        if (scenario.isFailed()){
            // Take screenshot
            final byte[] screenshot = ((TakesScreenshot) Auxillary.driver).getScreenshotAs(OutputType.BYTES);
//            final byte[] screenshot = ((TakesScreenshot) auxillary.getWebdriver().get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png",scenario.getName());  //...and embed it in the report
        }
        Auxillary.driver.navigate().to("http://localhost/upload/index.php");
    }

    @After(value = "@web")
//    @After
    public void afterHook() {
        System.out.println("--the end--");
    }

}
