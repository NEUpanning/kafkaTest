import org.apache.log4j.net.SyslogAppender;

import java.util.*;

public class MultiTest implements Runnable{
    final int a;

    public MultiTest(int a) {
        this.a = a;
    }
    public void run() {
        synchronized(this) {
            if(a==2)
            {try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }}
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
            }
        }
    }
    public static void main(String[] args) {
//        MultiTest t1 = new MultiTest(1);
//        MultiTest t2 = new MultiTest(2);
//        Thread ta = new Thread(t1, "A");
//        Thread tb = new Thread(t2, "B");
//        ta.start();
//        tb.start();
酷酷酷
        Collection<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(2);
        c.forEach(e-> System.out.println(e));
        c.removeIf(e->e>1);
        c.forEach(e-> System.out.println(e));
        c.stream().map(e->e+1).forEach(System.out::println);
    }
}
