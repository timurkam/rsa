import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Тимур on 24.09.2017.
 */
public class decrypt {
    public static String s="190036018274508216586696675158436572823536393575281146244016687382409175715829258295815447406195299817455974397703288803952414902363922551";
    public static BigInteger N= new BigInteger(s);
    public static BigInteger d;
    //static BigInteger a=n.gcd()
    public static boolean flag=false;
    public static Thread theThreads[];
    public static int count=20;


    public static void main(String[] args) {
        pol[] metod=new pol[count];
        BigInteger rew;
        ArrayList<Boolean> massiv=new ArrayList<Boolean>();
        theThreads=new Thread[count];
        while(!N.equals(BigInteger.ONE)) {
            for (int i = 0; i < count; i++) {
                metod[i] = new pol(N, "" + i);
                theThreads[i] = new Thread(metod[i]);
                theThreads[i].start();
            }
            try {
                for (int i = 0; i < count; i++) {
                    theThreads[i].join();
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ArrayList<BigInteger> D = metod[0].getD();
            while(massiv.size()<D.size())massiv.add(massiv.size(),false);
            System.out.println("D=" + D);
            for (int i = 0; i < D.size(); i++) {
                //BigInteger[] r=N.divideAndRemainder(D.get(i));

                if(!massiv.get(i))
                {
                    rew=N.gcd(D.get(i));
                    D.remove(i);
                    ///if(rew!=BigInteger.ONE)
                    D.add(i,rew);
                    //if(rew!=N)
                    N = N.divide(D.get(i));
                    massiv.add(i,true);
                    System.out.println("N=" + N+" D "+D.get(i));
                }
            }
            System.out.println("D=" + D);
            System.out.println("N=" + N);
        }
    }


}

