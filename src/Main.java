import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        /* Actual turn-in answer */
        DataCluster cum = new DataCluster("dataklynge.txt");

        /* Display shit */
        System.out.println("Nodes with atleast 32 GB: " + cum.nodesWithEnoughMemory(32)); // EXPECTED 666
        System.out.println("Nodes with atleast 64 GB: " + cum.nodesWithEnoughMemory(64)); // EXPECTED 666
        System.out.println("Nodes with atleast 128 GB: " + cum.nodesWithEnoughMemory(128) + '\n'); // EXPECTED 16
        System.out.println("Number of processors: " + cum.getProcessorCount()); // EXPECTED 682
        System.out.println("Number of Racks: " + cum.getNumberOfRacks()); // EXPECTED 56
        System.out.println("\n-----------------------------"); // Important!

        /* Structural visualization */
        cum.visualizeCluster();
    }
}