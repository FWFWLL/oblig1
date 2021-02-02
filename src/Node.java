public class Node {
    private int memorySize;
    private int processorCount;

    /* CONSTRUCTOR */
    public Node(int memorySize, int processorCount) {
        this.memorySize = memorySize;
        this.processorCount = processorCount;
    }

    /* GET METHODS */
    public int getMemorySize() {return memorySize;}

    public int getProcessorCount() {return processorCount;}
}