package pokerHand;

import static org.assertj.core.api.Assertions.*;
import static fr.arpinum.cocoritest.Affirmations.*;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

public class PokerTest {

    @Test
    public void doitTesterLaPrésenceDUneCarteDansUneMain() {
        Main main = new Main();
        main.ajouterCarte(new Carte("C", Valeur.C2));

        boolean aDesCartesDansLaMain = main.aDesCartes();

        assertThat(aDesCartesDansLaMain).isTrue();
    }

    @Test
    public void doitRetournerLaCartePlusHaute() {
        Main main = new Main();
        main.ajouterCarte(new Carte("C", Valeur.C2));
        main.ajouterCarte(new Carte("C", Valeur.C4));
        main.ajouterCarte(new Carte("C", Valeur.CA));
        main.ajouterCarte(new Carte("C", Valeur.C6));
        main.ajouterCarte(new Carte("C", Valeur.C3));

        Carte carteLaPlusForte = main.carteLaPlusHaute().get();

        assertThat(carteLaPlusForte).isEqualToComparingFieldByField(new Carte("C", Valeur.CA));
    }

    @Test
    public void doitDetecterUnePaire() {
        Main main = new Main();
        main.ajouterCarte(new Carte("C", Valeur.C2));
        main.ajouterCarte(new Carte("C", Valeur.C4));
        main.ajouterCarte(new Carte("C", Valeur.CA));
        main.ajouterCarte(new Carte("C", Valeur.C6));
        main.ajouterCarte(new Carte("H", Valeur.C6));

        assertThat(main.existePaire()).isTrue();
    }

    @Test
    public void doitDetecterUneTriplette() {
        Main main = new Main();
        main.ajouterCarte(new Carte("C", Valeur.C2));
        main.ajouterCarte(new Carte("C", Valeur.C4));
        main.ajouterCarte(new Carte("S", Valeur.C6));
        main.ajouterCarte(new Carte("C", Valeur.C6));
        main.ajouterCarte(new Carte("H", Valeur.C6));

        assertThat(main.existeTriplette()).isTrue();
        assertThat(main.existeBrelan()).isFalse();

    }
    @Test
    public void doitDetecterUnCarre() {
        Main main = new Main();
        main.ajouterCarte(new Carte("C", Valeur.C2));
        main.ajouterCarte(new Carte("D", Valeur.C6));
        main.ajouterCarte(new Carte("S", Valeur.C6));
        main.ajouterCarte(new Carte("C", Valeur.C6));
        main.ajouterCarte(new Carte("H", Valeur.C6));

        assertThat(main.existeCarre()).isTrue();
    }

    @Test
    public void doitDetecterUnBrelan() {
        Main main = new Main();
        main.ajouterCarte(new Carte("C", Valeur.C2));
        main.ajouterCarte(new Carte("D", Valeur.C2));
        main.ajouterCarte(new Carte("S", Valeur.C6));
        main.ajouterCarte(new Carte("C", Valeur.C6));
        main.ajouterCarte(new Carte("H", Valeur.C6));

        assertThat(main.existeBrelan()).isTrue();
    }

    @Test
    public void doitDetecterUneCouleur() {
        Main main = new Main();
        main.ajouterCarte(new Carte("C", Valeur.C2));
        main.ajouterCarte(new Carte("C", Valeur.C4));
        main.ajouterCarte(new Carte("C", Valeur.C9));
        main.ajouterCarte(new Carte("C", Valeur.CJ));
        main.ajouterCarte(new Carte("C", Valeur.CK));

        assertThat(main.existeCouleur()).isTrue();
    }

    @Test
    public void doitDetecterUneSuite() {
        Main main = new Main();
        main.ajouterCarte(new Carte("C", Valeur.C2));
        main.ajouterCarte(new Carte("H", Valeur.C4));
        main.ajouterCarte(new Carte("D", Valeur.C3));
        main.ajouterCarte(new Carte("C", Valeur.C5));
        main.ajouterCarte(new Carte("C", Valeur.C6));

        assertThat(main.existeSuite()).isTrue();
    }

    @Test
    public void doitDetecterUneQuinteFlush() {
        Main main = new Main();
        main.ajouterCarte(new Carte("C", Valeur.C2));
        main.ajouterCarte(new Carte("C", Valeur.C4));
        main.ajouterCarte(new Carte("C", Valeur.C3));
        main.ajouterCarte(new Carte("C", Valeur.C5));
        main.ajouterCarte(new Carte("C", Valeur.C6));

        assertThat(main.existeQuinteFlush()).isTrue();
    }


    public void doitComparerDeuxMains() {

        JeuxDePoker jeuxDePoker = new JeuxDePoker();

        Main mainJoueur1 = new Main();
        mainJoueur1.ajouterCarte(new Carte("C", Valeur.C2));
        mainJoueur1.ajouterCarte(new Carte("C", Valeur.C4));
        mainJoueur1.ajouterCarte(new Carte("S", Valeur.C3));
        mainJoueur1.ajouterCarte(new Carte("S", Valeur.CJ));
        mainJoueur1.ajouterCarte(new Carte("C", Valeur.CJ));

        Main mainJoueur2 = new Main();
        mainJoueur2.ajouterCarte(new Carte("H", Valeur.C2));
        mainJoueur2.ajouterCarte(new Carte("D", Valeur.C4));
        mainJoueur2.ajouterCarte(new Carte("H", Valeur.C3));
        mainJoueur2.ajouterCarte(new Carte("C", Valeur.C5));
        mainJoueur2.ajouterCarte(new Carte("C", Valeur.C6));

        assertThat(jeuxDePoker.determinerMainGagnante(mainJoueur1, mainJoueur2)).isEqualTo(mainJoueur2);
    }
}
