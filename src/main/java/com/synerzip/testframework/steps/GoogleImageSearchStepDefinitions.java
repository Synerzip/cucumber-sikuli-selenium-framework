package com.synerzip.testframework.steps;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.synerzip.testframework.context.Context;
import com.synerzip.testframework.flow.FlowRunner;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleImageSearchStepDefinitions {

	
	@Autowired
	private Context context;

	@Autowired
	private FlowRunner flowRunner;
	
	
	@When("^I search for \"(.*?)\" image$")
	public void i_search_for_image(String searchKeyword) throws Throwable {
		context.setFeature("google/image");
		Map<String,String> dictionary = new HashMap<String,String>();
		dictionary.put("text", searchKeyword);
	    flowRunner.run(context, "when-1.json",dictionary);
	}

	@Then("^I can see facebook image in search result$")
	public void i_can_see_facebook_image_in_search_result() throws Throwable {
		context.setFeature("google/image");
	    flowRunner.run(context, "then-1.json");
	}

	

}
