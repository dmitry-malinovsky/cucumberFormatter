import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import hooks.UiHooks;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/Login.feature"
        },
        tags = {"~@ignore"},
        glue = {"stepdefs",
                "hooks"},
        plugin = {"cucumberFormatter.CustomFormatter:custom-formatter-output.txt"})
public class CucumberRunner {

}

