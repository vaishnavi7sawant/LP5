import java.rmi.*;
import java.rmi.server.*;

public class ServerImpl extends UnicastRemoteObject implements ServerIntf {

    public ServerImpl() throws RemoteException {
    }

    public int addition(int a, int b) throws RemoteException {
        return a + b;
    }

    public int substraction(int a, int b) throws RemoteException {
        return a - b;
    }

    public int division(int a, int b) throws RemoteException {
        return a / b;
    }

    public int multiplication(int a, int b) throws RemoteException {
        return a * b;
    }

    public int square(int a) throws RemoteException {
        return a * a;
    }

    public int squareroot(int a) throws RemoteException {
        return (int) (Math.sqrt(a));
    }

    public double convertToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    // Logic: 1 mile = 1.60934 kilometers
    public double convertToKilometers(double miles) {
        return miles * 1.60934;
    }

    // Logic: "Hello " + name
    public String echoHello(String name) {
        return "Hello " + name;
    }

    //compare strings
    public String compareStrings(String str1, String str2) {
        return (str1.compareTo(str2) > 0) ? str1 : str2;
    }

    //count vowels
    public int countVowels(String word) {
        int count = 0;
        word = word.toLowerCase();
        for (char c : word.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    //factorial
    public long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public void palindrome(String str) throws RemoteException {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();

        if (str.equals(sb.toString()))
            System.out.println("String is Palindrome!");
        else
            System.out.println("String is Not Palindrome!");

    }

    public void isequalstring(String str1, String str2) throws RemoteException {
        if (str1.equals(str2))
            System.out.println("String is equal!");
        else
            System.out.println("String is not equal!");
    }

}
