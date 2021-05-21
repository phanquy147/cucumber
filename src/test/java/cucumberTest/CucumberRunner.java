package cucumberTest;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/java/feature/"},
        monochrome = true,
        glue={"stepdefinitions","src/test/java/stepdefinitions"},
        tags  = "@textbox_01"
)

public class CucumberRunner {

}
