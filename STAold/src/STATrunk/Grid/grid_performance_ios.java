package Grid;//package <set your test package>;
import com.experitest.client.*;
import org.junit.*;
/**
 *
*/
public class grid_performance_ios {
    private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\project31";
    protected Client client = null;

    @Before
    public void setUp(){
        GridClient grid = new GridClient("erez", "aB12345", "default", "qacloud.experitest.com", 443, true); //(user name, password, project,ip,port,secured)
		client =  grid.lockDeviceForExecution("aa", "@os='iOS'", 10,50000 ); //(test name, query, time for reserve in minutes, timeout in milliseconds)

        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "Grid.grid_performance_ios");
    }

    @Test
    public void testnew(){
        if(client.install("cloud:com.experitest.ExperiBank", true, false)){
            // If statement
        }
        client.launch("cloud:com.experitest.ExperiBank", true, true);
        if(client.waitForElement("NATIVE", "placeholder=Username", 0, 120000)){
            // If statement
        }
        client.elementSendText("NATIVE", "placeholder=Username", 0, "company");
        if(client.waitForElement("NATIVE", "placeholder=Password", 0, 10000)){
            // If statement
        }
        client.elementSendText("NATIVE", "placeholder=Password", 0, "company");
        client.sendText("{ENTER}");
        client.click("NATIVE", "accessibilityLabel=makePaymentButton", 0, 1);
        if(client.waitForElement("NATIVE", "accessibilityLabel=countryButton", 0, 10000)){
            // If statement
        }
        client.click("TEXT", "Select", 0, 1);
        client.elementListSelect("", "text=Tanzania", 0, false);
        client.click("NATIVE", "xpath=//*[@accessibilityLabel='Tanzania']", 0, 1);
        if(client.waitForElement("NATIVE", "accessibilityLabel=cancelButton", 0, 120000)){
            // If statement
        }
        client.click("TEXT", "Cancel", 0, 1);
        if(client.waitForElement("TEXT", "Logout", 0, 10000)){
            // If statement
        }
        client.click("NATIVE", "accessibilityLabel=logoutButton", 0, 1);
        client.launch("safari:http://www.wikipedia.org", true, false);
        if(client.waitForElement("WEB", "id=searchInput", 0, 120000)){
            // If statement
        }
        client.elementSendText("WEB", "id=searchInput", 0, "expert");
        client.click("WEB", "xpath=//*[@nodeName='BUTTON' and ./parent::*[@nodeName='FIELDSET']]", 0, 1);
    }

    @After
    public void tearDown(){
        // Generates a report of the test case.
        // For more information - http://experitest.com/studio/help2/WebHelp/help.htm#Report_Of_Executed_Script.htm .
        client.generateReport(false);
        // Releases the client so that other clients can approach the agent in the near future. 
        client.releaseClient();
    }
}
