package concurrencia;

class ThreadSimpleTest {

    public static void main(String[] args) {
        ThreadSimple t1 = new ThreadSimple("Argentina");
        t1.start();
        ThreadSimple t2 = new ThreadSimple("Uruguay");
        t2.start();
    }
}
