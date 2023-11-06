class Texto implements ObjetoRepresentable {
    private String contenido;

    public Texto(String contenido) {
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public void dibujar() {
        System.out.println(this.contenido);
    }
}