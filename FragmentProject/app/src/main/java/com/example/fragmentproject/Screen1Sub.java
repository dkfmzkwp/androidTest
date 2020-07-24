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

public class Screen1Sub extends Fragment {

    private TextView tvFragment1;
    private ImageView ivImage1;

    private MainActivity mainActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        //MainActivity 객체를 가져온다.
        mainActivity = (MainActivity) getActivity();

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mainActivity = null;
    }

    //MainActivity 에서 setContentView(R.layout.activity_main); 와 역할이 같다.
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        //객체가 된 R.layout.sub_screen1(inflaction)을 container로 저장 후 원할때 불러옴(false)
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.sub_screen1,container,false);
        //UI id
        findViewByIdFunc(rootView);

       // ivImage1.
        //이벤트
        ivImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.changeScreen(2);
                Toast.makeText(mainActivity,"2번 화면으로 변경",Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    private void findViewByIdFunc(ViewGroup rootView) {
        tvFragment1 = (TextView) rootView.findViewById(R.id.tvFragment1);
            ivImage1 = (ImageView) rootView.findViewById(R.id.ivImage1);
    }

}
