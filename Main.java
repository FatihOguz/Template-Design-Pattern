import java.io.*;

/**
 * this class example for DFT and DCT
 * take command argument line and give readCommandArgumentAndCallFiniteSum method
 */
public class Main {
    /**
     * take command argument line and give readCommandArgumentAndCallFiniteSum method
     * @param args user write a txt file
     * @throws IOException for there are not file
     */
    public static void main(String[] args) throws IOException {
        DiscreteTransform1D discreteTransform1DCT = new DCT();
        DiscreteTransform1D discreteTransform1DFT = new DFT();
      discreteTransform1DCT.readFileAndCallFiniteSum(args[0]);
      discreteTransform1DFT.readFileAndCallFiniteSum(args[0]);


    }
}
