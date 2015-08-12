package pokerHand;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    List<Carte> cartes = new ArrayList<>();

    public boolean aDesCartes() {
        return !cartes.isEmpty();
    }

    public void ajouterCarte(Carte carte) {
        cartes.add(carte);
    }

    public Optional<Carte> carteLaPlusHaute() {
        return cartes.stream()
                .max((carte1, carte2) -> carte1.getValeur().poids() - carte2.getValeur().poids());
    }

    public boolean existePaire() {
        for (Carte carte : this.cartes) {
            long nombreDeCarteDeCetteValeur = cartes.stream()
                    .filter(carteDeLaMain -> carteDeLaMain.getValeur().equals(carte.getValeur()))
                    .count();

            if (nombreDeCarteDeCetteValeur == 2) {
                return true;
            }
        }

        return false;
    }
}
