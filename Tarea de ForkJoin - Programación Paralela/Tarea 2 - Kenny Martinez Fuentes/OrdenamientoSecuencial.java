import java.util.Arrays;

public class OrdenamientoSecuencial {
    private int[] datos;

    public OrdenamientoSecuencial(int[] datos) {
        this.datos = datos;
    }

    public int[] getDatos() {
        return datos;
    }

    public void setDatos(int[] datos) {
        this.datos = datos;
    }

    public void ordenar() {
        Arrays.sort(datos);
    }
}