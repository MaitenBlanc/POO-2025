public class Edificio implements ImpactoEcologico {
    private double consumoElectricidad;
    private double consumoGas;

    public Edificio(double consumoElectricidad, double consumoGas) {
        this.consumoElectricidad = consumoElectricidad;
        this.consumoGas = consumoGas;
    }

    // Factores aproximados:
    // Electricidad: 0.4 kg CO2/kWh
    // Gas natural: 1.9 kg CO2/m³
    @Override
    public double obtenerImpactoEcologico() {
        double factorElectricidad = 0.4;
        double factorGas = 1.9;
        return (consumoElectricidad * factorElectricidad) + (consumoGas * factorGas);
    }

    @Override
    public String toString() {
        return "\nEdificio [Consumo de electricidad = " + consumoElectricidad + " kWh, consumo de gas = " + consumoGas
                + " m³]";
    }
}
