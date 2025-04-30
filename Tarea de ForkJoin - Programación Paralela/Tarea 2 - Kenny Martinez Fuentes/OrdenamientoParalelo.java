import java.util.concurrent.RecursiveAction;
import java.util.Arrays;

public class OrdenamientoParalelo extends RecursiveAction {
    private static final int LIMITE = 10;
    private int[] datos;
    private int inicio;
    private int fin;

    public OrdenamientoParalelo(int[] datos, int inicio, int fin) {
        this.datos = datos;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    protected void compute() {
        if ((fin - inicio) <= LIMITE) {
            Arrays.sort(datos, inicio, fin);
        } else {
            int medio = (inicio + fin) / 2;
            OrdenamientoParalelo izquierda = new OrdenamientoParalelo(datos, inicio, medio);
            OrdenamientoParalelo derecha = new OrdenamientoParalelo(datos, medio, fin);
            invokeAll(izquierda, derecha);
            merge(inicio, medio, fin);
        }
    }

    private void merge(int inicio, int medio, int fin) {
        int[] temp = new int[fin - inicio];
        int i = inicio, j = medio, k = 0;

        while (i < medio && j < fin) {
            if (datos[i] <= datos[j]) {
                temp[k++] = datos[i++];
            } else {
                temp[k++] = datos[j++];
            }
        }

        while (i < medio) {
            temp[k++] = datos[i++];
        }

        while (j < fin) {
            temp[k++] = datos[j++];
        }

        for (int m = 0; m < temp.length; m++) {
            datos[inicio + m] = temp[m];
        }
    }
}