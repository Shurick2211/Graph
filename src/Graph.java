import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
  private final int INFINITY = 200000; // it is infinity
  private Vertex vertexList[]; // list of vertex
  private int relationMatrix[][]; // matrix relation vertex
  private int countOfVertices; // current number of vertexes
  private int countOfVertexInTree; //  number used vertexes on the tree
  private List<Path> shortestPaths; // list the shortest path
  private int currentVertex; // current vertex
  private int startToCurrent; //cost currentVertex

  public Graph(int sizeVetex) {
    vertexList = new Vertex[sizeVetex];
    relationMatrix = new int[sizeVetex][sizeVetex];
    countOfVertices = 0;
    countOfVertexInTree = 0;
    for (int i = 0; i < sizeVetex; i++) {
      for (int k = 0; k < sizeVetex; k++) {
        relationMatrix[i][k] = INFINITY;
        shortestPaths = new ArrayList<>();
      }
    }
  }

  public void addVertex(String lab) {// задание новых вершин
    vertexList[countOfVertices++] = new Vertex(lab);
  }

  public int getVertexIndex(String lab) {
    for (int i = 0; i < vertexList.length; i++){
      if(vertexList[i].getLabel().equals(lab)) return i+1;
    }
    return -1;
  }

  public void addEdge(int start, int end, int weight) {
    relationMatrix[start-1][end-1] = weight; // create Matrix (enter values)
  }

  public void path(int start) { // check of the shortest path
    //  start vertex data
    int startTree = start-1;
    vertexList[startTree].setInTree(true); //add first element on the tree
    countOfVertexInTree = 1;

    // create short paths neighbors cities
    for (int i = 0; i < countOfVertices; i++) {
      int tempDist = relationMatrix[startTree][i];
      Path path = new Path(tempDist);
      path.getParentVertices().add(start-1);// first parent element the starts vertex
      shortestPaths.add(path);
    }

    // while all vertexes will add to the tree
    while (countOfVertexInTree < countOfVertices) {
      int indexMin = getMin();//get low cost index vertex, that does not add to the tree
      int minCost = shortestPaths.get(indexMin).getCost();// minimal cost for it

      if (minCost == INFINITY) {
        break;// if we have not available vertex
      } else {
        currentVertex = indexMin; // change currentVert
        startToCurrent = shortestPaths.get(indexMin).getCost();// add cost the currentVert
      }
      vertexList[currentVertex].setInTree(true);  // add vertex to the tree
      countOfVertexInTree++;
      updateShortestPaths(); // update list the shortest path
    }

  }

  public void clean() { // clean tree
    countOfVertexInTree = 0;
    for (int i = 0; i < countOfVertices; i++) {
      vertexList[i].setInTree(false);
    }
    shortestPaths.clear();
  }

  private int getMin() {
    int minDist = INFINITY; // start with infinity
    int indexMin = 0;
    for (int i = 0; i < countOfVertices; i++) {// for everyone vertex
      if (!vertexList[i].isInTree() && shortestPaths.get(i).getCost() < minDist) { // if vertex is not the tree yet, and it cost smaller than old minimum
        minDist = shortestPaths.get(i).getCost(); // new minimum
        indexMin = i; // update minimum index
      }
    }
    return indexMin; //and return it
  }

  private void updateShortestPaths() {
    int vertexIndex = 0;
    while (vertexIndex < countOfVertices) { // iterate over columns
      if (vertexList[vertexIndex].isInTree()) { // if vertex column add yet, it skip
        vertexIndex++;
        continue;
      }
      // calculate cost for a element sPath
      // get cost currentVert in a column
      int currentToFringe = relationMatrix[currentVertex][vertexIndex];
      // sum costs
      int startToFringe = startToCurrent + currentToFringe;
      // calculate cost current element vertexIndex
      int shortPathDistance = shortestPaths.get(vertexIndex).getCost();

      // check cost currentVertex with current cost in the vertex with index vertexIndex
      if (startToFringe < shortPathDistance) {// if smaller => new path
        List<Integer> newParents = new ArrayList<>(shortestPaths.get(currentVertex).getParentVertices());
        newParents.add(currentVertex);
        shortestPaths.get(vertexIndex).setParentVertices(newParents); // save new paths
        shortestPaths.get(vertexIndex).setCost(startToFringe); // set new cost
      }
      vertexIndex++;
    }
  }

  public void displayCost(int start, int end) { // output
    path(start);
    System.out.println(shortestPaths.get(end-1).getCost());

  }

}
