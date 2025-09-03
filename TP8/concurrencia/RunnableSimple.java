package concurrencia;

public class RunnableSimple implements Runnable {

    private String name;

    public RunnableSimple(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " " + getName());
        }
        System.out.println("HECHO! " + getName());
    }

}
