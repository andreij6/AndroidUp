package com.creativejones.andre.androidup.model.android;

import android.os.Parcel;
import android.os.Parcelable;

import com.creativejones.andre.androidup.model.Course;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GlossaryCourse extends Course {

    public GlossaryCourse(){
        super("Glossary");
    }

    public GlossaryCourse(Parcel in){
        super(in.readString());
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Course createFromParcel(Parcel in) {
            return new GlossaryCourse(in);
        }

        public Course[] newArray(int size) {
            return new Course[size];
        }
    };

    @Override
    public HashMap<String, List<CourseItem>> createSections() {
        HashMap<String, List<CourseItem>> result = new HashMap<>();

        List<CourseItem> terms = Arrays.asList(
                CourseItem.newInstance("", "")
        );

        result.put("Glossary", terms);

        return result;
    }
}
