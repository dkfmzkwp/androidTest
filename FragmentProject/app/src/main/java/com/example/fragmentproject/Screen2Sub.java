package com.example.fragmentproject;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Screen2Sub extends Fragment {

    private TextView tvFragment2;
    private ImageView ivImage2;

    private MainActivity mainActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity)getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mainActivity = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //객체가 된 R.layout.sub_screen1(inflaction)을 container로 저장 후 원할때 불러옴(false)
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.sub_screen2,container,false);
        //UI id
        findViewByIdFunc(rootView);

        //이벤트
        ivImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.changeScreen(1);
                Toast.makeText(mainActivity,"1번화면으로 변경", Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }

    private void findViewByIdFunc(ViewGroup rootView) {
        tvFragment2 = (TextView) rootView.findViewById(R.id.tvFragment2);
        ivImage2 = (ImageView) rootView.findViewById(R.id.ivImage2);
    }
}
