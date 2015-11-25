package pokerHand;

import java.util.Optional;

/**
 * Created by jcrestel on 21/10/2015.
 */
public class JeuxDePoker {

    public Optional<Main> determinerMainGagnante(Main mainJoueur1, Main mainJoueur2) {

        Main mainGagnante = null;

        CombinaisonDeCarte combinasionMainJoueur1 = mainJoueur1.determinerLaCombinaisonLaPlusforte();
        CombinaisonDeCarte combinasionMainJoueur2 = mainJoueur2.determinerLaCombinaisonLaPlusforte();

        if (combinasionMainJoueur1.valeur() > combinasionMainJoueur2.valeur()) {
            mainGagnante = mainJoueur1;
        } else if (combinasionMainJoueur2.valeur() > combinasionMainJoueur1.valeur()) {
            mainGagnante = mainJoueur2;
        }

        return Optional.ofNullable(mainGagnante);

    }
}
