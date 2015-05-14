package com.synerzip.testframework.steps;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.synerzip.testframework.context.Context;
import com.synerzip.testframework.flow.FlowRunner;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleTextSearchStepDefinitions {

	
	@Autowired
	private Context context;

	@Autowired
	private FlowRunner flowRunner;
	


	@When("^I search for \"(.*?)\"$")
	public void i_search_for(String searchKeyword) throws Throwable {
		context.setFeature("google/text");
		Map<String,String> dictionary = new HashMap<String,String>();
		dictionary.put("text", searchKeyword);
	    flowRunner.run(context, "when-1.json",dictionary);
	}

	@Then("^I can see \"(.*?)\" link in search result$")
	public void i_can_see_in_search_result(String result) throws Throwable {
		context.setFeature("google/text");
		Map<String,String> dictionary = new HashMap<String,String>();
		dictionary.put("message", result);
	    flowRunner.run(context, "then-1.json",dictionary);
	}




}
