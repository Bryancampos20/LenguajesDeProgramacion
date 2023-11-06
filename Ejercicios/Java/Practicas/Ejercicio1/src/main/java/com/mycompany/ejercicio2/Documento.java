import java.util.ArrayList;
import java.util.List;

class Documento {
    private List<Hoja> hojas;

    public Documento() {
        this.hojas = new ArrayList<>();
    }

    public void agregarHoja(Hoja hoja) {
        this.hojas.add(hoja);
    }

    public void imprimirDocumento() {
        System.out.println("Contenido del documento:");
        for (Hoja hoja : hojas) {
            hoja.imprimirHoja();
        }
    }

}