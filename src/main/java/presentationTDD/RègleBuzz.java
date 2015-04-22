package presentationTDD;

public class RègleBuzz implements RègleDuJeuFizzBuzz {

    @Override
    public boolean estVérifié(int valeurAVérifier) {

        return Multiple.estUnMutlipleDe(valeurAVérifier, 5);
    }

    @Override
    public String valeurSiVérifié() {

        return "Buzz";
    }

}
