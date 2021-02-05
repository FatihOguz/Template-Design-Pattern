/**
 * this class extends DiscreteTransform1D
 * and override Operation method
 * this method apply formula
 */
public class DCT extends DiscreteTransform1D {


    /**
     * applies the formula in the sum symbol
     * @param k index of Xk
     * @param n index of summation symbol  from n = 0 to  N
     * @param N size of series
     * @return ((2*Math.PI*n*k) / N) this number is double
     */
    @Override
    public double Operation(double n, int k, int N) {
        return((2*Math.PI*n*k) / N);
    }

    /**
     * default false
     * @return  default false
     */
    @Override
    boolean userWantsPrintingTerminal() {
        return super.userWantsPrintingTerminal();
    }
    /**
     * sin fonksiyonu
     * @param number is sinus number
     * @return Math.sin(number)
     */
    @Override
    public double sin(double number) {
        return 0;
    }
}
