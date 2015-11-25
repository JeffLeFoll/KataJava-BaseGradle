package pokerHand;

/**
 * Created by jcrestel on 25/11/2015.
 */
public enum CombinaisonDeCarte {
    PAIRE(100), TRIPLETTE(200), BRELAN(300), CARRE(400), SUITE(500), COULEUR(600), QUINTE(700);

    private int valeur;

    public int valeur() {
        return valeur;
    }

    CombinaisonDeCarte(int valeur) {
        this.valeur = valeur;
    }
}
