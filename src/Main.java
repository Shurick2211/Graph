public class Main {
  public static void main(String [] args){
    Graph graph = new Graph();
    graph.addVertex("gdansk");
    graph.addVertex("bydgoszcz");
    graph.addVertex("torun");
    graph.addVertex("warszawa");

    graph.addEdge(1, 2, 1);
    graph.addEdge(1, 3, 3);
    graph.addEdge(2, 1, 1);
    graph.addEdge(2, 3, 1);
    graph.addEdge(2, 4, 4);
    graph.addEdge(3, 1, 3);
    graph.addEdge(3, 2, 4);
    graph.addEdge(3, 4, 1);
    graph.addEdge(4, 2, 4);
    graph.addEdge(4, 3, 1);

    System.out.println("Элементы имеют кратчайшие пути из точки A: ");
    graph.path(0);
    graph.clean();
    System.out.println("_________________");
    graph.path(1);

  }
}
