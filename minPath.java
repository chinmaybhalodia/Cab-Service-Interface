import java.util.*;

//import Map.Graph;
public class minPath {

  static int Inf = Integer.MAX_VALUE;

  public static double[] dijkstra(Map.Graph graph, int source, int go_to, int V, int priority) {

    boolean[] visited = new boolean[V];
    double[] distance = new double[V];
    double[] time = new double[V];
    int[] parent = new int[V];

    for (int i = 0; i < V; i++) {
      visited[i] = false;
      distance[i] = Inf;
      time[i] = Inf;
    }

    // Distance of source is zero
    distance[source] = 0;
    time[source] = 0;
    parent[0] = -1;

    for (int i = 0; i < V; i++) {

      // Update the distance between neighbouring vertex and source vertex
      int u = findMinDistance(distance, visited);
      visited[u] = true;

      LinkedList<Map.Edge> list = graph.adjacencylist[u];
      // Update all the neighbouring vertex distances
      for (int j = 0; j < list.size(); j++) {

        if (priority == 0) {
          if ((!visited[list.get(j).destination])
              && (distance[u] + list.get(j).weight[priority] < distance[list.get(j).destination])) {
            distance[list.get(j).destination] = distance[u] + list.get(j).weight[priority];
            time[list.get(j).destination] = time[u] + list.get(j).weight[1];
            parent[list.get(j).destination] = u;
          }
        }

        else if (priority == 1) {
          if ((!visited[list.get(j).destination])
              && (time[u] + list.get(j).weight[priority] < time[list.get(j).destination])) {
            time[list.get(j).destination] = time[u] + list.get(j).weight[priority];
            distance[list.get(j).destination] = distance[u] + list.get(j).weight[0];
            parent[list.get(j).destination] = u;
          }
        }
      }

      if (u == go_to)
        break;
    }
    return new double[] { distance[go_to], time[go_to] };
  }
  // ---------------------------------------------------------------------------------------------------------------//
  // Finding the minimum distance
  private static int findMinDistance(double[] distance, boolean[] visited) {
    double minDistance = Inf;
    int minDistanceVertex = 0;
    for (int i = 0; i < distance.length; i++) {
      if (!visited[i] && distance[i] < minDistance) {
        minDistance = distance[i];
        minDistanceVertex = i;
      }
    }
    return minDistanceVertex;
  }

  // ---------------------------------------------------------------------------------------------------------------//
  // Finding the cost of the fare
  public static double findCost(double tripDistance, int choice) {

    //cab types = "Auto", "Mini", "Macro", "Prime SUV" 
    int mileage[] = { 35, 18, 14, 10 };
    int fuelPrice = 107;
    double reqFuel = tripDistance / mileage[choice];
    double fuelCost = fuelPrice * reqFuel;
    double finalFare = fuelCost * 100 / 30;
    return finalFare;
  }
}