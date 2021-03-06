//package <set your test package>;
import com.experitest.client.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
//@RunWith(Parameterized.class)
public class simple {
//    	@Parameterized.Parameters
//    public static List<Object[]> data() {
//        return Arrays.asList(new Object[2][0]);
//    }

    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\project39";
    protected Client client = null;

    @Before
    public void setUp(){
        client = new Client(host, port, true);
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "1");
    }

    @Test
    public void test_1(){
        client.waitForDevice("@os='ios'",6000);
        client.getProperty("device.screensize");
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
