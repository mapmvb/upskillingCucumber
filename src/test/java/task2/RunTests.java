package task2;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import task2.steps.Auxillary;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/task2/features",
        glue = "task2.steps",
        tags = "@web",
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber2.json"}
)
public class RunTests {

    @AfterClass
    public static void closeDriver() {
        Auxillary.driver.close();
        Auxillary.driver.quit();
        System.out.println("near close");
    }
}
