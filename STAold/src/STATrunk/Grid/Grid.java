package Grid;//package <set your test package>;
import com.experitest.client.*;

import java.util.Arrays;
import java.util.List;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

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
        GridClient grid = new GridClient("erez", "Experitest2012", "", "http://192.168.4.63:8090"); //(user name, password, project,ip,port,secured)
//        GridClient grid = new GridClient("erez", "Experitest2012", "Default", "192.168.4.63", 8090, false); //(user name, password, project,ip,port,secured)
        client = grid.lockDeviceForExecution("erezTest", "@os='android'", 10, 30); //(test name, query, time for reserve in minuets, timeout in milliseconds)
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "1");
//        String a = client.getDeviceProperty("device.name");
//        System.out.println(a);
//        System.out.println(client.collectSupportData("C:\\Users\\erez.akri.experitest\\Desktop\\","","","d","df","d",true,false));
//        client.launch("com.experitest.ExperiBank", true, true);
//        client.elementSendText("NATIVE", "placeholder=Username", 0, "company");
//        client.elementSendText("NATIVE", "placeholder=Password", 0, "company");
//        client.click("NATIVE", "accessibilityLabel=loginButton", 0, 1);
//        client.click("NATIVE", "accessibilityLabel=logoutButton", 0, 1);
//        client.startLoggingDevice("C:\\Users\\erez.akri.experitest\\Desktop\\a.log");
//        client.startVideoRecord();
//        client.sleep(10000);
//        client.install("D:\\Program Files (x86)\\Experitest\\SeeTest-10.4.49\\bin\\ipas\\BrowserO.ipa",true, false);
////        client.install("cloud:com.experitest.ExperiBank",true,false);
//        client.stopLoggingDevice();
//        client.stopVideoRecord();
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
