package com.example.footdiary;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class UserData {
    private static final String TAG = "UserData";

    // --- Variables ------------------------------------------------------------------------------
    private String name;
    private String gender;
    private String birthdate;
    private int wight;
    private int size;

    // --- Constructor ----------------------------------------------------------------------------
    public UserData(String name, String gender, String birthdate, int wight, int size) {
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.wight = wight;
        this.size = size;
    }

    // --- Getter ---------------------------------------------------------------------------------

    /**
     * Calculate the age from the User.
     * @return int userAge
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public int getUserAge() {
        LocalDate today = LocalDate.now();
        LocalDate birth = LocalDate.parse("1989-03-26");

        int age = Period.between(birth, today).getYears();

        Log.e(TAG, "geburtsdatum: " + LocalDate.parse("1989-03-26"));
        Log.e(TAG, "Datum: " + LocalDate.now());
        Log.e(TAG, "age: " + age);

        return age;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public int getWight() {
        return wight;
    }

    public int getSize() {
        return size;
    }
}
