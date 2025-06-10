public class Auto implements ImpactoEcologico {
    private double kmAnuales;
    private double consumoLitros;

    public Auto(double consumoLitros, double kmAnuales) {
        this.consumoLitros = consumoLitros;
        this.kmAnuales = kmAnuales;
    }

    // Factor aproximado:
    // 1 litro de combustible: 2.31 kg de CO2

    @Override
    public double obtenerImpactoEcologico() {
        double litrosTotales = (kmAnuales / 100) * consumoLitros;
        double factor = 2.31;
        return litrosTotales * factor;
    }

    @Override
    public String toString() {
        return "\nAuto [Km anuales = " + kmAnuales + ", consumo anual = " + consumoLitros + " litros/100km]";
    }

}
