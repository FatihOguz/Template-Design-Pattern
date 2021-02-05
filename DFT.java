import javax.lang.model.util.ElementScanner6;
import java.util.Scanner;

/**
 * this class extends DiscreteTransform1D
 *  discrete Fourier transform
 */
public class DFT extends DiscreteTransform1D {

    /**
     * this method ask to user that do you want to print numbers terminal
     * if user say y , do it ; otherwise do not
     * @return boolean if user say y return true
     *                          say n return false
     *                          otherwise ask again
     */
    @Override
    boolean userWantsPrintingTerminal() {
        System.out.println("do you want to print numbers terminal. y/n");
        Scanner scanner = new Scanner(System.in);

        while(1==1){
            String command = scanner.next();
            if(command.equals("y")){
                return true;
            }
            else if(command.equals("n")){
                return false;
            }
            else{
                System.out.println("please write y or n");
            }
        }


    }

    /**
     * sin fonksiyonu
     * @param number is sinus number
     * @return Math.sin(number)
     */
    @Override
    public double sin(double number) {
        return Math.sin(number);
    }

    /**
     * applies the formula in the sum symbol
     * @param k index of Xk
     * @param n index of summation symbol from n = 0 to  N
     * @param N size of series
     * @return ((2*Math.PI*n*k) / N) this number is double
     */
    @Override
    public double Operation(double n, int k, int N) {
        return ((((2*Math.PI*n*k) / N)    + (Math.PI * k / N))  / 2  );
    }
}
