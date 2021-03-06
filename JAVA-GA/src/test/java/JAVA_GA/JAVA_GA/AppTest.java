package JAVA_GA.JAVA_GA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    public void testCalculateFitnessFunction(){

        int[] time  = {3,1,3,2,3,1,5,3,3,1,3,3,5,3,5,3,1,3,2,2};
        int[] points = {2,5,2,5,2,2,5,7,2,10,10,2,5,2,5,7,2,10,2,2};

        GeneticKnapsack gK = new GeneticKnapsack(25, time,points);
        assertTrue(gK.calculateFitness("11111111110000000000")==42.0);
        assertTrue(gK.calculateFitness("10000000000000000000")==2.0);
        assertTrue(gK.calculateFitness("01010010000000000000")==15.0);
        assertTrue(gK.calculateFitness("10011001100111100011")==0.0);
        assertTrue(gK.calculateFitness("10011110101011110100")==0.0);
        assertTrue(gK.calculateFitness("00010011001100000011")==33.0);
        assertTrue(gK.calculateFitness("01011001111010101111")==0.0);
        assertTrue(gK.calculateFitness("11101010001001100110")==0.0);

     }
  

    public void testSortFunction(){

        Map<Object, Double> testMap = new HashMap<Object, Double>();
        testMap.clear();
        testMap.put((Object)"11111111110000000000", 42.0);
        testMap.put((Object)"10000000000000000000", 2.0);
        testMap.put((Object)"01010010000000000000", 15.0);
        testMap.put((Object)"00000000001111111111", 27.0);
        testMap.put((Object)"00000000000000000001", 10.0);
        testMap.put((Object)"00000001010010000000", 55.0);

        GeneticKnapsack gK = new GeneticKnapsack();
        Map<Object, Double> sortedMap = new HashMap<Object, Double>();
        sortedMap.clear();
        sortedMap =gK.doSort(testMap);
        List<Object> keys = new ArrayList<>(sortedMap.keySet());


        List<String> list = Arrays.asList("10000000000000000000", "00000000000000000001", "01010010000000000000", "00000000001111111111","11111111110000000000", "00000001010010000000");
        List<Object> correctlist = new ArrayList<Object>(list);

        assertTrue( keys.equals(correctlist));

    }

    public void testSumValue(){

        int[] time  = {3,1,3,2,3,1,5,3,3,1,3,3,5,3,5,3,1,3,2,2};
        int[] points = {2,5,2,5,2,2,5,7,2,10,10,2,5,2,5,7,2,10,2,2};

        GeneticKnapsack gK = new GeneticKnapsack(25, time,points);
        assertTrue(gK.sumValue("10011001100111100011")==36.0);
        assertTrue(gK.sumValue("10011110101011110100")==57.0);
        assertTrue(gK.sumValue("00010011001100000011")==33.0);
        assertTrue(gK.sumValue("01011001111010101111")==67.0);
        assertTrue(gK.sumValue("11101010001001100110")==45.0);
        assertTrue(gK.sumValue("11111111110000000000")==42.0);
        assertTrue(gK.sumValue("10000000000000000000")==2.0);
        assertTrue(gK.sumValue("01010010000000000000")==15.0);
    }
 //this is a general test case for crossover function and it is supposed to fail as the returntype of docrossoverfunction is void and not boolean
//public void testcrossoverfunction()
//{
//	 int[]time= {1,2};int[] points= {3,4};
//	GeneticKnapsack knapsacktest=new GeneticKnapsack(75,2,time,points,0.6,0.7,4,3);
//	int maxValue=75;
//    String [] population = new String[maxValue];
//    for (int i = 0; i < maxValue; i++) {
//        knapsacktest.doCrossover(100,101);
//    }
//   System.out.println(population.length);
//    assertTrue(knapsacktest!=null);
//
//	}   
    public void testflip() {
    	  GeneticKnapsack gK = new GeneticKnapsack();
          assertTrue(gK.flip('1')=='0');
//this method forms the basis for mutation in the implementation
    }
    //this testcase test the result of mutated value at the index 10 but it is supposed to fail as the return type of doMutation is void
//    public void testMutation() {
//    	 GeneticKnapsack gK = new GeneticKnapsack();
//    	 int maxValue=75;String [] population = new String[maxValue];
//    	 gK.doMutation(10);
//    	 for(int i=0;i<maxValue;i++) {
//    	 System.out.println(population[10]);
//    	 }
//    	 assertTrue(gK!=null);
//    }
public void testGenerateRandomString(){
        GeneticKnapsack gK = new GeneticKnapsack();
        int populationSize = 1000;
        String [] population = new String[populationSize];
        for (int i = 0; i < populationSize; i++) {
            population[i] = gK.generateRandomString(100);
        }
        if(population == null ){
            assertTrue(false);
        }
        for (int k = 0; k < populationSize; k++){
            if (population[k].length()!=100){
                assertTrue(false);
            }

        }
    }
    public void testApp()
    {
        assertTrue( true );
    }
}
