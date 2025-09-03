package concurrencia;

class ThreadSimple extends Thread {

    public ThreadSimple(String str) {
        super(str);
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i + " " + getName());
            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Hilo interrumpido: " + e.getMessage());
            }
        }
        System.out.println("HECHO! " + getName());
    }
}
