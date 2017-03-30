//package <set your test package>;
import com.experitest.client.*;
import org.junit.*;
/**
 *
 */
public class downgrade {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\project44";
    protected Client client = null;

    @Before
    public void setUp(){
        client = new Client(host, port, true);
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "1");
    }

    @Test
    public void test_1(){
        client.setDevice("adb:Nexus 5X");
//        client.install("C:\\Users\\erez.akri.experitest\\Desktop\\3.apk", true, false);
//        client.install("C:\\Users\\erez.akri.experitest\\Desktop\\2.apk", true, false);
        client.install("C:\\Users\\erez.akri.experitest\\Downloads\\UICatalogNewer.apk", true, false);
        client.install("C:\\Users\\erez.akri.experitest\\Downloads\\UICatalogOld.apk", true, true);

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
