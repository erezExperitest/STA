import com.experitest.client.*;
import org.junit.*;
public class grid3 {
    private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\project31";
    protected Client client = null;
    String url =  "https://qacloud.experitest.com";
    @Before
    public void setUp(){
    }
    @Test
    public void test_1() throws Exception {
        GridClient grid = new GridClient("erez","Experitest2012",  "" , url); //(user name, password, project,ip,port,secured)
        client = grid.lockDeviceForExecution("erezTest", "@os='android' and @dhminternalhost='qacloud.experitest.com'", 10, 10000); //(test name, query, time for reserve in minuets, timeout in milliseconds)
//        client = grid.lockDeviceForExecution("erezTest", "@os='android' and @dhminternalhost='192.168.2.23'", 10, 10000); //(test name, query, time for reserve in minuets, timeout in milliseconds)
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "1");


        client.startVideoRecord();
        client.sleep(10000);
        client.stopVideoRecord();
    }
    @After
    public void tearDown() throws Exception {
        client.generateReport(false);
        client.releaseClient();
    }
}
