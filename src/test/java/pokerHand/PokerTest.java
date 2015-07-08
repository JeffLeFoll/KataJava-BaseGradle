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
}
