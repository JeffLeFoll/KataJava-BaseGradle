package presentationTDD;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static fr.arpinum.cocoritest.Affirmations.*;


public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void setUp() throws Exception {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void doitRetournerUneListeDe101Nombres(){

        //act
        List<String> résultat = fizzBuzz.calculer();

        //Assert
        alors().le(résultat.size()).est(101);
}

    @Test
    public void  doitRetournerUnCasSimple(){

        List<String> résultat = fizzBuzz.calculer();

        alors().le(résultat.get(2)).est("2");
    }

    @Test
    public void doitRetournerFizzPourMultipleDe3(){

        List<String> résultat = fizzBuzz.calculer();

        alors().le(résultat.get(3)).est("Fizz");
    }

    @Test
    public void doitRetournerFizzPourMultipleDe9(){

        List<String> résultat = fizzBuzz.calculer();

        alors().le(résultat.get(9)).est("Fizz");
    }


    @Test
    public void doitRetournerBuzzPourMultipleDe5(){

        List<String> résultat = fizzBuzz.calculer();

        alors().le(résultat.get(5)).est("Buzz");
    }

    @Test
    public void doitRetournerBuzzPourMultipleDe3EtDe5(){

        List<String> résultat = fizzBuzz.calculer();

        alors().le(résultat.get(45)).est("FizzBuzz");
    }
}


