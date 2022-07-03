package com.example.footdiary;

public class DataBundle {
    private int age;
    private int wight;
    private int size;

    public DataBundle(int age, int wight, int size) {
        this.age = age;
        this.wight = wight;
        this.size = size;
    }

    public int getAge() {
        return age;
    }

    public int getWight() {
        return wight;
    }

    public int getSize() {
        return size;
    }
}
