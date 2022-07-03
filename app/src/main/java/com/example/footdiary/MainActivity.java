package com.example.footdiary;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private TextView txtCalories;
    private TextView txtCalDefi;

    private EditText etxtWight;
    private EditText etxtSize;
    private EditText etxtAge;
    private EditText etxtDefiziet;

    private RadioButton rbFemale;
    private RadioButton rbMale;

    private CheckBox checkBox;
    private Spinner spinnerActivTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialViews();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void btnCalculate(View view) {

        int calories = calculateCalories(getUserValues());
        txtCalories.setText(String.valueOf(calories));
        try {
            txtCalDefi.setText(String.valueOf(calories - Integer.parseInt(etxtDefiziet.getText().toString())));
        } catch (Exception e) {
            Toast.makeText(this, "enter your calories defiziet", Toast.LENGTH_SHORT).show();
        }

    }

    // TODO: Wird später ausgelagert in eine eigene Activity weil es nicht immer wieder neu eingeben
    // TODO: werden muss.
    private DataBundle getUserValues() {
        int age;
        int size;
        int wight;

        try {
            age = Integer.parseInt(etxtAge.getText().toString());
        } catch (Exception e) {
            Toast.makeText(this, "pls enter your age!", Toast.LENGTH_SHORT).show();
            age = 0;
        }

        try {
            size = Integer.parseInt(etxtSize.getText().toString());
        } catch (Exception e) {
            Toast.makeText(this, "pls enter your size", Toast.LENGTH_SHORT).show();
            size = 0;
        }

        try {
            wight = Integer.parseInt(etxtWight.getText().toString());
        } catch (Exception e) {
            Toast.makeText(this, "pls enter your wight", Toast.LENGTH_SHORT).show();
            wight = 0;
        }

        return new DataBundle(age, wight, size);
    }

    // TODO: Wird in eine eigene Classe ausgelagert.
    private int calculateCalories(DataBundle bundle) {
        int output = 0;

        if (rbFemale.isChecked()) {
            // female
            output = CalculateCalories.femaleBasicCalories(bundle);
        }

        if (rbMale.isChecked()) {
            // male
            output = CalculateCalories.maleBasicCalories(bundle);
        }

        if (checkBox.isChecked()) {
            Log.e(TAG, "spinner" + spinnerActivTime.getSelectedItemPosition());
            output = (int) (output * Utils.getInstance().getDailyActivity().get(spinnerActivTime.getSelectedItemPosition()));
        }

        return output;
    }

    /**
     * Initialisiert alle UI Elemente im MainActivity View
     */
    private void initialViews() {
        txtCalories = findViewById(R.id.txtCalories);
        txtCalDefi = findViewById(R.id.txtCalDefi);

        etxtAge = findViewById(R.id.etxtAge);
        etxtSize = findViewById(R.id.etxtSize);
        etxtWight = findViewById(R.id.etxtWight);
        etxtDefiziet = findViewById(R.id.etxtDefiziet);

        rbFemale = findViewById(R.id.rBFemale);
        rbMale = findViewById(R.id.rBMale);

        checkBox = findViewById(R.id.ceckBoxModificator);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    spinnerActivTime.setEnabled(true);
                    Log.e(TAG, "onClick: true");
                } else {
                    spinnerActivTime.setEnabled(false);
                    Log.e(TAG, "onClick: false");
                }
            }
        });
        spinnerActivTime = findViewById(R.id.spinnerActiveTime);
        spinnerActivTime.setEnabled(false);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.activTime, com.google.android.material.R.layout.support_simple_spinner_dropdown_item);
        spinnerActivTime.setAdapter(adapter);
    }
}