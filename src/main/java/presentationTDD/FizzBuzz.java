package presentationTDD;

import com.google.common.collect.Lists;

import java.util.*;

public class FizzBuzz {

    private List<RègleDuJeuFizzBuzz> règlesDuJeu = Lists.newArrayList(new RègleFizzBuzz(), new RègleFizz(), new RègleBuzz());


    public List<String> calculer() {

        List<String> résultat = new ArrayList<>();

        for (int index = 0; index < 101; index++) {
            résultat.add(soumettreLIndexAuxRègles(index));
        }

        return résultat;
    }

    private String soumettreLIndexAuxRègles(int index) {

        for (RègleDuJeuFizzBuzz règle : règlesDuJeu) {
            if (règle.estVérifié(index)) {
                return règle.valeurSiVérifié();
            }
        }
        return  String.valueOf(index);
    }

}
