package presentationTDD;

public class RègleFizzBuzz implements RègleDuJeuFizzBuzz {

    @Override
    public boolean estVérifié(int valeurAVérifier) {

        return Multiple.estUnMutlipleDe(valeurAVérifier, 15);
    }

    @Override
    public String valeurSiVérifié() {

        return "FizzBuzz";
    }

}
