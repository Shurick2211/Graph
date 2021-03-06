public class Vertex {
  private String label;
  private boolean isInTree;

  public Vertex(String label) {
    this.label = label;
    this.isInTree = false;
  }

  public Vertex(String label, boolean isInTree) {
    this.label = label;
    this.isInTree = isInTree;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public boolean isInTree() {
    return isInTree;
  }

  public void setInTree(boolean inTree) {
    isInTree = inTree;
  }
}
