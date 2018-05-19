import java.util.*;

public class TravelingSalesperson
{
  //Creates a random table of travel costs from city to city
  public static int[][] makeCostTable(int cities)
  {
    int[][] cost = new int[cities][cities];
    Random rand = new Random(System.nanoTime());
    for(int i = 0; i < cities; i++)
    {      
      for(int j = 0; j < cities; j++)
      {
        if(j != i)
          cost[i][j] = rand.nextInt(2401) + 100;
      }
    }
    return cost;
  }
  
  public static void main(String[] args)
  {
    //5 random cost tables with various number of cities
    int[][] t = makeCostTable(10);
    int[][] t1 = makeCostTable(11);
    int[][] t2 = makeCostTable(11);
    int[][] t3 = makeCostTable(12);
    int[][] t4 = makeCostTable(12);

    System.out.println("Cost table t Hill Climbing results:");
    for(int i = 0; i < 5; i++)
    {
      TravelingHillClimb c = new TravelingHillClimb(t, 10);
      double startTime = System.currentTimeMillis();
      c.hillClimb(1000);     
      System.out.print("Search Cost: ");
      System.out.println((System.currentTimeMillis()- startTime) + "ms");
    }
    System.out.println();
    
    System.out.println("Cost table t1 Hill Climbing results:");
    for(int i = 0; i < 5; i++)
    {
      TravelingHillClimb c = new TravelingHillClimb(t1, 11);
      double startTime = System.currentTimeMillis();
      c.hillClimb(1000);
      System.out.print("Search Cost: ");
      System.out.println((System.currentTimeMillis()- startTime) + "ms");
    }
    System.out.println();
    
    System.out.println("Cost table t2 Hill Climbing results:");
    for(int i = 0; i < 5; i++)
    {
      TravelingHillClimb c = new TravelingHillClimb(t2, 11);
      double startTime = System.currentTimeMillis();
      c.hillClimb(1000);    
      System.out.print("Search Cost: ");
      System.out.println((System.currentTimeMillis()- startTime) + "ms");
    }
    System.out.println();
    
    System.out.println("Cost table t3 Hill Climbing results:");
    for(int i = 0; i < 5; i++)
    {
      TravelingHillClimb c = new TravelingHillClimb(t3, 12);
      double startTime = System.currentTimeMillis();
      c.hillClimb(1000);     
      System.out.print("Search Cost: ");
      System.out.println((System.currentTimeMillis()- startTime) + "ms");
    }
    System.out.println();
    
    System.out.println("Cost table t4 Hill Climbing results:");
    for(int i = 0; i < 5; i++)
    {
      TravelingHillClimb c = new TravelingHillClimb(t4, 12);
      double startTime = System.currentTimeMillis();
      c.hillClimb(1000);     
      System.out.print("Search Cost: ");
      System.out.println((System.currentTimeMillis()- startTime) + "ms");
    }
    System.out.println();
    
    System.out.println("Cost table t Simulated Annealing results:");
    for(int i = 0; i < 5; i++)
    {
      TravelingAnnealing a = new TravelingAnnealing(t, 10);
      double startTime = System.currentTimeMillis();
      a.anneal();      
      System.out.print("Search Cost: ");
      System.out.println((System.currentTimeMillis()- startTime) + "ms");
    }
    System.out.println();
    
    System.out.println("Cost table t1 Simulated Annealing results:");
    for(int i = 0; i < 5; i++)
    {
      TravelingAnnealing a = new TravelingAnnealing(t1, 11);
      double startTime = System.currentTimeMillis();
      a.anneal();      
      System.out.print("Search Cost: ");
      System.out.println((System.currentTimeMillis()- startTime) + "ms");
    }
    System.out.println();
    
    System.out.println("Cost table t2 Simulated Annealing results:");
    for(int i = 0; i < 5; i++)
    {
      TravelingAnnealing a = new TravelingAnnealing(t2, 11);
      double startTime = System.currentTimeMillis();
      a.anneal();      
      System.out.print("Search Cost: ");
      System.out.println((System.currentTimeMillis()- startTime) + "ms");
    }
    System.out.println();
    
    System.out.println("Cost table t3 Simulated Annealing results:");
    for(int i = 0; i < 5; i++)
    {
      TravelingAnnealing a = new TravelingAnnealing(t3, 12);
      double startTime = System.currentTimeMillis();
      a.anneal();      
      System.out.print("Search Cost: ");
      System.out.println((System.currentTimeMillis()- startTime) + "ms");
    }
    System.out.println();
    
    System.out.println("Cost table t4 Simulated Annealing results:");
    for(int i = 0; i < 5; i++)
    {
      TravelingAnnealing a = new TravelingAnnealing(t4, 12);
      double startTime = System.currentTimeMillis();
      a.anneal();  
      System.out.print("Search Cost: ");
      System.out.println((System.currentTimeMillis()- startTime) + "ms");
    }
    System.out.println();
    
  }
}