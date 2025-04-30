import java.util.Scanner;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ingreso de N
        System.out.print("Ingrese la cantidad de elementos (N): ");
        int n = scanner.nextInt();

        int[] datos = new int[n];

        // Ingreso de elementos
        System.out.println("Ingrese los " + n + " números:");
        for (int i = 0; i < n; i++) {
            datos[i] = scanner.nextInt();
        }

        // Secuencial
        int[] datosSecuencial = Arrays.copyOf(datos, datos.length);
        OrdenamientoSecuencial secuencial = new OrdenamientoSecuencial(datosSecuencial);
        secuencial.ordenar();
        System.out.println("Resultado Secuencial: " + Arrays.toString(secuencial.getDatos()));

        // Paralelo
        int[] datosParalelo = Arrays.copyOf(datos, datos.length);
        OrdenamientoParalelo paralelo = new OrdenamientoParalelo(datosParalelo, 0, datosParalelo.length);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(paralelo);
        System.out.println("Resultado Paralelo: " + Arrays.toString(datosParalelo));
        scanner.close();
    }
}