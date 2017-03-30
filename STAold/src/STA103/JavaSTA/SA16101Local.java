package JavaSTA;//package <set your test package>;
import com.experitest.client.*;
import org.junit.*;
/**
 *
 */
public class SA16101Local {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "/Users/erez.akri/workspace/project2";
    protected Client client = null;

    @Before
    public void setUp(){
        client = new Client(host, port, true);
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "2");
    }

    @Test
    public void test_2(){
        client.waitForDevice("@os='ios'",30000);
//        client.setDevice("ios_app:iPad air 10");
        try {
            client.uninstall("com.experitest.ExperiBankO");
        }catch (Exception e){}
        client.install("D:\\Program Files (x86)\\Experitest\\SeeTest-10.3\\bin\\ipas\\EriBankO.ipa", false, false);
        client.startAudioPlay("C:\\Users\\erez.akri.experitest\\Desktop\\New folder (2)\\New folder\\Nyan_Cat.wav");
        client.sleep(5000);
        client.startAudioRecording("C:\\Users\\erez.akri.experitest\\Desktop\\New folder (2)\\New folder\\SA11635465.wav");
        client.sleep(5000);

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
