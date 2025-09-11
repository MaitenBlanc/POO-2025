package ej2.prueba_mia;

public class Par<P, M> {

    private P posicion;
    private M maximo;

    public Par(P posicion, M maximo) {
        this.posicion = posicion;
        this.maximo = maximo;
    }

    public P getPosicion() {
        return posicion;
    }

    public void setPosicion(P posicion) {
        this.posicion = posicion;
    }

    public M getMaximo() {
        return maximo;
    }

    public void setMaximo(M maximo) {
        this.maximo = maximo;
    }

    @Override
    public String toString() {
        return "Par (" + posicion + ", " + maximo + ")";
    }

}
