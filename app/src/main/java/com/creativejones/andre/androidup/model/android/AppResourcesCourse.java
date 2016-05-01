package com.creativejones.andre.androidup.model.android;

import android.os.Parcel;
import android.os.Parcelable;

import com.creativejones.andre.androidup.R;
import com.creativejones.andre.androidup.model.Course;

import java.util.HashMap;
import java.util.List;

public class AppResourcesCourse extends Course {

    public AppResourcesCourse(){
        super("App Resources", R.color.app_resource_color, R.dimen.course_box_appresources_height);
    }

    public AppResourcesCourse(Parcel in){
        super(in);
    }

    @Override
    public HashMap<String, List<CourseItem>> createSections() {
        return null;
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Course createFromParcel(Parcel in) {
            return new AppResourcesCourse(in);
        }

        public Course[] newArray(int size) {
            return new Course[size];
        }
    };
}
