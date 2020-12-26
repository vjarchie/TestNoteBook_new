package EoPI.PrimitiveTypes;

public class CountBits {

    public static void main(String args[]){
        Integer sample = 1667;
        short numBits = 0;
        while(sample!=0){
            numBits += (sample & 1);
            sample >>>=1;
        }
        System.out.println("total set bits = "+numBits);
    }
}
