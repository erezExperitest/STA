import com.experitest.client.Client;
import com.experitest.client.GridClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


//@RunWith(Parameterized.class)
public class Grid {
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
//        GridClient grid = new GridClient("erez", "Experitest2012", "", "http://http://192.168.2.114"); //(user name, password, project,ip,port,secured)
        GridClient grid = new GridClient("admin", "Experitest2012", "", "localhost",80,false); //(user name, password, project,ip,port,secured)
//        GridClient grid = new GridClient("erez", "Experitest2012", "Default", "192.168.4.63", 8090, false); //(user name, password, project,ip,port,secured)
//        client = grid.lockDeviceForExecution("erezTest", "@os='android'", 10, 3000000); //(test name, query, time for reserve in minuets, timeout in milliseconds)
        client = grid.lockDeviceForExecution("erezTest", "@serialnumber='N2K7N16811000808'", 10, 3000000); //(test name, query, time for reserve in minuets, timeout in milliseconds)
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "1");
//        client.install("D:\\Downloads\\apk\\eribank.apk", true, false);
        client.install("cloud:com.experitest.ExperiBank/.LoginActivity", false, false);
        client.launch("com.experitest.ExperiBank/.LoginActivity", false, true);
        client.install("cloud:com.experitest.ExperiBank/.LoginActivity", true, false);
        client.launch("com.experitest.ExperiBank/.LoginActivity", true, true);
        client.elementSendText("native","xpath=//*[@id='usernameTextField']",0,"company");
        client.elementSendText("native","xpath=//*[@id='passwordTextField']",0,"company");
        client.click("native","//*[@id='loginButton']",0,1);
        client.verifyElementFound("native","//*[@id='makePaymentButton']",0);
        client.click("native","xpath=//*[@id='logoutButton']",0,1);

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
