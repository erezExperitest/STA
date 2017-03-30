package yotam;//package <set your test package>;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.experitest.client.Client;
import com.google.code.tempusfugit.concurrency.ConcurrentTestRunner;
/**
 *
*/
@RunWith(ConcurrentTestRunner.class)

public class Bugs {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\project31";
    Client client = null;

    @Before
    public void setUp(){
        client = new Client(host, port, true);
        //client.setClientDebugStatus(true);
        client.setProjectBaseDirectory(projectBaseDirectory);
//        client.setReporter("xml", "reports", "test" + Thread.currentThread().getId());
        
    }

    @Test
    public void testtest1(){
    	
//        client.waitForDevice("@os='ios'",3000);
        client.setDevice("ios_app:iPad");
        client.launch("com.experitest.ExperiBank", true, true);
//        client.elementSendText("NATIVE", "accessibilityLabel=usernameTextField", 0, "company");
//        client.elementSendText("NATIVE", "accessibilityLabel=passwordTextField", 0, "company");
//        client.click("NATIVE", "xpath=//*[@accessibilityLabel='loginButton' and @class='UIButton']", 0, 1);
//        client.deviceAction("Home");
        System.out.println("This is Test 1 with thread:" + Thread.currentThread().getId() );

        client.sleep(30000);
    }

    @Test
    public void testtest2(){

//        client.waitForDevice("@os='ios'",3000);
//        client.setDevice("adb:OnePlus A0001");
        client.setDevice("ios_app:Green iPhone");
        client.launch("com.experitest.ExperiBank", true, true);
//        client.elementSendText("NATIVE", "accessibilityLabel=usernameTextField", 0, "company");
//        client.elementSendText("NATIVE", "accessibilityLabel=passwordTextField", 0, "company");
//        client.click("NATIVE", "xpath=//*[@accessibilityLabel='loginButton' and @class='UIButton']", 0, 1);
        client.deviceAction("Home");

        System.out.println("This is Test 2 with thread:" + Thread.currentThread().getName() );
        client.sleep(30000);
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
