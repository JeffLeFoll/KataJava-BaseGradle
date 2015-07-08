package pokerHand;

public enum Valeur {
    C2(2), C3(3), C4(4), C5(5), C6(6), C7(7), C8(8), C9(9), CT(10), CJ(11), CQ(12), CK(13), CA(14);

    private int poids;

    Valeur(int poids) {
        this.poids = poids;
    }

    public int poids() {
        return poids;
    }
}
