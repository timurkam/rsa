/**
 * Created by Тимур on 24.09.2017.
 */
public class GCD {
    public static int gcd(int a,int b) {
        while (b !=0) {
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
}