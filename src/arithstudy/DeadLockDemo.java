package arithstudy;

/**
 * @author YuSiJia
 * @date 2020/3/31
 * @desc
 */
public class DeadLockDemo extends Thread {
    String lockA ;
    String lockB;
    public DeadLockDemo(String name,String lockA,String lockB){
        super(name);
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName() + "拿到了" + lockA + ",等待拿到" + lockB);
            try {
                Thread.sleep(1000);
                synchronized (lockB){
                    System.out.println(Thread.currentThread().getName() + "拿到了" + lockB);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args){
        String lockA = "lockA";
        String lockB = "lockB";
        DeadLockDemo threadA = new DeadLockDemo("ThreadA", lockA, lockB);
        DeadLockDemo threadB = new DeadLockDemo("ThreadB", lockB, lockA);
        threadA.start();
        threadB.start();
        try {
            threadA.join();
            System.out.println("thread join");
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
