import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneticAlgorithm {



    public List<Hyperparameter> createPopulation() {

        List<Hyperparameter> currentPopulation = new ArrayList<Hyperparameter>();

        for (int i = 0; i < 100; i++) { // number of childs

            int fast = 0; // 0
            int slow = -1;    // -1                ;
            Hyperparameter hyperparameter = new Hyperparameter();


            while (slow <= fast) {
                fast = getRandomNumberUsingNextInt(5, 50);
                slow = getRandomNumberUsingNextInt(12, 60);

                System.out.println("fast is " + fast + " slow is " + slow + " Набор параметров номер " + i + " ");
            }
            hyperparameter.setExampleName("Набор параметров №"+ i + " ");
            hyperparameter.setFastLeng(fast);
            hyperparameter.setSlowLeng(slow);
            hyperparameter.setTimeFrame(15);
            hyperparameter.setStopLoss(4);
            hyperparameter.setTakeProfit(5);
            hyperparameter.setTrail(0);
            hyperparameter.setDeviationLeng(5);
            hyperparameter.setDeviationScale(-50);
            hyperparameter.setExpScale(0.05);

            currentPopulation.add(hyperparameter);
        }

        return currentPopulation;
    }

    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }


}
