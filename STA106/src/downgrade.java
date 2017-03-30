//package <set your test package>;

import com.experitest.client.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        client.install("C:\\Users\\erez.akri.experitest\\Desktop\\3Debug.apk", true, false);
        client.install("C:\\Users\\erez.akri.experitest\\Desktop\\2Debug.apk", true, true);
        client.install("C:\\Users\\erez.akri.experitest\\Desktop\\3noDebug.apk", true, false);
        client.install("C:\\Users\\erez.akri.experitest\\Desktop\\2noDebug.apk", true, true);
//        client.install("C:\\Users\\erez.akri.experitest\\Downloads\\UICatalogNewer.apk", true, false);
//        client.install("C:\\Users\\erez.akri.experitest\\Downloads\\UICatalogOld.apk", true, true);

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
