import java.util.*;

public class TravelingAnnealing
{
  private int[][] costs;
  private List<Integer> currentState;
  private List<Integer> optimalSolution;
  private int totalIterations;
  private int solutionFoundAtIteration;
  private int cities;
  private double temperature;
  private double alpha;
  
  public TravelingAnnealing(int[][] costGraph, int c)
  {
    costs = costGraph;
    cities = c;
    totalIterations = 0;
    solutionFoundAtIteration = 0;
    temperature = 2500;
    alpha = 0.99;
    currentState = new ArrayList<Integer>();
    optimalSolution = new ArrayList<Integer>();

    for(int i = 0; i < cities; i++)
    {
      optimalSolution.add(i);
      currentState.add(i);
    }
    //Random start state
    long seed = System.nanoTime();
    Random rand = new Random(seed);
    Collections.shuffle(currentState, rand);
  }
  
  public void anneal()
  {

    while(true)
    {
      long seed = System.nanoTime();
      Random rand = new Random(seed);
      for(int i = 0; i < 1000; i++)
      {
        totalIterations++;
        int currentCost = getPathCost(currentState);
        int x = rand.nextInt(cities);
        int y = rand.nextInt(cities);
        
        while(x == y)
        {
          x = rand.nextInt(cities);
          y = rand.nextInt(cities);
        } 
        //Move to random neighbor state
        Collections.swap(currentState, x, y);

        int deltaE = currentCost - getPathCost(currentState);
        
        //probability a worse choice is chosen = e^(deltaE/temperature)
        //if random double is less than probability keep neighbor state
        //Will always move to a better state and will sometimes move to a worse state depending on temperature and 
        //deltaE
        if(rand.nextDouble() > Math.pow(Math.E, (deltaE/temperature)))
          Collections.swap(currentState, x, y);   
        //Check for optimal solution
        if(getPathCost(currentState) < getPathCost(optimalSolution))
        {
          solutionFoundAtIteration = totalIterations;
          for(int j = 0; j < cities; j++)
          {
            optimalSolution.set(j, currentState.get(j));      
          }
        }
      }
      //lower the temp
      temperature *= alpha;
      if(temperature < 0.00001)
      {
        System.out.print("Optimal Path: ");
        for(int i = 0; i < cities; i++)
          System.out.print(optimalSolution.get(i) + " ");
        System.out.println("\nCost: " + getPathCost(optimalSolution));
        System.out.println("Iterations: " + totalIterations + " Solution found at: " + solutionFoundAtIteration);
        break;
      }
    }
  }
  
  public int getPathCost(List<Integer> p)
  {
    int pathCost = 0;
    for(int i = 0; i < cities - 1; i++)
    {
      pathCost += costs[p.get(i)][p.get(i + 1)];
    }
    //return to original city
    pathCost += costs[p.get(cities -1)][p.get(0)];
    return pathCost;
  }
}