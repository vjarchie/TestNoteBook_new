package problems;

public class GreyCodeGenerator {

    /**
     * Approaches :
     * 1. i_next = i ^ (i>>1)
     * 2. using n bit grey code to generate n+1 bit grey  code :
     *  a. mark n bit grey code as L1
     *  b. copy and reverse L1 to get L2
     *  c. prefix L1 with 0 and L2 with 1 and concatenate both to get final n+1 bit grey code
     *
     * @param x
     * @param n
     */
    static void decimalToBinaryNumber(int x,
                                      int n)
    {
        int[] binaryNumber = new int[x];
        int i = 0;
        while (x > 0) {
            binaryNumber[i] = x % 2;
            x = x / 2;
            i++;
        }

        // leftmost digits are
        // filled with 0
        for (int j = 0; j < n - i; j++)
            System.out.print('0');

        for (int j = i - 1;
             j >= 0; j--)
            System.out.print(binaryNumber[j]);
    }

    // Function to generate
    // gray code
    static void generateGrayarr(int n)
    {
        // N = least largest number requiring bits more than n
        int N = 1 << n;
        for (int i = 0; i < N; i++) {

            // generate gray code of
            // corresponding binary
            // number of integer i.
            int x = i ^ (i >> 1);
            System.out.println("i = "+i+" x="+x);
            // printing gray code
            decimalToBinaryNumber(x, n);

            System.out.println();
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        int n = 3;
        generateGrayarr(n);
    }

}
