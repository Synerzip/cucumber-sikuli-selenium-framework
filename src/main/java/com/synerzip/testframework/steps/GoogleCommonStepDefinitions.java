package com.synerzip.testframework.steps;

import org.springframework.beans.factory.annotation.Autowired;

import com.synerzip.testframework.context.Context;
import com.synerzip.testframework.flow.FlowRunner;

import cucumber.api.java.en.Given;

public class GoogleCommonStepDefinitions {

	
	@Autowired
	private Context context;

	@Autowired
	private FlowRunner flowRunner;
	
	@Given("^Google in Open in Browser$")
	public void google_in_Open_in_Browser() throws Throwable {
		context.setFeature("google/image");
	    flowRunner.run(context, "given-1.json");
	}


	

}
