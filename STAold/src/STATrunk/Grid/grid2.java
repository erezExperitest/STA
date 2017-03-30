package Grid;//package <set your test package>;
import com.experitest.client.*;

import java.util.Arrays;
import java.util.List;

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
//    String url = "https://qacloud.experitest.com";
//    String url = "http://192.168.4.63:8090";
//    String user = "erez";
//    String url = "http://192.168.2.10";
//    String url = "https://cloud.experitest.com";
//    String user = "erez.akri@experitest.com";
    String url = "http://localhost";


    @Before
    public void setUp(){
    }

    @Test
    public void test_1() throws Exception {
        GridClient grid = new GridClient("admin","Experitest2012",  "" , url); //(user name, password, project,ip,port,secured)
//        client = grid.lockDeviceForExecution("erezTest", "@os='android'", 10, 10000); //(test name, query, time for reserve in minuets, timeout in milliseconds)
        client = grid.lockDeviceForExecution("erezTest", "@os='ios'", 10, 10000); //(test name, query, time for reserve in minuets, timeout in milliseconds)
//        client = grid.lockDeviceForExecution("erezTest", "@dhminternalhost='192.168.2.20'", 10, 10000); //(test name, query, time for reserve in minuets, timeout in milliseconds)
        client.setProjectBaseDirectory(projectBaseDirectory);
        String setReporter = client.setReporter("xml", "reports", "1");

//        client.startVideoRecord();
//        client.swipe("right", 5, 10000);
//        String stopVideoRecordOutPut = client.stopVideoRecord();
//        System.out.println(stopVideoRecordOutPut);
//        client.getRemoteFile(stopVideoRecordOutPut,1000,setReporter+"\\videoFile.ogg");
//
//        System.out.println(stopVideoRecordOutPut);
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
