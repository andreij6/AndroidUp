package com.creativejones.andre.androidup.model.android;

import com.creativejones.andre.androidup.model.Course;
import com.creativejones.andre.androidup.model.Curriculum;

import java.util.Arrays;
import java.util.List;

public class AndroidCurriculum implements Curriculum {

    public List<Course> getCourses() {
        return Arrays.asList(
                new GlossaryCourse(),       //http://developer.android.com/guide/appendix/glossary.html
                new AppComponentCourse());
    }
}
