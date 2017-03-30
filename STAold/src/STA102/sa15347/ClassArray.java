package sa15347;

import org.junit.runner.JUnitCore;


public class ClassArray implements Runnable {

    @Override
    public void run() {
//        Class<?> [] classesArray = {sa15347.SA15347.class};
        JUnitCore.runClasses(SA15347.class);
    }

}