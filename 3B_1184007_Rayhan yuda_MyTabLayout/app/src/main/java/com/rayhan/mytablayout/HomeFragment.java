package com.rayhan.mytablayout;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    public static HomeFragment newInstance(int index) {
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final TextView textView = view.findViewById(R.id.section_label);
        int index = 1;
        if (getArguments() !=null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        textView.setText(getString(R.string.content_tab_text) + " " + index);
        }
    }


