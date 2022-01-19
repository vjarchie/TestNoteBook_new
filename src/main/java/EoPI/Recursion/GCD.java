package EoPI.Recursion;

public class GCD {

    public static void main(String[] args){
        System.out.println("gcd ="+ gcd(12,4));
        System.out.println("gcd ="+gcd(14,8));

    }

    private static Integer gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y) ;
    }
}
