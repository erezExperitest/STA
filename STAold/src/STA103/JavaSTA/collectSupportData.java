package JavaSTA;
//package <set your test package>;
import com.experitest.client.*;
import org.junit.*;
/**
 *
 */
public class collectSupportData {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\project43";
    protected Client client = null;

    @Before
    public void setUp(){
        client = new Client(host, port, true);
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "apptest");
    }

    @Test
    public void testapptest(){
        client.setDevice("ios_app:iPhone 3");
        client.collectSupportData("","","","d","d","d");
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
