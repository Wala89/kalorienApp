package com.example.footdiary;

public class CalculateCalories {
    public static int femaleBasicCalories(DataBundle bundle) {
        return (int) (655 + (9.5 * bundle.getWight()) + (1.9 * bundle.getSize()) - (4.7 * bundle.getAge()));
    }

    public static int maleBasicCalories(DataBundle bundle) {
        return (int) (66 + (13.8 * bundle.getWight()) + (5 * bundle.getSize()) - (6.8 * bundle.getAge()));
    }
}
