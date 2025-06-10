public class Bicicleta implements ImpactoEcologico {
    private double usoSemanal; // en horas

    public Bicicleta(double usoSemanal) {
        this.usoSemanal = usoSemanal;
    }

    // Factor aproximado:
    // 0.1 kg de CO2/h (por mantenimiento, fabricación, etc.)
    @Override
    public double obtenerImpactoEcologico() {
        double factor = 0.1;
        int semanasPorAño = 52;
        return usoSemanal * semanasPorAño * factor;
    }

    @Override
    public String toString() {
        return "\nBicicleta [Uso semanal = " + usoSemanal + " horas]";
    }

}
