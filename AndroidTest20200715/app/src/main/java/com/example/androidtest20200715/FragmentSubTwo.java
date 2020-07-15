package com.example.androidtest20200715;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentSubTwo extends Fragment {
    private Sub1Activity sub1Activity;
    private TextView textView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        sub1Activity = (Sub1Activity)getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        sub1Activity = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_subtwo,container,false);

        textView = viewGroup.findViewById(R.id.textView);

        return viewGroup;
    }
}
