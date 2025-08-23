package 自己玩.多线程.AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

// 自定义不可重入锁
public class MyLock implements Lock {

    /**
     * 同步器类,不可重入锁（独占锁）
     */
    class MySync extends AbstractQueuedSynchronizer { // AbstractQueuedSynchronizer即AQS
        // 尝试获取锁
        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)){
                // 加上了锁,设置owner为当前线程
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }else {
                return false;
            }
        }

        // 尝试释放锁
        @Override
        protected boolean tryRelease(int arg) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        // 是否持有独占锁
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        // 创建独立变量
        public Condition newCondition(){
            return new ConditionObject();
        }
    }

    private MySync sync = new MySync();

    // 加锁
    @Override
    public void lock() {
        // 加锁
        sync.acquire(1);
    }

    // 可打断加锁
    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    // 尝试加锁（不成功进入等待队列等待）
    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    // 尝试加锁（带超时时间）
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    // 取消加锁
    @Override
    public void unlock() {
        sync.release(1);
    }

    // 创建条件变量
    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    // 测试多线程
    public static void main(String[] args) {
        MyLock lock = new MyLock();
        new Thread(() -> {
            lock.lock();

            try {
                System.out.println(Thread.currentThread().getName() + "加锁中");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("取消加锁");
                lock.unlock();
            }
        }, "t1").start();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "加锁中");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("取消加锁");
                lock.unlock();
            }
        }, "t2").start();

    }
}
