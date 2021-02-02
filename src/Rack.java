import java.util.ArrayList;

public class Rack {
    private ArrayList<Node> nodes = new ArrayList<Node>();
    private int maxNodes;

    /* CONSTRUCTOR */
    public Rack(int maxNodes) {
        this.maxNodes = maxNodes;
    }

    /* Adds a node to the rack */
    public void addNode(Node node) {
        if(getSize() < maxNodes) {
            nodes.add(node);
        }
    }

    /* Return sum of all processors in rack */
    public int getProcessorCount() {
        int sum = 0;
        for(Node node : nodes) {
            sum += node.getProcessorCount();
        }
        return sum;
    }

    /* GET METHODS */
    /* Returns how many nodes there are in the rack */
    public int getSize() {return nodes.size();}

    /* Technically not part of the assignment */
    /* Get a specific node */
    public Node getNode(int i) {return nodes.get(i);}

    /* Get the entire ArrayList of nodes */
    public ArrayList<Node> getNodes() {return nodes;}
}