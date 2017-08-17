package com.jd.macs.mybatis.mapper;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Map;

/**T
 * Created by machangsheng on 17/8/11.
 */
@Deprecated
@Resource
public class MyListImpl<T> extends BaseObj implements MyList<T>,
        BaseInterface,
        Serializable{

    public MyListImpl(int fd) {
        super(fd);
    }

    public void add(T data) {

    }

    public int getLength() {
        return 0;
    }

    public T get(int index) {
        return null;
    }


    public Runnable getRunnable(){
        return new Runnable() {
            public void run() {
                Class cls = this.getClass();
                System.out.println(cls.getEnclosingMethod());
            }
        };
    }

    public Class getR2(){
        return MyListImpl.R2.class;
    }

//    public int getFd() {
//        return 0;
//    }

    public class R2 implements Runnable {

        public void run() {

        }
    }

    public Map<T, T> getMap(){
        return null;
    }

    public Map<String, Integer> getKnownTypeMap(){
        return null;
    }
}
