package Default;//package <set your test package>;
import com.experitest.client.*;
import org.junit.*;
/**
 *
 */
public class _1 {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\project31";
    protected Client client = null;
    static ThreadLocal<String> name = new ThreadLocal<>();

    @Before
    public void setUp(){
        client = new Client(host, port, true);
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "1");
    }

    @Test
    public void test_1(){
//        String a = "";
//                a= client.waitForDevice("@os='ios'",3000);
    try {
        String n = name.get();
        System.out.println(n);
        client.setDevice(n);
        client.launch("com.experitest.ExperiBank", true, true);
//        client.elementSendText("NATIVE", "accessibilityIdentifier=usernameTextField", 0, "company");
//        client.elementSendText("NATIVE", "accessibilityIdentifier=passwordTextField", 0, "company");
//        client.click("NATIVE", "xpath=//*[@accessibilityLabel='loginButton' and @class='UIButton']", 0, 1);
//        client.deviceAction("Home");

        System.out.println("This is Test 2 with thread:" + Thread.currentThread().getName());
    }catch (Exception e){
        e.printStackTrace();
    }

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
