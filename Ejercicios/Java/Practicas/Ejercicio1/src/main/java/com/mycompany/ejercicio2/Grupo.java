
import java.util.ArrayList;
import java.util.List;

class Grupo implements ObjetoRepresentable {
    private List<ObjetoRepresentable> objetos;

    public Grupo() {
        this.objetos = new ArrayList<>();
    }

    public void agregarObjeto(ObjetoRepresentable objeto) {
        this.objetos.add(objeto);
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando un grupo que contiene los siguientes objetos:");
        for (ObjetoRepresentable objeto : this.objetos) {
            objeto.dibujar();
        }
    }

}