package concurrencia;

public class TareaSimple implements Runnable {

    private String nombre;

    public TareaSimple(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i + " " + nombre);
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Hilo interrumpido: " + e.getMessage());
            }
        }
        System.out.println("HECHO!" + nombre);
    }
}
