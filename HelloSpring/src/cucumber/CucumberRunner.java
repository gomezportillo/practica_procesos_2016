package cucumber;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(features="feature", glue="testsUsuariosMultiples")
public class CucumberRunner {
//
}
