import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Тимур on 24.09.2017.
 */
public class pol implements Runnable {
    public BigInteger N;
    BigInteger Dlich=BigInteger.ONE;
    public static ArrayList<BigInteger> D= new ArrayList<BigInteger>();
    String name;
    int i=0;
    public static boolean flag=false;

    public void poll (BigInteger n)
    {
        //int x = random(1, N-2);
        Random rnd = new Random();
        int a=n.bitLength();
        //System.out.println("length "+a);
        int length=rnd.nextInt(a/2)+2;
        BigInteger x= new BigInteger(length, 7, rnd);
        //BigInteger x = BigInteger.valueOf(13);
        BigInteger y = BigInteger.ONE; BigInteger i = BigInteger.ZERO; BigInteger stage = BigInteger.valueOf(2);
        BigInteger ry= n.gcd((x.add(y.negate())).abs());
        //System.out.println("x "+x+" name "+name);
        //System.out.println(ry);
        //Dlich=BigInteger.ONE;
        while (ry.equals(BigInteger.ONE) &&(!flag))
        {
            //System.out.println(ry);
            /*if(flag) {
                break;
            }*/
            if (i.equals( stage)){
                y = x;
                stage = stage.multiply(stage);
            }
            BigInteger[] r = (((x.multiply(x)).add(BigInteger.ONE.negate())).divideAndRemainder(n));
            x = r[1];
            BigInteger abc=(x.add(y.negate())).abs();
            //System.out.println(abc);
            ry=n.gcd(abc);
            i = i.add(BigInteger.ONE);
        }
        //System.out.println("!!!!!"+ry);
        //if(n.equals(N))
        Dlich=N.gcd(x.add(y.negate()));
        //System.out.println(Dlich+" "+name);
        /*if(Dlich!=null)
        D.add(Dlich);*/
    }
    public pol(BigInteger N,String name)
    {
        this.N=N;
        this.name=name;
        flag=false;


    }
    public ArrayList<BigInteger> getD(){
        return D;
    }

    @Override
    public void run() {

        //System.out.println(""+name);
        //System.out.println(flag+" " +name);
        poll(N);
        //D.add(poll(N));
        //System.out.println("del"+D.get(D.size()));
        if(!Dlich.equals(BigInteger.ONE)) {
            //N.divide(D.get(D.size()));
            flag = true;
            D.add(Dlich);
            //System.out.println("Dlich "+Dlich+" name "+name);
            //N.divide(Dlich);
        }
        //System.out.println("D"+D);
        //System.out.println("vse"+name);
    }
   /* @Override
    public void run() {
        //System.out.println("!!!!!!!!!!!!!"+currentThread().getName());
        d= poll(n);
        if (!d.equals(BigInteger.ONE))
        {
            //System.out.println(currentThread().getName());
            System.out.println(d+" "+currentThread().getName());
            flag=true;
        }

        if(flag&&!isInterrupted())
            for(int i=0; i<count; i++) {
                System.out.println("ост"+ theThreads[i].getName());
                theThreads[i].interrupt();
                if (theThreads[i].isAlive()) System.out.println("llllll");
            }
        //n=n.divide(d);
    }
    public static void main(String[] args) {
        decrypt decrypts[];

        //массив потоков
        Thread thisThread; //основной поток (поток, который управляет другими потоками)
        decrypts=new decrypt[count];
        theThreads=new Thread[count];

        for(int i=0; i<count; i++) {
            decrypts[i] = new decrypt();	//Создание потока
            theThreads[i]=new Thread(decrypts[i]);
            theThreads[i].start();
            //System.out.println(currentThread().getName());
        }
        //System.out.println(currentThread().getName());


    }*/
}
