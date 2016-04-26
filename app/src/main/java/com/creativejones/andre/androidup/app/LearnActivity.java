package com.creativejones.andre.androidup.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.creativejones.andre.androidup.R;
import com.creativejones.andre.androidup.model.Course;

public class LearnActivity extends AppCompatActivity {

    Course mCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        mCourse = getIntent().getParcelableExtra(Course.EXTRA_FLAG);
    }
}
