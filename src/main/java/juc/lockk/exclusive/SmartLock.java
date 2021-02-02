package juc.lockk.exclusive;

import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

/**
 * @author andor
 * @date 2020/9/3
 * @desc 独占锁的实现
 */
public class SmartLock {
    private class Sync extends AbstractQueuedLongSynchronizer{
        @Override
        protected boolean tryAcquire(long arg) {
            // 判断当前线程是否持有锁，支持重入
            if (getExclusiveOwnerThread()==Thread.currentThread()) return true;
            // cas的方式更新state，只有当State为0的时候设置为1
            if (compareAndSetState(0,1)){
                // 当前线程获取锁，设置为持有锁的线程
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }else {
                return false;
            }
        }

        @Override
        protected boolean tryRelease(long arg) {
            setState(0);
            setExclusiveOwnerThread(null);
            return true;
        }
    }

    private Sync mSync;

    public SmartLock(){
        mSync = new Sync();
    }

    public void lock(){
        // 获取独占锁，调用tryAcquire
        mSync.acquire(1);
    }

    public void unLock(){
        mSync.release(1);
    }
}
