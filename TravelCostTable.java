import java.util.Random;

public class TravelCostTable
{
  private int cost[][];
  public TravelCostTable(int cities)
  {
    cost = new int[cities][cities];
    Random rand = new Random(System.currentTimeMillis());
    for(int i = 0; i < cities; i++)
    {      
      for(int j = 0; j < cities; j++)
      {
        if(j != i)
          cost[i][j] = rand.nextInt(2401) + 100;
      }
    }
  }
  
  public int getCost(int city_a, int city_b)
  {
    return cost[city_a][city_b];
  }
}