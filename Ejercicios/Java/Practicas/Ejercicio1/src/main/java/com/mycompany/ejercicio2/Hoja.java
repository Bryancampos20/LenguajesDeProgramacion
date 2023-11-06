import java.util.ArrayList;
import java.util.List;

class Hoja {
    private List<ObjetoRepresentable> objetos;

    public Hoja() {
        this.objetos = new ArrayList<>();
    }

    public void agregarObjeto(ObjetoRepresentable objeto) {
        this.objetos.add(objeto);
    }

    public void imprimirHoja() {
        System.out.println("Contenido de la hoja:");
        for (ObjetoRepresentable objeto : objetos) {
            objeto.dibujar();
        }
    }
}    