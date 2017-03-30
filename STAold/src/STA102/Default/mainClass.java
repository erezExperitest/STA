package Default;


/**
 * Created by erez.akri on 08-Dec-16.
 */
public class mainClass {
    public static void main(String[] args) {
        Thread t1 = new Rnner("ios_app:Green iPhone");
        Thread t2 = new Rnner("ios_app:iPad");
        t1.start();
        t2.start();
    }
}
