package com.example.tabhostfragmentmixedproject;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentOne extends Fragment {

    private Button btnF1;
    private MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mainActivity = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //화면1 one_fragment 메모리로 로드됨.
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.one_fragment,container,false);
        btnF1 = (Button)rootView.findViewById(R.id.btnF1);

        btnF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mainActivity,"화면1",Toast.LENGTH_SHORT).show();
                mainActivity.chageFragment(2);
            }
        });
        return rootView;
    }
}
