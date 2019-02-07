package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<Student> students = new ArrayList<>();
    private ListView studList;
    private StudAdapter adapter;
    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        initData();

        studList = (ListView) findViewById(R.id.studlist);
        studList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        adapter = new StudAdapter(this, R.layout.stud_list, students);

        studList.setAdapter(adapter);

        btn1 = (Button) findViewById(R.id.add);
        btn2 = (Button) findViewById(R.id.rmv);

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.add:
                        String n = getText(R.id.eName).toString();
                        String r = getText(R.id.eResult).toString();
                        students.add(new Student(r,n));
                        adapter.notifyDataSetChanged();

                        break;

                    case R.id.rmv:

                        break;
                }
            }
        };

        btn1.setOnClickListener(onClickListener);
        btn2.setOnClickListener(onClickListener);

    }

    private void initData() {
        students.add(new Student("Asanov", "100"));
        students.add(new Student("Sherin ", "100"));
        students.add(new Student("Tarasova", "100"));
        students.add(new Student("Tarasenko", "100"));
    }



}