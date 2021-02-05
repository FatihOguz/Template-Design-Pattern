import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * this class abstract class
 * and encapsulates algorithm
 *
 */
public abstract class DiscreteTransform1D {

    /**
     * calculate dft or dct and write outputs.txt
     * performs the calculation process by performing the operation sin cos and step methods respectively.
     * this order should be the same for dft and dct
     * Therefore, this algorithm is protected with the final keyword.
     * If the programmer wants to add to the algorithm in the future, programmer can add by filling the hook method.
     * The algorithm can gain the right to display numbers in the terminal according to the dft status with the userWants Printing Terminal method.
     * this situation is turned off for dct.
     * default false for userWantsPrintingTerminal method
     * @param Xn double array for Xk k(0,1,2,....,N-1)
     * @param N is size of Xn
     * @throws IOException if outputs.txt do not exist ,create new file
     */
    final void finiteSum(double[] Xn,int N) throws IOException {

        File file = new File("outputs.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
            double sumReal=0.0;
            double sumImagine=0.0;

               if(userWantsPrintingTerminal()){

                   for(int k=0;k<N;k++){
                       sumReal=0.0;
                       sumImagine=0.0;
                       for(int i=0;i<N;i++){
                           sumReal = sumReal +step(Xn[i], Math.cos( Operation(i,k,N) ));
                           sumImagine = sumImagine +step(Xn[i], sin( Operation(i,k,N) ));
                       }

                       System.out.println("--> " + sumReal + " - i " + sumImagine);
                       bWriter.write("--> " + sumReal + " - i " + sumImagine + " \n");
                   }
               }
               else{

                   for(int k=0;k<N;k++){
                       sumReal=0.0;
                       sumImagine=0.0;
                       for(int i=0;i<N;i++){
                           sumReal = sumReal +step(Xn[i], Math.cos( Operation(i,k,N) ));
                           sumImagine = sumImagine +step(Xn[i], sin( Operation(i,k,N) ));

                   }
                       bWriter.write("--> " + sumReal + " - i " + sumImagine + " \n");
               }


            }

            bWriter.close();

            hook();

    }

    /**
     * this ask to user that want to print numbers on terminal for dft
     * @return default return false   /  if user y return false,user say n return false
     */
    boolean userWantsPrintingTerminal(){
        return false;
    }


    /**
     * calculate other equation(inner trigonometric equation)
     * @param k Xk(0,1,2,....,N-1)
     * @param n n(0,1,2,....,N-1) for Xk
     * @param N size of number of series
     * @return double number(calculated equation)
     */
    public abstract double Operation(double k,int n,int N);


    /**
     * if you want to add algorithm,implement this method
     */
    public void hook(){}


    /**
     * calucalte Xn multiple other equation for discrete transforms
     * @param Xn number of series
     * @param operation other equation for discrete transforms
     * @return multiplication Xn and operation
     */
    public double step(double  Xn,double operation){
        return (Xn * operation);
    }


    /**
     * calculate sinus function for dft
     * but return 0 for dct
     * @param number sinus number
     * @return Math.sin(number)
     */
    public abstract double sin(double number);


    /**
     *  read file and create Xn array and call finiteSum method
     * @param fileName name of file
     * @throws IOException if file do not exist throw exception
     */
   final  public void readFileAndCallFiniteSum(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner scanner;
        ArrayList arrayList = new ArrayList();

        try {
            scanner = new Scanner(file);
            int i=0;
            while(scanner.hasNextInt())
            {

                arrayList.add(i,scanner.nextDouble());
                i++;
            }

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }



        double[] Xn = new double[arrayList.size()];

        for(int i=0;i<arrayList.size();i++){
            Xn[i]= (double) arrayList.get(i);

        }

        finiteSum(Xn, Xn.length);



    }
}
