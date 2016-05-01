package com.creativejones.andre.androidup.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.List;

public abstract class Course implements Parcelable {
    public static final String EXTRA_FLAG = "course_flag";
    private int mColorResourceId;
    private int mHeight;

    public Course(Parcel in){
        mTitle = in.readString();
        mColorResourceId = in.readInt();
        mHeight = in.readInt();
        mSections = createSections();
    }

    public Course(String title, int colorResourceId, int height){
        mTitle = title;
        mColorResourceId = colorResourceId;
        mSections = createSections();
        mHeight = height;
    }

    protected String mTitle;
    protected HashMap<String, List<CourseItem>> mSections;

    public String getTitle() {
        return mTitle;
    }

    public abstract HashMap<String, List<CourseItem>> createSections();

    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeInt(mColorResourceId);
        dest.writeInt(mHeight);
    }

    public int getColorResourceId() {
        return mColorResourceId;
    }

    public int getHeight() {
        return mHeight;
    }


    //endregion

    public static class CourseItem {
        private String Term;
        private String Definition;

        public static CourseItem newInstance(String term, String definition){
            CourseItem item = new CourseItem();
            item.Term = term;
            item.Definition = definition;
            return item;
        }
    }

}
