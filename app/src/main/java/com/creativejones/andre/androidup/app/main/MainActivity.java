package com.creativejones.andre.androidup.app.main;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;

import com.creativejones.andre.androidup.R;
import com.creativejones.andre.androidup.app.LearnActivity;
import com.creativejones.andre.androidup.model.Course;
import com.creativejones.andre.androidup.presenter.IMainPresenter;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainView {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    private IMainPresenter Presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //region IMainView
    @Override
    public void CourseClicked(Course course) {
        Intent intent = new Intent(this, LearnActivity.class);

        intent.putExtra(Course.EXTRA_FLAG, course);

        startActivity(intent);
    }
    //endregion

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        List<BaseMainFragment> Pages;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
            Pages = setupPages();
        }

        private List<BaseMainFragment> setupPages() {
            return Arrays.asList(new LearnFragment(), new StudyFragment(), new QuizFragment());
        }

        @Override
        public Fragment getItem(int position) {
            return Pages.get(position);
        }

        @Override
        public int getCount() {
            return Pages.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return getString(R.string.learn_page_title);
                case 1:
                    return getString(R.string.study_page_title);
                case 2:
                    return getString(R.string.quiz_page_title);

            }

            return null;
        }
    }
}
