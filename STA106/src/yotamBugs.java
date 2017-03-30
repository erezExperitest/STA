//package <set your test package>;
import com.experitest.client.*;
import com.google.code.tempusfugit.concurrency.ConcurrentTestRunner;
import org.junit.*;
import org.junit.runner.RunWith;

/**
 *
 */
@RunWith(ConcurrentTestRunner.class)

public class yotamBugs {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\project44";
    protected Client client = null;

    @Before
    public void setUp(){
        client = new Client(host, port, true);
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "Untitled");
    }

    @Test
    public void testUntitled(){
        client.setDevice("ios_app:iPad");
        client.startVideoRecord();
        client.sleep(10000);
        String str0 = client.stopVideoRecord();
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
