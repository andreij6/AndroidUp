package com.creativejones.andre.androidup.app.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativejones.andre.androidup.R;
import com.creativejones.andre.androidup.model.Curriculum;
import com.creativejones.andre.androidup.model.android.AndroidCurriculum;
import com.creativejones.andre.androidup.widget.LearnAdapter;

public class LearnFragment extends BaseMainFragment {

    RecyclerView Recycler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_learn, container, false);

        Recycler = (RecyclerView)view.findViewById(R.id.main_learn_recycler);

        setupRecycler();

        return view;
    }

    private void setupRecycler() {
        Recycler.setAdapter(new LearnAdapter(getActivity(), getCurrentCurriculum()));

        Recycler.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
    }

    public Curriculum getCurrentCurriculum() {
        return new AndroidCurriculum();
    }
}
