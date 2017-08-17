package com.jd.macs.mybatis.reflector;

import java.util.List;

/**
 * Created by machangsheng on 17/8/3.
 */
public class Data<T> {

    private T data;
    private List<T> dataList;

    private Data<T> nextData;

    private Data<T>[] dataArray;

    private Data<T>[] getDataArray(){
        return dataArray;
    }

    private T[] getTData(){
        return null;
    }

    private int[] getIds(){
        return new int[] {1, 2, 3};
    }


    public T getData() {
        return data;
    }

    private int id = 1;
    private String name = "default";

    private int getId(){
        return id;
    }

    private String getName(){
        return name;
    }

    private List<T> getDataList(){
        return dataList;
    }

    public Data<T> getNext(){
        return nextData;
    }
}
