import com.experitest.client.*;

import java.util.Arrays;
import java.util.List;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


//@RunWith(Parameterized.class)
public class Grid2 {
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
        GridClient grid = new GridClient("admin", "Experitest2012", "", "http://localhost"); //(user name, password, project,ip,port,secured)
//        GridClient grid = new GridClient("erez", "Experitest2012", "Default", "192.168.4.63", 8090, false); //(user name, password, project,ip,port,secured)
        client = grid.lockDeviceForExecution("erezTest", "@serialnumber='b5e53830a00a854f3c820869a3feb2f38b4fc7d8'", 10, 30); //(test name, query, time for reserve in minuets, timeout in milliseconds)
        client.setProjectBaseDirectory(projectBaseDirectory);

//        client.deviceAction("portraite");
//
        client.install("cloud:com.experitest.ExperiBankO",false,false);
        client.launch("cloud:com.experitest.ExperiBankO",false,true);
//        try {
//            client.getVisualDump("NATIVE");
//        }catch (Exception e){
//            System.out.println("no instrumented dump");
//        }
//        client.install("cloud:com.experitest.ExperiBankO",true,false);
//        client.launch("cloud:com.experitest.ExperiBankO",true,true);
//        client.getVisualDump("NATIVE");
                client.elementSendText("NATIVE", "accessibilityIdentifier=usernameTextField", 0, "company");
        client.elementSendText("NATIVE", "accessibilityIdentifier=passwordTextField", 0, "company");
        client.click("NATIVE", "xpath=//*[@accessibilityLabel='loginButton' and @class='UIButton']", 0, 1);
        client.deviceAction("Home");

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
