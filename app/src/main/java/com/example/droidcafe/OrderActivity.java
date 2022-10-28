package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {
    public TextView mOrderMessageTextView;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        mOrderMessageTextView = findViewById(R.id.order_message);
        mOrderMessageTextView.setText(message);
    }

    public void displayToast(String message) {
        killToast();
        this.toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        this.toast.show();
    }

    public void killToast() {
        if (this.toast != null) {
            this.toast.cancel();
        }
    }

    public void onRadioButtonOnClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.first_radio_button:
                if (checked)
                    displayToast(getString(R.string.first_radio_button));
                break;
            case R.id.second_radio_button:
                if (checked)
                    displayToast(getString(R.string.second_radio_button));
                break;
            case R.id.third_radio_button:
                if (checked)
                    displayToast(getString(R.string.third_radio_button));
                break;
            default:
                break;
        }

    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.datePicker));
    }

    public void processDatePickerResult(int year, int month, int day) {
        String year_String = Integer.toString(year);
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);

        String date = "You have chosen date: " + month_string + "/" + day_string + "/" + year_String;
        displayToast(date);
    }

}