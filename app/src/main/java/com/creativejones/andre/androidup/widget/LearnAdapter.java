package com.creativejones.andre.androidup.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.creativejones.andre.androidup.R;
import com.creativejones.andre.androidup.model.Course;
import com.creativejones.andre.androidup.model.Curriculum;

import java.util.List;

public class LearnAdapter extends RecyclerView.Adapter<LearnAdapter.ViewHolder> {

    OnInteractionListener Listener;
    List<Course> Courses;
    Context mContext;

    public LearnAdapter(Context context, Curriculum curriculum){
        mContext = context;
        Listener = (LearnAdapter.OnInteractionListener)context;
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
        View CourseBox;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            CourseTitle = (TextView)itemView.findViewById(R.id.learn_list_course_title);
            CourseBox = itemView.findViewById(R.id.learn_list_course_box);

        }

        public void bindView(Course course) {
            CourseTitle.setTypeface(getCourseFont());
            CourseTitle.setTextColor(getColor(course.getColorResourceId()));
            CourseTitle.setText(course.getTitle());

            CourseBox.setBackgroundColor(getColor(course.getColorResourceId()));
            CourseBox.getLayoutParams().height = getDimen(course.getHeight());
            mCourse = course;
        }

        @Override
        public void onClick(View v) {
            Listener.CourseClicked(mCourse);
        }
    }

    private int getDimen(int resourceId){
        return (int)mContext.getResources().getDimension(resourceId);
    }

    private int getColor(int resourceId){
        return mContext.getResources().getColor(resourceId);
    }

    private Typeface getCourseFont(){
        return Typeface.createFromAsset(mContext.getAssets(), String.format("fonts/%s.ttf", "VarelaRound-Regular"));
    }

    public interface OnInteractionListener {
        void CourseClicked(Course course);
    }
}
