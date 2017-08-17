package com.jd.macs.mybatis.mapper;

/**
 * Created by machangsheng on 17/8/11.
 */
public class WaitNotifyTest {

    public static void main(String args[]){

        Object obj = new Object();

        for(int i=0; i<3; i++) {
            WaitThread waitThread = new WaitThread(
                    obj, "waitThread" + i
            );

            waitThread.start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        NotifyThread notifyThread = new NotifyThread(obj,
                "notifyThead");
        notifyThread.start();

    }
}

class WaitThread extends Thread {
    protected final Object object;
    public WaitThread(final Object object, String name) {
        this.object = object;
        setName(name);
    }
    @Override
    public void run(){

        synchronized (object) {
            System.out.println(getName() + " Begin to wait ...");
            try {
                object.wait();
                //当线程被唤醒,且获取到object的控制权后,继续执行后续.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " Finished to wait");
        }

    }



}

class NotifyThread extends WaitThread {

    public NotifyThread(Object object, String name) {
        super(object, name);
    }

    @Override
    public void run(){

        synchronized (object) {
            System.out.println(getName() + " Begin to notify ...");
            object.notifyAll();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " Finished");
        }


    }
}
