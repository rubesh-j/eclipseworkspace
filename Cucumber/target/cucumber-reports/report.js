$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/java/feature/First.feature");
formatter.feature({
  "name": "Validating Extent Report",
  "description": "  I want to use this template for my feature file",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@feature"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Scenario 1 \u003cname\u003e",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag"
    },
    {
      "name": "@all"
    }
  ]
});
formatter.step({
  "name": "I want to write a step with \u003cname\u003e",
  "keyword": "Given "
});
formatter.step({
  "name": "I check for the \u003cvalue\u003e in step",
  "keyword": "When "
});
formatter.step({
  "name": "I verify the \u003cstatus\u003e in step",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "name",
        "value",
        "status"
      ]
    },
    {
      "cells": [
        "\"Test 1\"",
        "5",
        "\"success\""
      ]
    },
    {
      "cells": [
        "\"Test 2\"",
        "7",
        "\"Fail\""
      ]
    }
  ],
  "tags": [
    {
      "name": "@regression"
    }
  ]
});
formatter.scenario({
  "name": "Scenario 1 \"Test 1\"",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@feature"
    },
    {
      "name": "@tag"
    },
    {
      "name": "@all"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I want to write a step with \"Test 1\"",
  "keyword": "Given "
});
formatter.match({
  "location": "com.rubesh.Cucumber.App.i_want_to_write_a_step_with_name2(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I check for the 5 in step",
  "keyword": "When "
});
formatter.match({
  "location": "com.rubesh.Cucumber.App.i_check_for_the_in_step(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I verify the \"success\" in step",
  "keyword": "Then "
});
formatter.match({
  "location": "com.rubesh.Cucumber.App.i_verify_the_Fail_in_step(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Scenario 1 \"Test 2\"",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@feature"
    },
    {
      "name": "@tag"
    },
    {
      "name": "@all"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I want to write a step with \"Test 2\"",
  "keyword": "Given "
});
formatter.match({
  "location": "com.rubesh.Cucumber.App.i_want_to_write_a_step_with_name2(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I check for the 7 in step",
  "keyword": "When "
});
formatter.match({
  "location": "com.rubesh.Cucumber.App.i_check_for_the_in_step(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I verify the \"Fail\" in step",
  "keyword": "Then "
});
formatter.match({
  "location": "com.rubesh.Cucumber.App.i_verify_the_Fail_in_step(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "name",
        "value",
        "status"
      ]
    },
    {
      "cells": [
        "\"Test 3\"",
        "9",
        "\"success\""
      ]
    },
    {
      "cells": [
        "\"Test 4\"",
        "10",
        "\"Fail\""
      ]
    }
  ],
  "tags": [
    {
      "name": "@data"
    }
  ]
});
formatter.scenario({
  "name": "Scenario 1 \"Test 3\"",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@feature"
    },
    {
      "name": "@tag"
    },
    {
      "name": "@all"
    },
    {
      "name": "@data"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I want to write a step with \"Test 3\"",
  "keyword": "Given "
});
formatter.match({
  "location": "com.rubesh.Cucumber.App.i_want_to_write_a_step_with_name2(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I check for the 9 in step",
  "keyword": "When "
});
formatter.match({
  "location": "com.rubesh.Cucumber.App.i_check_for_the_in_step(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I verify the \"success\" in step",
  "keyword": "Then "
});
formatter.match({
  "location": "com.rubesh.Cucumber.App.i_verify_the_Fail_in_step(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Scenario 1 \"Test 4\"",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@feature"
    },
    {
      "name": "@tag"
    },
    {
      "name": "@all"
    },
    {
      "name": "@data"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I want to write a step with \"Test 4\"",
  "keyword": "Given "
});
formatter.match({
  "location": "com.rubesh.Cucumber.App.i_want_to_write_a_step_with_name2(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I check for the 10 in step",
  "keyword": "When "
});
formatter.match({
  "location": "com.rubesh.Cucumber.App.i_check_for_the_in_step(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I verify the \"Fail\" in step",
  "keyword": "Then "
});
formatter.match({
  "location": "com.rubesh.Cucumber.App.i_verify_the_Fail_in_step(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Scenario 2",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@feature"
    },
    {
      "name": "@different"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I want to write a step with \"Rubesh\"",
  "keyword": "Given "
});
formatter.match({
  "location": "com.rubesh.Cucumber.App.i_want_to_write_a_step_with_name2(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I check for the title in step",
  "rows": [
    {},
    {},
    {}
  ],
  "keyword": "When "
});
formatter.match({
  "location": "com.rubesh.Cucumber.App.i_check_for_the_in_step(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected [The Lion, the Witch and the Wardrobe] but found [The Devil in the White City]\r\n\tat org.testng.Assert.fail(Assert.java:97)\r\n\tat org.testng.Assert.assertEqualsImpl(Assert.java:136)\r\n\tat org.testng.Assert.assertEquals(Assert.java:118)\r\n\tat org.testng.Assert.assertEquals(Assert.java:575)\r\n\tat org.testng.Assert.assertEquals(Assert.java:585)\r\n\tat com.rubesh.Cucumber.App.i_check_for_the_in_step(App.java:93)\r\n\tat ✽.I check for the title in step(file:///D:/EclipseWorkSpace/Cucumber/src/main/java/feature/First.feature:45)\r\n",
  "status": "failed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "skipped"
});
formatter.step({
  "name": "I verify the \"Success\" in step",
  "keyword": "Then "
});
formatter.match({
  "location": "com.rubesh.Cucumber.App.i_verify_the_Fail_in_step(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/main/java/feature/Second.feature");
formatter.feature({
  "name": "FeatureFile2",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "name": "Scenario 3",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I want to write a step with \"My Name\"",
  "keyword": "Given "
});
formatter.match({
  "location": "com.rubesh.Cucumber.App.i_want_to_write_a_step_with_name2(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I check for the 5 in step",
  "keyword": "When "
});
formatter.match({
  "location": "com.rubesh.Cucumber.App.i_check_for_the_in_step(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.beforestep({
  "status": "passed"
});
formatter.step({
  "name": "I verify the \"value\" in step",
  "keyword": "Then "
});
formatter.match({
  "location": "com.rubesh.Cucumber.App.i_verify_the_Fail_in_step(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});