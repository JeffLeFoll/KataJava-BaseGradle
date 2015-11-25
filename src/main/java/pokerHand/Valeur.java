package pokerHand;

public enum Valeur {
    DEUX(2), TROIS(3), QUATRE(4), CINQ(5), SIX(6), SEPT(7), HUIT(8), NEUF(9), DIX(10), VALET(11), DAME(12), ROI(13), AS(14);

    private int poids;

    Valeur(int poids) {
        this.poids = poids;
    }

    public int poids() {
        return poids;
    }
}
