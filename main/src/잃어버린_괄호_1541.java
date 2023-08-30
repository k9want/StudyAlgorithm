import java.io.*;
import java.util.*;

public class 잃어버린_괄호_1541 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int result = 0;
        int sum = 0;
        String[] strA = str.split("-"); //10 20+30
        for (int i = 0; i < strA.length; i++) {
            sum = mySum(strA[i]);
            if (i == 0) {
                result += sum;
            } else {
                result -= sum;
            }
        }
        System.out.println(result);

    }

    public static int mySum(String a) {
        int returnV = 0;
        String[] str = a.split("[+]"); //20 30
        for (int i = 0; i < str.length; i++) {
            returnV += Integer.parseInt(str[i]);
        }
        return returnV;
    }
}
