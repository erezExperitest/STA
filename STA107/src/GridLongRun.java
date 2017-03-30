//package <set your test package>;
import com.experitest.client.*;
import org.junit.*;
/**
 *
 */
public class versioninstall {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "/Users/erez.akri/workspace/project4";
    protected Client client = null;

    @Before
    public void setUp(){
        client = new Client(host, port, true);
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "versioninstall");
    }

    @Test
    public void testversioninstall(){
        client.setDevice("ios_app:Pink iPhone");
        client.launch("com.experitest.ExperiBank", true, true);
        client.click("NATIVE", "placeholder=Username", 0, 1);
        if(client.waitForElement("NATIVE", "placeholder=Username", 0, 30000)){
            // If statement
        }
        client.elementSendText("NATIVE", "placeholder=Username", 0, "company");
        client.elementSendText("NATIVE", "placeholder=Password", 0, "company");
        client.click("NATIVE", "accessibilityLabel=loginButton", 0, 1);
        client.click("NATIVE", "accessibilityLabel=makePaymentButton", 0, 1);
        client.elementSendText("NATIVE", "placeholder=Phone", 0, "654654");
        client.elementSendText("NATIVE", "placeholder=Name", 0, "aerertytr");
        client.elementSendText("NATIVE", "placeholder=Amount", 0, "1");
        client.click("NATIVE", "placeholder=Country", 0, 1);
        client.click("NATIVE", "accessibilityLabel=countryButton", 0, 1);
        client.elementListSelect("", "text=Tanzania", 0, false);
        client.click("NATIVE", "xpath=//*[@accessibilityLabel='Tanzania']", 0, 1);
        client.click("NATIVE", "accessibilityLabel=sendPaymentButton", 0, 1);
        client.click("NATIVE", "xpath=//*[@text='Yes']", 0, 1);
        client.click("NATIVE", "accessibilityLabel=makePaymentButton", 0, 1);
        client.click("NATIVE", "accessibilityLabel=cancelButton", 0, 1);
        client.click("NATIVE", "accessibilityLabel=logoutButton", 0, 1);
        client.launch("safari:http://google.com", true, false);
        client.click("WEB", "id=lst-ib", 0, 1);
        client.elementSendText("WEB", "id=lst-ib", 0, "experitest");
        client.sendText("{ENTER}");
        client.click("WEB", "text=Images", 0, 1);
        client.click("WEB", "name=1tqX0q1YsulfuM:", 0, 1);
        if(client.waitForElement("NATIVE", "xpath=//*[@class='UIAWebView']", 0, 10000)){
            // If statement
        }
        client.elementSendText("NATIVE", "xpath=//*[@class='UIAWebView']", 0, "google.co.il");
        client.sendText("{ENTER}");
        client.elementSendText("NATIVE", "xpath=//*[@class='UIAWebView']", 0, "wikipedia.com");
        client.sendText("{ENTER}");
        client.elementSendText("WEB", "id=searchInput", 0, "pele");
        if(client.waitForElement("WEB", "text=Brazilian footballer", 0, 30000)){
            // If statement
        }
        client.click("WEB", "text=Brazilian footballer", 0, 1);
        if(client.waitForElement("WEB", "id=searchIcon", 0, 10000)){
            // If statement
        }
        client.click("WEB", "id=searchIcon", 0, 1);
        if(client.waitForElement("WEB", "name=search", 0, 10000)){
            // If statement
        }
        client.click("WEB", "name=search", 0, 1);
        client.elementSendText("WEB", "name=search", 0, "expert");
        client.sendText("{ENTER}");
        client.click("WEB", "id=searchInput", 0, 1);
        if(client.waitForElement("WEB", "name=search", 0, 30000)){
            // If statement
        }
        client.click("WEB", "name=search", 0, 1);
        if(client.waitForElement("WEB", "text=Close", 0, 10000)){
            // If statement
        }
        client.click("WEB", "text=Close", 0, 1);
        client.elementSendText("WEB", "id=searchInput", 0, "jerusalem");
        if(client.waitForElement("WEB", "text=

                Jerusalem
                ancient holy city in the Judean Mountains
                ", 0, 30000)){
                // If statement
    }
        client.click("WEB", "text=

    Jerusalem
    ancient holy city in the Judean Mountains
  ", 0, 1);
          if(client.waitForElement("WEB", "text=Kingdom of Judah", 0, 60000)){
        // If statement
    }
        client.click("WEB", "text=Kingdom of Judah", 0, 1);
}

    @After
    public void tearDown(){
        // Generates a report of the test case.
        // For more information - https://docs.experitest.com/display/public/SA/Report+Of+Executed+Test
        client.generateReport(false);
        // Releases the client so that other clients can approach the agent in the near future.
        client.releaseClient();
    }
}
