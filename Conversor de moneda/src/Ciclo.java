import java.util.InputMismatchException;
import java.util.Scanner;

public class Ciclo {
    public void ejecutar() {
        int opcion = 0;
        String menu = """
                **************************************************
                Sea bienvenido/a al Conversor de Moneda
                
                1) Dólar americano ==> Peso argentino
                2) Peso argentino ==> Dólar americano
                3) Dólar americano ==> Real brasileño
                4) Real brasileño ==> Dólar americano
                5) Dólar americano ==> Peso colombiano
                6) Peso colombiano ==> Dólar americano
                7) Salir
                
                Elija una opción válida:
                **************************************************
                """;
        String base_code, target_code;
        double monto;
        Busqueda miBusqueda = new Busqueda();

        while (opcion != 7) {
            System.out.println(menu);
            Scanner teclado = new Scanner(System.in);
            try {
                opcion = teclado.nextInt();
                if (opcion == 7) {
                    System.out.println("Finalizando la ejecución");
                    continue;
                } else if (opcion < 1 || opcion > 7) {
                    System.out.println("Opción no válida\n");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Elija una opción válida\n");
                continue;
            }
            System.out.println("Ingrese el valor que desea convertir:");
            try {
                monto = teclado.nextDouble();
                if (monto < 0) {
                    System.out.println("Ingrese un valor númerico válido\n");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un valor númerico válido\n");
                continue;
            }

            switch (opcion) {
                case 1:
                    base_code = "USD";
                    target_code = "ARS";
                    miBusqueda.muestraResultado(base_code, target_code, monto);
                    break;
                case 2:
                    base_code = "ARS";
                    target_code = "USD";
                    miBusqueda.muestraResultado(base_code, target_code, monto);
                    break;
                case 3:
                    base_code = "USD";
                    target_code = "BRL";
                    miBusqueda.muestraResultado(base_code, target_code, monto);
                    break;
                case 4:
                    base_code = "BRL";
                    target_code = "USD";
                    miBusqueda.muestraResultado(base_code, target_code, monto);
                    break;
                case 5:
                    base_code = "USD";
                    target_code = "COP";
                    miBusqueda.muestraResultado(base_code, target_code, monto);
                    break;
                case 6:
                    base_code = "COP";
                    target_code = "USD";
                    miBusqueda.muestraResultado(base_code, target_code, monto);
                    break;
            }
        }
    }
}
