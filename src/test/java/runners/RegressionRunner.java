package runners;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite                                //consolidate multiple tests into one suite
@IncludeEngines("cucumber")           //choose what type of engine, what type of tests cucumber/junit? her we chose cucumber
@SelectClasspathResource("features")  //in which folder in resources folder do you have your feature files? her I have my feature files in features folder so it will scan the features folder to find feature files
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps")  //import this final constant as a key and make its value steps
//@ExcludeTags("IGNORE")
@IncludeTags("test")
public class RegressionRunner {
}
