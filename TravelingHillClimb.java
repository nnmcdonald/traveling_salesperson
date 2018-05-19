import java.util.*;

public class TravelingHillClimb
{
  private int[][] costs;
  private int restartCount;
  private int cities;
  private int totalEvaluations;
  private int solutionFoundAtIteration;
  private List<Integer> optimalSolution;
  
  public TravelingHillClimb(int[][] travelCosts, int c)
  {
    costs = travelCosts;
    restartCount = 0;
    cities = c;
    totalEvaluations = 0;
    optimalSolution = new ArrayList<Integer>();
    for(int i = 0; i < cities; i++)
    {
      optimalSolution.add(i);
    }
  }
 
  //returns a random tour
  public List<Integer> randomRestart()
  {
    List<Integer> path = new ArrayList<Integer>();
    for(int i = 0; i < cities; i++)
    {
      path.add(i);
    }
    long seed = System.nanoTime();
    Random rand = new Random(seed);
    Collections.shuffle(path, rand);
    return path;
  }
  
  public void hillClimb(int restartLimit)
  {   
    while(restartCount < restartLimit)
    {
      //totalEvaluations++;
      List<Integer> path = randomRestart();
      int currentCost = getPathCost(path);
  
      for(int i = 0; i < cities - 1; i++)
      {
        for(int j = i + 1; j < cities; j++)
        {
          //Swap cities
          Collections.swap(path, i, j);
          int pathCost = getPathCost(path);
          totalEvaluations++;
          if(pathCost < currentCost)
          {
            currentCost = pathCost;
            if(currentCost < getPathCost(optimalSolution))
            {
              optimalSolution = path;
              solutionFoundAtIteration = totalEvaluations;
            }
            i = -1;
            break;
          }
          
          //Don't move to neighbor state, swap cities back
          Collections.swap(path, i, j);
      }
    }
      //Local optimum found, random restart
      restartCount++;
    }
    System.out.print("Optimal Path: ");
    for(int i = 0; i < cities; i++)
      System.out.print(optimalSolution.get(i) + " ");
    System.out.println("\nCost: " + getPathCost(optimalSolution));
    System.out.println("Iterations: " + totalEvaluations + " Solution found at: " + solutionFoundAtIteration);
  }
  
  //Calculates cost of a tour
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
