import java.util.*;

public class Map {

    public static int V = 29;
    public static Graph graph = new Graph(V);
    public static String[] vertices = {"Cafe Coffee Day",
                                "Club D",
                                "Club C",
                                "Club E",
                                "Club B",
                                "Club F",
                                "Club A",
                                "Club G",
                                "Club Corner",
                                "ShopGood Mall",
                                "Memorial Circle",
                                "StarWest Colony",
                                "Cricket Stadium",
                                "PVR Drive-in Cinema",
                                "Central Library",
                                "",
                                "Fun&Food",
                                "Exhibition Hall",
                                "Genius Secondary School",
                                "Jay Primary Education",
                                "",
                                "",
                                "Townhall Circle",
                                "Education Hub Circle",
                                "IIITV-ICD",
                                "AIIMS",
                                "Watson Museum",
                                "",
                                "McDonalds"};

    static class Edge {
        int source;
        int destination;
        double[] weight;

        public Edge(int source, int destination, double[] weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int V;
        LinkedList<Edge>[] adjacencylist;

        Graph(int V) {
            this.V = V;
            adjacencylist = new LinkedList[V];
            // initialize adjacency lists for all the V
            for (int i = 0; i < V; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addEgde(int source, int destination, double[] weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge);
        }

        public void AssignGraph(){

            graph.addEgde(0, 1, new double[]{getDistance(5, 2, 2, 5),10});
            graph.addEgde(1,0, new double[]{getDistance(5, 2, 2, 5),10});
    
            graph.addEgde(1, 2, new double[]{getDistance(2,5,4,7),10});
            graph.addEgde(2,1, new double[]{getDistance(2,5,4,7),10});
    
            graph.addEgde(2, 3, new double[]{getDistance(4,7,2,8),15});
            graph.addEgde(3,2, new double[]{getDistance(4,7,2,8),15});
    
            graph.addEgde(2, 4, new double[]{getDistance(4,7,5,8),25});
            graph.addEgde(4,2, new double[]{getDistance(4,7,5,8),25});
    
            graph.addEgde(4,5, new double[]{getDistance(5,8,3,9),5});
            graph.addEgde(5,4, new double[]{getDistance(5,8,3,9),5});
    
            graph.addEgde(4,6,new double[]{getDistance(5,8,6,9),15});
            graph.addEgde(6,4,new double[]{getDistance(5,8,6,9),15});
    
            graph.addEgde(6,7, new double[]{getDistance(6,9,4,10),10});
            graph.addEgde(7,6, new double[]{getDistance(6,9,4,10),10});
    
            graph.addEgde(6,8,new double[]{getDistance(6,9,7,10),25});
            graph.addEgde(8,6,new double[]{getDistance(6,9,7,10),25});
    
            graph.addEgde(8,9,new double[]{getDistance(7,10,7,12),20});
            graph.addEgde(9,8,new double[]{getDistance(7,10,7,12),20});
    
            graph.addEgde(9,10,new double[]{getDistance(7,12,7,13),10});
            graph.addEgde(10,9,new double[]{getDistance(7,12,7,13),10});
    
            graph.addEgde(10,11,new double[]{getDistance(7,13,4,15),10});
            graph.addEgde(11,10,new double[]{getDistance(7,13,4,15),10});
    
            graph.addEgde(11,12,new double[]{getDistance(4,15,4,18),35});
            graph.addEgde(12,11,new double[]{getDistance(4,15,4,18),35});
    
            graph.addEgde(10,14,new double[]{getDistance(7,13,11,14),40});
            graph.addEgde(14,10,new double[]{getDistance(7,13,11,14),40});
    
            graph.addEgde(14,13,new double[]{getDistance(11,14,10,19),5});
            graph.addEgde(13,14,new double[]{getDistance(11,14,10,19),5});
    
            graph.addEgde(14,15,new double[]{getDistance(11,14,15.38,15),10});
            graph.addEgde(15,14,new double[]{getDistance(11,14,15.38,15),10});
    
            graph.addEgde(15,16,new double[]{getDistance(15.38,15,16,17),10});
            graph.addEgde(16,15,new double[]{getDistance(15.38,15,16,17),10});
    
            graph.addEgde(15,17,new double[]{getDistance(15.38,15,19,16),20});
            graph.addEgde(17,15,new double[]{getDistance(15.38,15,19,16),20});
    
            graph.addEgde(9,21,new double[]{getDistance(7,12,14.56,12),90});
            graph.addEgde(21,9,new double[]{getDistance(7,12,14.56,12),90});
    
            graph.addEgde(21,15,new double[]{getDistance(14.56,12,15.38,15),70});
            graph.addEgde(15,21,new double[]{getDistance(14.56,12,15.38,15),70});
    
            graph.addEgde(21,20,new double[]{getDistance(14.56,12,16,12),10});
            graph.addEgde(20,21,new double[]{getDistance(14.56,12,16,12),10});
    
            graph.addEgde(20,18,new double[]{getDistance(16,12,16,14),70});
            graph.addEgde(18,20,new double[]{getDistance(16,12,16,14),70});
    
            graph.addEgde(20,19,new double[]{getDistance(16,12,18,12),10});
            graph.addEgde(19,20,new double[]{getDistance(16,12,18,12),10});
    
            graph.addEgde(8,22,new double[]{getDistance(7,10,10,10),150});
            graph.addEgde(22,8,new double[]{getDistance(7,10,10,10),150});
    
            graph.addEgde(22,27,new double[]{getDistance(10,10,10.42,6),135});
            graph.addEgde(27,22,new double[]{getDistance(10,10,10.42,6),135});
    
            graph.addEgde(27,28,new double[]{getDistance(10.42,6,5,6),5});
            graph.addEgde(28,27,new double[]{getDistance(10.42,6,5,6),5});
    
            graph.addEgde(27,26,new double[]{getDistance(10.42,6,11,2),10});
            graph.addEgde(26,27,new double[]{getDistance(10.42,6,11,2),10});
    
            graph.addEgde(27,23,new double[]{getDistance(10.42,6,13,6),80});
            graph.addEgde(23,27,new double[]{getDistance(10.42,6,13,6),80});
    
            graph.addEgde(23,21,new double[]{getDistance(13,6,14.56,12),30});
            graph.addEgde(21,23,new double[]{getDistance(13,6,14.56,12),30});
    
            graph.addEgde(23,24,new double[]{getDistance(13,6,14,3),5});
            graph.addEgde(24,23,new double[]{getDistance(13,6,14,3),5});
    
            graph.addEgde(24,25,new double[]{getDistance(14,3,16,3),10});
            graph.addEgde(25,24,new double[]{getDistance(14,3,16,3),10});
        }
        
    }

    public static double getDistance(double x1,double y1, double x2, double y2){
        return Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
    }
}