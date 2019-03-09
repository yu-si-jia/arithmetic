package arit;


/**
 * 单力模式的四种创建方式
 */

/**
 * 不是线程安全的 当两个线程同时判断实例是否存在时 会造成多个Instance的创建
 */
class Singleton1 {
    private static Singleton1 instance=null;
    private Singleton1(){}
    public static Singleton1 getInstance(){
        if(instance==null){
            instance=new Singleton1();
        }
        return instance;
    }
}

/**
 * 是线程安全的 但是每次都要给线程加锁 效率不是很高
 */
class Singleton2{
    private Singleton2(){ }
    private static Singleton2 instance = null;

    public static synchronized Singleton2 getInstance(){
        if (instance==null){
            instance = new Singleton2();
        }
        return instance;
    }
}


/**
 * 线程安全的 加同步锁时两次判断实例是否存在
 * 与上一个方法相比 加同步锁判断两次更安全
 * 因为加锁需要时间 在加锁的过程中可能会判断错误
 * 造成俩实例
 */

class Singleton3{
    private Singleton3(){}
    private static Singleton3 instance = null;

    public Singleton3 getInstance(){
        if (instance == null){
            synchronized (this){
                if (instance == null){
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}

/**
 * 静态代码快在实例化中只加载一次
 * 会降低内存的使用率
 */
class Singleton4{
    private Singleton4(){}
    private static Singleton4 instance = new Singleton4();

    public Singleton4 getInstance(){
        return instance;
    }
}

/**
 * 静态内部类加载一次，instance不可修改
 * Singleton是静态内部类 只有当调用getInstance时才会创建实例
 */
class Singleton5 {
    private Singleton5(){}
    private static class SingletonHolder{
        private final static Singleton5 instance=new Singleton5();
    }
    public static Singleton5 getInstance(){
        return SingletonHolder.instance;
    }
}