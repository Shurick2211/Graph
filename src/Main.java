import java.io.*;

public class Main {

  public static void main(String [] args) throws IOException {
    // I did the Input in .txt file
    final BufferedReader fileReader =new BufferedReader(new FileReader("input.txt"));
    String str;
    String [] line;
    final String SPLIT = " ";
    int index = 0;
    Graph graph = null;
    int countCity = 0;
    // Reading file.
    while((str=fileReader.readLine())!=null){
      line=str.split(SPLIT);
      // Create graph
      if (index == 1) {
        graph = new Graph(Integer.parseInt(line[0]));
        System.out.println("Output:");
      }
      if (index > 1) {
        // Add city in the graph
        if (line.length == 1 && Character.isLetter(line[0].toCharArray()[0])) {
          graph.addVertex(line[0]);
          countCity++;
        }
        // Add the transportation cost
        if (line.length == 2 && Character.isDigit(line[0].toCharArray()[0])) {
          graph.addEdge(countCity, Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }
        // Output result
        if (line.length == 2 && Character.isLetter(line[0].toCharArray()[0])) {
          graph.displayCost(graph.getVertexIndex(line[0]), graph.getVertexIndex(line[1]));
          graph.clean();
        }

      }
      index++;
    }

  }



}
