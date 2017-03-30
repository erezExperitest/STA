package Grid;//package <set your test package>;

import com.experitest.client.Client;
import com.experitest.client.GridClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//@RunWith(Parameterized.class)
public class Grid3 {
//	@Parameterized.Parameters
//    public static List<Object[]> data() {
//        return Arrays.asList(new Object[10][0]);
//    }

    private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\project31";
    protected Client client = null;


    @Before
    public void setUp(){
    }

    @Test
    public void test_1() {
        GridClient grid = new GridClient("erez", "Experitest2012", "", "http://192.168.4.63:8090"); //(user name, password, project,ip,port,secured)
//        GridClient grid = new GridClient("erez", "Experitest2012", "Default", "192.168.4.63", 8090, false); //(user name, password, project,ip,port,secured)
        client = grid.lockDeviceForExecution("erezTest", "@os='android'", 10, 30); //(test name, query, time for reserve in minuets, timeout in milliseconds)
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "1");

        client.install("cloud:com.experitest.ExperiBank/.LoginActivity", true, false);
        client.launch("com.experitest.ExperiBank/.LoginActivity", true, true);
        client.elementSendText("NATIVE", "hint=Username", 0, "company");
        client.elementSendText("NATIVE", "hint=Password", 0, "company");
        client.click("NATIVE", "text=Login", 0, 1);
        client.click("NATIVE", "text=Make Payment", 0, 1);
        client.elementSendText("NATIVE", "hint=Phone", 0, "55555555");
        client.elementSendText("NATIVE", "hint=Name", 0, "johnny");
        client.elementSendText("NATIVE", "hint=Amount", 0, "101000");
        client.click("NATIVE", "text=Select", 0, 1);
        client.elementListSelect("", "text=Argentina", 0, false);
        client.click("NATIVE", "text=Argentina", 0, 1);
        client.click("NATIVE", "hint=Amount", 0, 1);
        client.closeKeyboard();
        client.click("NATIVE", "text=Send Payment", 0, 1);
        client.click("NATIVE", "text=Yes", 0, 1);
        client.click("NATIVE", "text=Logout", 0, 1);


    }


    @After
    public void tearDown(){
        // Generates a report of the test case.
        // For more information - https://docs.experitest.com/display/public/SA/Report+Of+Executed+Test
//        client.generateReport(false);
        // Releases the client so that other clients can approach the agent in the near future. 
        client.releaseClient();
    }
    	
}
