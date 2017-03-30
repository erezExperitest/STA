package JavaSTA;//package <set your test package>;

import com.experitest.client.Client;
import com.experitest.client.GridClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class multipleTest {
	@Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[10][0]);
    }

    private String projectBaseDirectory = System.getProperty("user.dir");
    protected Client client = null;


    @Before
    public void setUp(){
        System.out.println("befotre");
    }

    @Test
    public void test_1(){
        System.out.println("test");
    }

    @After
    public void tearDown(){
        System.out.println("after");
    }

}
