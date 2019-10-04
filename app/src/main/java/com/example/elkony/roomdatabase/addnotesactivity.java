package com.example.elkony.roomdatabase;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.elkony.roomdatabase.DATABASE.Models.Notes;
import com.example.elkony.roomdatabase.DATABASE.MyDataBase;

import java.time.Year;
import java.util.Calendar;

import androidx.room.Database;

public class addnotesactivity extends AppCompatActivity implements View.OnClickListener {

    protected EditText title;
    protected EditText content;
    protected TextView datatime;
    protected Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_addnotesactivity);
        initView();


    }
  String Notetime="";

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.add) {
            String titles = title.getText().toString();
            String contents = content.getText().toString();
            Notes note=new Notes(titles,contents,Notetime);
            MyDataBase.getInstance(this).notesDaos().addnote(note);
        } else if (view.getId() == R.id.datatime) {
            Calendar calendar = Calendar.getInstance();
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                 Notetime=hourOfDay+":"+minute;
                 datatime.setText(Notetime);
                }
            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false);
            timePickerDialog.show();


        }
        Toast.makeText(addnotesactivity.this,"added sucessefully",Toast.LENGTH_LONG).show();
    }
    private void initView() {
        title = (EditText) findViewById(R.id.title);
        content = (EditText) findViewById(R.id.content);
        datatime = (TextView) findViewById(R.id.datatime);
        datatime.setOnClickListener(addnotesactivity.this);
        add = (Button) findViewById(R.id.add);
        add.setOnClickListener(addnotesactivity.this);
    }
}

