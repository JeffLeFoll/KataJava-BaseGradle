package pokerHand;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import java.util.Optional;

public class PokerTest {

    public static final String COEUR = "H";
    public static final String CARREAU = "D";
    public static final String TREFLE = "C";
    public static final String PIQUE = "S";

    @Test
    public void doitTesterLaPrésenceDUneCarteDansUneMain() {
        Main main = new Main();
        main.ajouterCarte(new Carte(TREFLE, Valeur.DEUX));

        boolean aDesCartesDansLaMain = main.aDesCartes();

        assertThat(aDesCartesDansLaMain).isTrue();
    }

    @Test
    public void doitRetournerLaCartePlusHaute() {
        Main main = new Main();
        main.ajouterCarte(new Carte(TREFLE, Valeur.DEUX));
        main.ajouterCarte(new Carte(TREFLE, Valeur.QUATRE));
        main.ajouterCarte(new Carte(TREFLE, Valeur.AS));
        main.ajouterCarte(new Carte(TREFLE, Valeur.SIX));
        main.ajouterCarte(new Carte(TREFLE, Valeur.TROIS));

        Carte carteLaPlusForte = main.carteLaPlusHaute().get();

        assertThat(carteLaPlusForte).isEqualToComparingFieldByField(new Carte(TREFLE, Valeur.AS));
    }

    @Test
    public void doitDetecterUnePaire() {
        Main main = new Main();
        main.ajouterCarte(new Carte(TREFLE, Valeur.DEUX));
        main.ajouterCarte(new Carte(TREFLE, Valeur.QUATRE));
        main.ajouterCarte(new Carte(TREFLE, Valeur.AS));
        main.ajouterCarte(new Carte(TREFLE, Valeur.SIX));
        main.ajouterCarte(new Carte(COEUR, Valeur.SIX));

        assertThat(main.existePaire()).isTrue();
    }

    @Test
    public void doitDetecterUneTriplette() {
        Main main = new Main();
        main.ajouterCarte(new Carte(TREFLE, Valeur.DEUX));
        main.ajouterCarte(new Carte(TREFLE, Valeur.QUATRE));
        main.ajouterCarte(new Carte(PIQUE, Valeur.SIX));
        main.ajouterCarte(new Carte(TREFLE, Valeur.SIX));
        main.ajouterCarte(new Carte(COEUR, Valeur.SIX));

        assertThat(main.existeTriplette()).isTrue();
        assertThat(main.existeBrelan()).isFalse();

    }
    @Test
    public void doitDetecterUnCarre() {
        Main main = new Main();
        main.ajouterCarte(new Carte(TREFLE, Valeur.DEUX));
        main.ajouterCarte(new Carte(CARREAU, Valeur.SIX));
        main.ajouterCarte(new Carte(PIQUE, Valeur.SIX));
        main.ajouterCarte(new Carte(TREFLE, Valeur.SIX));
        main.ajouterCarte(new Carte(COEUR, Valeur.SIX));

        assertThat(main.existeCarre()).isTrue();
    }

    @Test
    public void doitDetecterUnBrelan() {
        Main main = new Main();
        main.ajouterCarte(new Carte(TREFLE, Valeur.DEUX));
        main.ajouterCarte(new Carte(CARREAU, Valeur.DEUX));
        main.ajouterCarte(new Carte(PIQUE, Valeur.SIX));
        main.ajouterCarte(new Carte(TREFLE, Valeur.SIX));
        main.ajouterCarte(new Carte(COEUR, Valeur.SIX));

        assertThat(main.existeBrelan()).isTrue();
    }

    @Test
    public void doitDetecterUneCouleur() {
        Main main = new Main();
        main.ajouterCarte(new Carte(TREFLE, Valeur.DEUX));
        main.ajouterCarte(new Carte(TREFLE, Valeur.QUATRE));
        main.ajouterCarte(new Carte(TREFLE, Valeur.NEUF));
        main.ajouterCarte(new Carte(TREFLE, Valeur.VALET));
        main.ajouterCarte(new Carte(TREFLE, Valeur.ROI));

        assertThat(main.existeCouleur()).isTrue();
    }

    @Test
    public void doitDetecterUneSuite() {
        Main main = new Main();
        main.ajouterCarte(new Carte(TREFLE, Valeur.DEUX));
        main.ajouterCarte(new Carte(COEUR, Valeur.QUATRE));
        main.ajouterCarte(new Carte(CARREAU, Valeur.TROIS));
        main.ajouterCarte(new Carte(TREFLE, Valeur.CINQ));
        main.ajouterCarte(new Carte(TREFLE, Valeur.SIX));

        assertThat(main.existeSuite()).isTrue();
    }

    @Test
    public void doitDetecterUneQuinteFlush() {
        Main main = new Main();
        main.ajouterCarte(new Carte(TREFLE, Valeur.DEUX));
        main.ajouterCarte(new Carte(TREFLE, Valeur.QUATRE));
        main.ajouterCarte(new Carte(TREFLE, Valeur.TROIS));
        main.ajouterCarte(new Carte(TREFLE, Valeur.CINQ));
        main.ajouterCarte(new Carte(TREFLE, Valeur.SIX));

        assertThat(main.existeQuinteFlush()).isTrue();
    }

    @Test
    public void doitPouvoirDeterminerLaCombinaisonLaPlusForteDuneMain(){
        Main mainJoueur1 = new Main();
        mainJoueur1.ajouterCarte(new Carte(TREFLE, Valeur.DEUX));
        mainJoueur1.ajouterCarte(new Carte(TREFLE, Valeur.QUATRE));
        mainJoueur1.ajouterCarte(new Carte(PIQUE, Valeur.TROIS));
        mainJoueur1.ajouterCarte(new Carte(PIQUE, Valeur.VALET));
        mainJoueur1.ajouterCarte(new Carte(TREFLE, Valeur.VALET));

        CombinaisonDeCarte résultat = mainJoueur1.determinerLaCombinaisonLaPlusforte();

        assertThat(résultat).isEqualTo(CombinaisonDeCarte.PAIRE);
    }

    @Test
    public void doitComparerDeuxMains() {

        JeuxDePoker jeuxDePoker = new JeuxDePoker();

        // Deux valets
        Main mainJoueur1 = new Main();
        mainJoueur1.ajouterCarte(new Carte(TREFLE, Valeur.DEUX));
        mainJoueur1.ajouterCarte(new Carte(TREFLE, Valeur.QUATRE));
        mainJoueur1.ajouterCarte(new Carte(PIQUE, Valeur.TROIS));
        mainJoueur1.ajouterCarte(new Carte(PIQUE, Valeur.VALET));
        mainJoueur1.ajouterCarte(new Carte(TREFLE, Valeur.VALET));

        // Suite
        Main mainJoueur2 = new Main();
        mainJoueur2.ajouterCarte(new Carte(COEUR, Valeur.DEUX));
        mainJoueur2.ajouterCarte(new Carte(CARREAU, Valeur.QUATRE));
        mainJoueur2.ajouterCarte(new Carte(COEUR, Valeur.TROIS));
        mainJoueur2.ajouterCarte(new Carte(TREFLE, Valeur.CINQ));
        mainJoueur2.ajouterCarte(new Carte(TREFLE, Valeur.SIX));

        Optional<Main> mainGagnante = jeuxDePoker.determinerMainGagnante(mainJoueur1, mainJoueur2);

        assertThat(mainGagnante.get()).isEqualTo(mainJoueur2);
    }

    @Test
    public void doitComparerDeuxMainsEgales() {

        JeuxDePoker jeuxDePoker = new JeuxDePoker();

        // Deux valets
        Main mainJoueur1 = new Main();
        mainJoueur1.ajouterCarte(new Carte(TREFLE, Valeur.DEUX));
        mainJoueur1.ajouterCarte(new Carte(TREFLE, Valeur.QUATRE));
        mainJoueur1.ajouterCarte(new Carte(PIQUE, Valeur.TROIS));
        mainJoueur1.ajouterCarte(new Carte(PIQUE, Valeur.VALET));
        mainJoueur1.ajouterCarte(new Carte(TREFLE, Valeur.VALET));

        // Suite
        Main mainJoueur2 = new Main();
        mainJoueur2.ajouterCarte(new Carte(PIQUE, Valeur.DEUX));
        mainJoueur2.ajouterCarte(new Carte(PIQUE, Valeur.QUATRE));
        mainJoueur2.ajouterCarte(new Carte(TREFLE, Valeur.TROIS));
        mainJoueur2.ajouterCarte(new Carte(COEUR, Valeur.VALET));
        mainJoueur2.ajouterCarte(new Carte(CARREAU, Valeur.VALET));

        Optional<Main> mainGagnante = jeuxDePoker.determinerMainGagnante(mainJoueur1, mainJoueur2);

        assertThat(mainGagnante.isPresent()).isFalse();
    }
}
