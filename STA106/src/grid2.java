//package <set your test package>;
import com.experitest.client.*;

import java.util.Arrays;
import java.util.List;

import org.boon.core.Sys;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

//@RunWith(Parameterized.class)
public class grid2 {
//	@Parameterized.Parameters
//    public static List<Object[]> data() {
//        return Arrays.asList(new Object[10][0]);
//    }

    private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\project31";
    protected Client client = null;

    String url = "http://192.168.4.63:8090";
//    String url = "http://localhost";
//    String url =  "https://qacloud.experitest.com";


    @Before
    public void setUp(){
    }

    @Test
    public void test_1() throws Exception {
        GridClient grid = new GridClient("erez","Experitest2012",  "" , url); //(user name, password, project,ip,port,secured)
//        GridClient grid = new GridClient("erez","Experitest2012",  "" , "qacloud.experitest.com", 443, true); //(user name, password, project,ip,port,secured)
//        GridClient grid = new GridClient("erez","Experitest2012",  "" , url); //(user name, password, project,ip,port,secured)
        client = grid.lockDeviceForExecution("erezTest", "@os='ios' and @dhminternalhost='192.168.2.20'", 10, 10000); //(test name, query, time for reserve in minuets, timeout in milliseconds)
//        client = grid.lockDeviceForExecution("erezTest", "@os='ios' and @dhminternalhost='192.168.2.20'", 10, 10000); //(test name, query, time for reserve in minuets, timeout in milliseconds)
//        client = grid.lockDeviceForExecution("erezTest", "@serialnumber='74ee108a3e08509f1e8056aa1623d6a1a01dcb1f'", 10, 10000); //(test name, query, time for reserve in minuets, timeout in milliseconds)
//        client = grid.lockDeviceForExecution("erezTest", "@os='android' and @dhminternalhost='192.168.2.23'", 10, 10000); //(test name, query, time for reserve in minuets, timeout in milliseconds)
        client.setProjectBaseDirectory(projectBaseDirectory);
        String setReporter = client.setReporter("xml", "reports", "1");


        client.setDevice("ios_app:iPad");
        client.startVideoRecord();
        client.sleep(10000);
        String str0 = client.stopVideoRecord();

//        client.startVideoRecord();
//        long start = System.currentTimeMillis();
//        if(client.install("D:\\Program Files (x86)\\Experitest\\SeeTest-10.6.3229\\bin\\ipas\\eribank.apk", true, false)){
//            // If statement
//        }
//        //client.sleep(100000);
//        client.launch("cloud:com.experitest.ExperiBank/.LoginActivity", true, false);
//        client.sendText("company");
//        client.elementSendText("NATIVE", "hint=Password", 0, "company");
//        client.click("NATIVE", "text=Login", 0, 1);
//        if(client.waitForElement("NATIVE", "partial_text=Make Payment", 0, 30000)){
//            // If statement
//        }
//        client.click("NATIVE", "text=Make Payment", 0, 1);
//        client.click("NATIVE", "text=Select", 0, 1);
//        client.elementListSelect("", "text=Mexico", 0, false);
//        client.click("NATIVE", "text=Mexico", 0, 1);
//        if(client.waitForElement("NATIVE", "partial_text=Cancel", 0, 60000)){
//            // If statement
//        }
//        client.click("TEXT", "Cancel", 0, 1);
//        client.click("TEXT", "Logout", 0, 1);
//        client.launch("chrome:http://www.wikipedia.org", true, false);
//        if(client.waitForElement("WEB", "id=searchInput", 0, 120000)){
//            // If statement
//        }
//        client.click("WEB", "id=searchInput", 0, 1);
//        client.elementSendText("WEB", "id=searchInput", 0, "expert");
//        client.sendText("{ENTER}");
//        client.swipe("Down", 206, 1225);
//
//        System.err.println("video expected time:" + ((System.currentTimeMillis()-start)/1000));
//        client.stopVideoRecord();
    }



    @After
    public void tearDown() throws Exception {
        // Generates a report of the test case.
        // For more information - https://docs.experitest.com/display/public/SA/Report+Of+Executed+Test
        String reportPath = client.generateReport(false);
//        romteFileHandler(reportPath);
//                String collectSupportDataPath = client.collectSupportData("","","","","","");
//        romteFileHandler(collectSupportDataPath);
        // Releases the client so that other clients can approach the agent in the near future.
        client.releaseClient();
    }

     void romteFileHandler(String returnedPath) throws Exception {
        System.err.println("Returned path is:" + returnedPath);
        client.getRemoteFile(returnedPath,10000,"C:\\Users\\erez.akri.experitest\\Desktop");
    }

}
