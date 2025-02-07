package com.rubesh.Runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.core.options.CucumberOptionsAnnotationParser;
import io.cucumber.cucumberexpressions.CucumberExpression;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

public abstract class CustomTestNGRunner {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @SuppressWarnings("unused")
    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) throws Throwable {
        // the 'featureWrapper' parameter solely exists to display the feature file in a test report
    	FeatureWrapper feature = (FeatureWrapper)featureWrapper;
        System.out.println("*************************************************");
        System.out.println(feature.toString().trim());
        System.out.println("*************************************************");
        PickleWrapper pickle = (PickleWrapper)pickleWrapper;
        
        System.out.println("******************************* ******************");
        System.out.println(pickle.toString().trim()  + " - " +   pickle.getPickle().getTags());
        System.out.println("*************************************************");
       
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    /**
     * Returns two dimensional array of {@link PickleWrapper}s
     * with their associated {@link FeatureWrapper}s.
     *
     * @return a two dimensional array of scenarios features.
     */
    @DataProvider
    public Object[][] scenarios() {
        if (testNGCucumberRunner == null) {
            return new Object[0][0];
        }
        /*Object[][] data = testNGCucumberRunner.provideScenarios();
        System.out.println(data.length);
        for(int i = 0; i < data.length; i ++  )
        {
        	FeatureWrapper feature = (FeatureWrapper)data[i][1];
            System.out.println("*************************************************");
            System.out.println(feature.toString().trim());
            System.out.println("*************************************************");
            PickleWrapper pickle = (PickleWrapper)data[i][0];
            
            System.out.println("******************************* ******************");
            System.out.println(pickle.toString().trim()  + " - " +   pickle.getPickle().getTags());
            System.out.println("*************************************************");
           
        }*/
        CucumberOptionsAnnotationParser parse = new CucumberOptionsAnnotationParser();
        
        
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        if (testNGCucumberRunner == null) {
            return;
        }
        testNGCucumberRunner.finish();
    }
}

