package com.creativejones.andre.androidup.model.android;

import android.os.Parcel;
import android.os.Parcelable;

import com.creativejones.andre.androidup.R;
import com.creativejones.andre.androidup.model.Course;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AppComponentCourse extends Course {
    public AppComponentCourse() {
        super("App Components", R.color.app_component_color, R.dimen.course_box_appcomponent_height);
    }


    public AppComponentCourse(Parcel in){
        super(in);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Course createFromParcel(Parcel in) {
            return new AppComponentCourse(in);
        }

        public Course[] newArray(int size) {
            return new Course[size];
        }
    };

    @Override
    public HashMap<String, List<CourseItem>> createSections() {
        HashMap<String, List<CourseItem>> result = new HashMap<>();

        List<CourseItem> intents_intent_filters = Arrays.asList(
                CourseItem.newInstance("", "")
        );

        result.put("Intents and Intent Filters", intents_intent_filters);

        return result;
    }
}
