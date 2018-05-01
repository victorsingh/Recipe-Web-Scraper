package filecreator;

public interface FileInterface {
  public void addchild(String Parent, String Child);
  /**
   * a "toy" is an object that contains a primative data type (String) and not a child object.
   * In the case of our 
   */
  public void removeToy(String Parent, String Child, String Toy);
}
