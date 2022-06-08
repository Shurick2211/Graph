import java.util.ArrayList;
import java.util.List;

public class Path {
  private int cost;
  private List<Integer> parentVertices;

  public Path(int cost) {
    this.cost = cost;
    this.parentVertices = new ArrayList<>();
  }


  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  public List<Integer> getParentVertices() {
    return parentVertices;
  }

  public void setParentVertices(List<Integer> parentVertices) {
    this.parentVertices = parentVertices;
  }

}
