package Grid;//package <set your test package>;
import com.experitest.client.*;
import org.junit.*;
/**
 *
*/
public class grid_performance_android {
    private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\project31";
    protected Client client = null;

    @Before
    public void setUp(){
  		GridClient grid = new GridClient("erez", "aB12345", "default", "qacloud.experitest.com", 443, true); //(user name, password, project,ip,port,secured)
		client =  grid.lockDeviceForExecution("aa", "@os='android'", 10,50000 ); //(test name, query, time for reserve in minutes, timeout in milliseconds)
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "Grid.grid_performance_android");
    }

    @Test
    public void testnew(){
        if(client.install("cloud:com.experitest.ExperiBank/.LoginActivity", true, false)){
            // If statement
        }
        client.launch("cloud:com.experitest.ExperiBank/.LoginActivity", true, false);
        client.sendText("company");
        client.elementSendText("NATIVE", "hint=Password", 0, "company");
        client.click("NATIVE", "text=Login", 0, 1);
        if(client.waitForElement("NATIVE", "partial_text=Make Payment", 0, 30000)){
            // If statement
        }
        client.click("NATIVE", "text=Make Payment", 0, 1);
        client.click("NATIVE", "text=Select", 0, 1);
        client.elementListSelect("", "text=Mexico", 0, false);
        client.click("NATIVE", "text=Mexico", 0, 1);
        if(client.waitForElement("NATIVE", "partial_text=Cancel", 0, 60000)){
            // If statement
        }
        client.click("TEXT", "Cancel", 0, 1);
        client.click("TEXT", "Logout", 0, 1);
        client.launch("chrome:http://www.wikipedia.org", true, false);
		if(client.waitForElement("WEB", "id=searchInput", 0, 120000)){
            // If statement
        }
        client.click("WEB", "id=searchInput", 0, 1);
        client.elementSendText("WEB", "id=searchInput", 0, "expert");
        client.sendText("{ENTER}");
        client.swipe("Down", 206, 1225);
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
