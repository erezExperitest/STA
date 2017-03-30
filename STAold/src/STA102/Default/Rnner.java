package Default;

import org.junit.runner.JUnitCore;

/**
 * Created by erez.akri on 08-Dec-16.
 */
public class Rnner extends Thread {

    String name;
    public Rnner(String name){
        super();
        this.name = name;
    }

    @Override
    public void run() {
        _1.name.set(name);
        JUnitCore.runClasses(_1.class);
    }


}
