package pokerHand;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
            long nombreDeCarteDeCetteValeur = calculerNombreDeCarteDeLaValeur(carte.getValeur());

            if (nombreDeCarteDeCetteValeur == 2) {
                return true;
            }
        }

        return false;
    }

    public boolean existeTriplette() {
        for (Carte carte : this.cartes) {
            long nombreDeCarteDeCetteValeur = calculerNombreDeCarteDeLaValeur(carte.getValeur());

            if (nombreDeCarteDeCetteValeur == 3) {
                return true;
            }
        }

        return false;
    }

    private long calculerNombreDeCarteDeLaValeur(Valeur valeurDeLaCarte) {
        return cartes.stream()
                        .filter(carteDeLaMain -> carteDeLaMain.getValeur().equals(valeurDeLaCarte))
                        .count();
    }

    public boolean existeCarre() {
        for (Carte carte : this.cartes) {
            long nombreDeCarteDeCetteValeur = calculerNombreDeCarteDeLaValeur(carte.getValeur());

            if (nombreDeCarteDeCetteValeur == 4) {
                return true;
            }
        }
        return false;
    }

    public boolean existeBrelan() {
        return existeTriplette() && existePaire();
    }

    public boolean existeCouleur() {
        for (Carte carte : this.cartes) {
            long nombreDeCarteDeCetteCouleur = calculerNombreDeCarteDeLaCouleur(carte.getCouleur());

            if (nombreDeCarteDeCetteCouleur == 5) {
                return true;
            }
        }
        return false;
    }

    private long calculerNombreDeCarteDeLaCouleur(String couleur) {
        return cartes.stream()
                .filter(carteDeLaMain -> carteDeLaMain.getCouleur().equals(couleur))
                .count();
    }

    public boolean existeSuite() {

        Comparator<? super Carte> ordreDeGrandeur = (carteUne, carteDeux) -> carteUne.getValeur().compareTo(carteDeux.getValeur());

        List<Carte> cartesTriees = cartes.stream().sorted(ordreDeGrandeur).collect(Collectors.toList());

        for (int i = 1; i < cartesTriees.size();) {
            Carte cartePrecedente = cartesTriees.get(i-1);
            Carte carteCourante = cartesTriees.get(i);

            if(carteCourante.getValeur().poids() == cartePrecedente.getValeur().poids()+1){
                i++;
            } else {
                return false;
            }

        }

        return true;
    }

    public boolean existeQuinteFlush() {
          return existeSuite() && existeCouleur();
            }
}