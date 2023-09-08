package runners;


import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;


//    The first annotation is suit. The suit annotation comes from JUnit platform suit api suit
//    so here basically suit annotation is an annotation of JUint that consolidated multiple test into one test suit
//    in engine annotation we select its junit test or cucumber


@Suite                                //consolidate multiple tests into one suite
@IncludeEngines("cucumber")           //choose what type of engine, what type of tests cucumber/junit? her we chose cucumber
@SelectClasspathResource("features")  //in which folder in resources folder do you have your feature files? her I have my feature files in features folder so it will scan the features folder to find feature files
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps")  //import this final constant as a key and make its value steps
@ExcludeTags("IGNORE")


public class RegressionsRunner {

}
