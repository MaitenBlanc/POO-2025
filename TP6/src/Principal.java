
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) throws Exception {
        ArrayList<ImpactoEcologico> objetos = new ArrayList<>();

        objetos.add(new Edificio(5000, 1000)); // 5000 kWh de electricidad y 1000 m³ de gas
        objetos.add(new Auto(15000, 8)); // 15000 km al año, 8 L/100km
        objetos.add(new Bicicleta(5)); // 5 horas por semana

        for (ImpactoEcologico impactoEcologico : objetos) {
            System.out.println(impactoEcologico.toString());
            System.out.println("Impacto ecológico " + impactoEcologico.obtenerImpactoEcologico() + " kg de CO2.");
        }
    }
}
