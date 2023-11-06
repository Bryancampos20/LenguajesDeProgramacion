class Circulo implements ObjetoRepresentable {
    private int radio;

    public Circulo(int radio) {
        this.radio = radio;
    }

    public int getRadio() {
        return this.radio;
    }

    @Override
    public void dibujar() {
        int diametro = this.radio * 2;
        int centro = this.radio;

        for (int i = 0; i <= diametro; i++) {
            for (int j = 0; j <= diametro; j++) {
                int distanciaCentro = (int) Math.sqrt((i - centro) * (i - centro) + (j - centro) * (j - centro));
                if (distanciaCentro > this.radio - 0.5 && distanciaCentro < this.radio + 0.5) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}