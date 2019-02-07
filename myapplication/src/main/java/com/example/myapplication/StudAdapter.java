package com.example.myapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class StudAdapter extends ArrayAdapter<Student> {

    private LayoutInflater inflater;
    private int layout;
    private List<Student> students;


    public StudAdapter(Context context, int resource, List<Student> students) {
        super(context, resource, students);
        this.students = students;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }



    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);
        TextView nameView = (TextView) view.findViewById(R.id.vName);
        TextView resultlView = (TextView) view.findViewById(R.id.vResult);
        Student student = students.get(position);
        nameView.setText(student.getName());
        resultlView.setText(student.getResult());
        return view;
    }

}