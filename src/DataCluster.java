import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class DataCluster {
    private ArrayList<Rack> racks = new ArrayList<Rack>();
    private int nodesPerRack;
    private int indexOfEmptyRack = 0;

    /* CONSTRUCTOR */
    public DataCluster(int nodesPerRack) {
        this.nodesPerRack = nodesPerRack;
        racks.add(new Rack(nodesPerRack));
    }

    /* CONSTRUCTOR FROM FILE */
    /* This is a ravenous hellbeast I regret bringing before our eyes -FFL */
    /* Assuming the file will always be formatted the same way */
    public DataCluster(String fileName) throws IOException {
        /* Idk I just copied from a youtube video lmao -FFL */
        Scanner scanner = new Scanner(new File(fileName));
        /* Assign nodesPerRack value and initialize starting rack-list */
        nodesPerRack = scanner.nextInt();
        racks.add(new Rack(nodesPerRack));
        /* I started crying at this point -FFL */
        while(scanner.hasNextLine()) {
            int nodeCount = scanner.nextInt();
            int memoryPerNode = scanner.nextInt();
            int processorsPerNode = scanner.nextInt();
            for(int i = 0; i < nodeCount; i++) {this.addNode(new Node(memoryPerNode, processorsPerNode));}
        }
        scanner.close();
    }

    /* This is the ugliest thing I have ever written */
    /* I refuse to work on this any further -FFL */
    public void addNode(Node node) {
        int i = indexOfEmptyRack;
        while(true) {
            if(racks.get(i).getSize() >= nodesPerRack) {
                racks.add(new Rack(nodesPerRack));
                racks.get(i).addNode(node);
            } else {
                racks.get(i).addNode(node);
                break; // I don't like this.
            }
            i++;
        }
        indexOfEmptyRack = i;
    }

    /* Return sum of all processors in the data-cluster */
    public int getProcessorCount() {
        int sum = 0;
        for(Rack rack : racks) {
            sum += rack.getProcessorCount();
        }
        return sum;
    }

    /* Return number of nodes that reach the memory requirement */
    public int nodesWithEnoughMemory(int memoryRequirement) {
        int numberOfNodes = 0;
        for(Rack rack : racks) {
            for(Node node : rack.getNodes()) {
                if(node.getMemorySize() >= memoryRequirement) {
                    numberOfNodes++;
                }
            }     
        }
        return numberOfNodes;
    }

    public int getNumberOfRacks() {return racks.size();}

    /* EXPERIMENTAL/OPTIONAL */
    /* These aren't part of the assignment, but i thought they were neat :3 -FFL */
    /* Will display the chosen rack neatly */
    /* Uses messier architecture but it gets the job done */
    public void displayRack(int i) {
        System.out.println("Rack " + (i + 1) + ':');
        for(int j = 0; j < racks.get(i).getSize(); j++) {
            System.out.println("\t" + "Node " + (j + 1) + ':');
            System.out.println("\t\t" + "Memory: " + racks.get(i).getNode(j).getMemorySize());
            System.out.println("\t\t" + "Processors: " + racks.get(i).getNode(j).getProcessorCount());
        }
    }

    /* Personal amusement */
    /* Will display the entire Datacluster */
    public void visualizeCluster() {
        for(int i = 0; i < racks.size(); i++) {
            displayRack(i);
        }
    }
}