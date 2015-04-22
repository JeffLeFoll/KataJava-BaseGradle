package presentationTDD;

public class RègleFizz implements RègleDuJeuFizzBuzz {

    @Override
    public boolean estVérifié(int valeurAVérifier) {

        return Multiple.estUnMutlipleDe(valeurAVérifier, 3);
    }

    @Override
    public String valeurSiVérifié() {

        return "Fizz";
    }

}
