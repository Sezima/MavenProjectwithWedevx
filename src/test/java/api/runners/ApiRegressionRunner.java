package co.wedevx.digitalbank.automation.api.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("api.features.account")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value="co.wedevx.digitalbank.automation.api.steps")
public class ApiRegressionRunner {

}
