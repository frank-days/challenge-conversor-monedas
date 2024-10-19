import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ConversorMonedas conversor = new ConversorMonedas();
        List<String> codigos = new ArrayList<String>();
        Scanner teclado = new Scanner(System.in);
        int opcion = 1;

        codigos.add("USD");
        codigos.add("MXN");
        codigos.add("EUR");
        codigos.add("CAD");

        System.out.println("****************************************");
        System.out.println("          Conversor de Monedas          ");
        System.out.println("   Disponibles: " + codigos);
        System.out.println("****************************************");

        do{
            String base = "";
            String target = "";
            double amount = 0.0;

            System.out.println("\nDigita el código de la moneda base: ");
            base = teclado.nextLine().toUpperCase();

            if( !codigos.contains(base) ){
                System.out.println("Código de moneda no válido.");

                continue;
            }

            System.out.println("\nDigita el código de la moneda a la que se va a convertir: ");
            target = teclado.nextLine().toUpperCase();

            if( !codigos.contains(target) ){
                System.out.println("Código de moneda no válido.");

                continue;
            }

            System.out.println("\nDigita el monto a convertir: ");
            amount = teclado.nextDouble();

            Conversion resultado = conversor.convertir(base, target, amount);

            System.out.println("\nEl resultado de la conversión es: ");
            System.out.println(amount + " " + base + " es igual a "
                    + String.format("%.2f", resultado.conversion_result()) + " " + target );

            System.out.println("\nDigita 1 para realizar otra conversión o 0 para salir.");
            opcion = teclado.nextInt();

            // Limpia el buffer para evitar que se envie un \n automaticamente.
            teclado.nextLine();
        }while (opcion != 0);

    }


}
