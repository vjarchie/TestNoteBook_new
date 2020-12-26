package EoPI.PrimitiveTypes;

/**
 * parity = 1 if number of set bits is odd.
 * parity = 0 if number of set bits is even.
 */
public class NumberParity51 {
    public static void main(String args[]){
       // O(n)
        Long currTime = System.nanoTime();
        Integer sample  = 65536;
        Integer test1 = sample;
        short result = 0;
        while(test1!=0){
            result ^= (test1 & 1);
            test1 >>>=1;
        }
        System.out.println("Parity = " + result);
        Long totalTime = System.nanoTime() - currTime;
        System.out.println("Total processing time = "+totalTime);
        //O(k) : k= total set bit
        currTime = System.nanoTime();
        Integer test2  = sample;
        result = 0;
        while(test2!=0){
            result ^= 1;
            test2 &= (test2-1);
        }
        System.out.println("Parity = " + result);
        totalTime = System.nanoTime() - currTime;
        System.out.println("Total processing time = "+totalTime);
    }

}
