package DS;

public class BitwiseTricks {

    public static void main(String args[]){
        Integer input = 15;
        printDecimalToBinary(input);
        isEven(input);
    }

    static void printDecimalToBinary(Integer number){
        for(int i=7;i>=0;i--){
            int k = number >>i;
            if((k&1)>0){
                System.out.print(1);
            }else{
                System.out.print(0);
            }
        }
        System.out.println("");
    }

    static void isEven(Integer number){
        if((number & 1) == 0){
            System.out.println(number +" is even");
        }else{
            System.out.println(number +" is odd");
        }
    }

//    static void isNthBitSet(Integer number,Integer n){
//        if(number)
//    }
}
