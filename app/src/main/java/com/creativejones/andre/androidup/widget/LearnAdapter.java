package com.creativejones.andre.androidup.widget;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.creativejones.andre.androidup.R;
import com.creativejones.andre.androidup.app.LearnActivity;
import com.creativejones.andre.androidup.model.Course;
import com.creativejones.andre.androidup.model.Curriculum;

import java.util.List;

public class LearnAdapter extends RecyclerView.Adapter<LearnAdapter.ViewHolder> {

    OnInteractionListener Listener;
    List<Course> Courses;

    public LearnAdapter(OnInteractionListener listener, Curriculum curriculum){
        Listener = listener;
        Courses = curriculum.getCourses();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.learn_list_item_one, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindView(Courses.get(position));
    }

    @Override
    public int getItemCount() {
        return Courses.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        Course mCourse;
        TextView CourseTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            CourseTitle = (TextView)itemView.findViewById(R.id.learn_list_course_title);
        }

        public void bindView(Course course) {
            CourseTitle.setText(course.getTitle());
            mCourse = course;
        }

        @Override
        public void onClick(View v) {
            Listener.CourseClicked(mCourse);
        }
    }

    public interface OnInteractionListener {
        void CourseClicked(Course course);
    }
}
