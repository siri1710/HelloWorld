import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
* This class is the base class that runs the tests
 */

@CucumberOptions(

        features = {"src/test/resources/cucumber"},
        glue = {"Stepdefs"},
        tags = {"~@Ignore"},
        format = {"pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "html:target/cucumber-html-report",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"}
        //plugin = {"io.cucumber.pro.JsonReporter12:default"}

)
public class TestRunner {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass
    public void setup()
    {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(dataProvider = "features")
    public void feature(CucumberFeatureWrapper featureWrapper)
    {
        testNGCucumberRunner.runCucumber(featureWrapper.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features()
    {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass
    public void tearDown()
    {
        testNGCucumberRunner.finish();
    }


}
