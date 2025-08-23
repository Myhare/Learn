package 自己玩.多线程;

public class SonThread implements Cloneable{
    public static void main(String[] args){
        SonThread p = new SonThread();
        System.out.println(p);
        Thread t = new Thread(new Runnable(){
            public void run(){
            	ThreadLocal<SonThread> threadLocal = new ThreadLocal<>();
            	System.out.println(threadLocal);
            	threadLocal.set(p);
            	System.out.println(threadLocal.get());
            	threadLocal.remove();
            	try {
					threadLocal.set((SonThread) p.clone());
					System.out.println(threadLocal.get());
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
            	System.out.println(threadLocal);
            }});
        t.start();
    }
}
