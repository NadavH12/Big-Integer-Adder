import java.util.Scanner;
/*

Nadav Horowitz CS211 6/4/2022

This program takes user input of 2 very large numbers, then calculates and prints their sum.

*/
public class BigIntegerAdder {

    public static void main(String[] args) {
         LinkedStack s1 = new LinkedStack();
         LinkedStack s2 = new LinkedStack();
        
         readNumber(s1);
         readNumber(s2);
         
         String result = add(s1, s2);
 
         System.out.println("Sum=" + result);
    }

    private static void readNumber(LinkedStack s) {
        System.out.println("Enter a very large number:");
        Scanner console = new Scanner(System.in);
        String addend = console.next();

        for(int i = 0; i < addend.length(); i++) {
            String digitString = addend.substring(i, i+1);
            int digitInt = Integer.parseInt(digitString);

            s.push(digitInt);
        }
    }

    public static String add(LinkedStack s1, LinkedStack s2) {
        String result = "";
        int sum = 0;
        int carry = 0;

        while(!s1.isEmpty() && !s2.isEmpty()) {
            int s1TopDigit = s1.pop();
            int s2TopDigit = s2.pop();

            sum = s1TopDigit + s2TopDigit + carry;
            int addedDigit = sum % 10;
            carry = sum / 10;
            result = addedDigit + result;
        }

        //Special case for adding integers with different number of digits        
        if (s1.isEmpty()) {
            s1 = s2;
        }

        while(!s1.isEmpty()) {
            int s1TopDigit = s1.pop();

            sum = s1TopDigit + carry;
            int addedDigit = sum % 10;
            carry = sum / 10;
            result = addedDigit + result;
        }

        if (carry > 0) {
            result = carry + result;
        }

        return result;
    }
}