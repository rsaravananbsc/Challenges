package stepDef;

import java.util.List;
import java.util.Map;
import org.junit.Assert;
import cucumber.api.java.en.*;
import flow.Engine;
import flow.IAction;
import flow.IAdapter;
import flow.IEvent;
import flow.samples.*;

public class stepDef_EmailTest {
	@SuppressWarnings("rawtypes")
	@Given("^A User sends an \"([^\"]*)\" message$")
	public List<IAction> a_User_sends_an_message(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		TextAction taction = new TextAction("Hello");
		TextAgent tagent = new TextAgent(taction.execute());
		return tagent.act();
	
	}
	
	@SuppressWarnings("rawtypes")
	@When("^The message is converted by the Adapter$")
	public IEvent the_message_is_converted_by_the_Adapter_Adapter() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		List <IAction> laction = a_User_sends_an_message("");
		TextAdapter tadapater = new TextAdapter();
		return tadapater.adapt(laction.get(0));
		
	}

	@Then("^The Message server should contain the \"([^\"]*)\" message in the queue$")
	public void the_Message_server_should_contain_the_message_in_the_queue(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
//		IEvent ievent = the_message_is_converted_by_the_Adapter_Adapter();
//		TextApp tapp = new TextApp();
//		String ret = tapp.in(ievent);
		// After this code. i am not sure about from where do i need to invoke the Engine to Start and get invoke
		// the Sample Text Message from APP and from Agent. 
		
		//This is the one more way to verify the Sample Text Message.
		TextAgent agents  = new TextAgent("Hello");
		TextAdapter adapters = new TextAdapter();	    
		Engine engine = new Engine(agents, (Map<String, IAdapter>) adapters, new TextApp());
	    engine.run();
	    TextApp textApp = (TextApp) engine.getApp();
	    Assert.assertEquals("ACK:msg1", textApp.popResponse());
	    
	 	
	}
}
