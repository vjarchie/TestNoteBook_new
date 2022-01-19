package Notes.FB_Prep.testBox;

import java.util.*;
// Add any extra import statements you may need here


class Main {

    // Add any helper functions you may need here


    String rotationalCipher(String input, int rotationFactor) {
        StringBuilder result = new StringBuilder();
        if(input != null && input.length()>0){
            for(int i=0;i<input.length();i++){
                if(Character.isDigit(input.charAt(i))) {
                    int t= rotateNumber(input.charAt(i), rotationFactor);
                    result.append(t);
                }
                else if (Character.isUpperCase(input.charAt(i))) {
                    result.append(rotateUpperChar(input.charAt(i), rotationFactor));
                }
                else if(Character.isLowerCase(input.charAt(i))) {
                    result.append(rotateLowerChar(input.charAt(i), rotationFactor));
                }
                else {
                    result.append(input.charAt(i));
                }
            }

        }

        return result.toString();
    }


    private char rotateUpperChar(char c,int s){
        return (char)(((int)c+s-65)%26+65);
    }

    private char rotateLowerChar(char c,int s){
        return (char)(((int)c+s-97)%26+97);
    }
    private int rotateNumber(char i,int s){
        return (Integer.parseInt(String.valueOf(i))+s)%10;
    }










    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new Main().run();
    }
}
