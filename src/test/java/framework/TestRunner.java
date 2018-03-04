package framework;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            // This creates cucumber reports
            plugin = {"pretty", "html:target/site/cucumber-pretty","json:target/site/cucumber-pretty/cucumber.json"},
            //This create auto method name in camelCase
            snippets = cucumber.api.SnippetType.CAMELCASE,

            //Path to your feature file
            features = {"src/test/resources/amazon"},
            // Specify tags to be executed
            tags = {"@departments-2"},  //Title of test cases which is going to be run
            //Specify step definition package name (Note: make sure to have this package on current directory)
            glue = {"stepdefinition"}
    )

    public class TestRunner {

    }

