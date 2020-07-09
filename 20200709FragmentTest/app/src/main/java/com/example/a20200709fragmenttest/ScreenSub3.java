package com.example.a20200709fragmenttest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ScreenSub3 extends Fragment {
    private Switch swStart;
    private Button btnClose;
    private Button btnReset;
    private RadioGroup rgPoketmon;
    private RadioButton rdoCharizard;
    private RadioButton rdoGreninja;
    private RadioButton rdoZeraora;
    private ImageView ivPoketmon;
    private TextView tvChoice;
    private Button btnS1;
    private Button btnS2;
    private Button btn3A2;

    private MainActivity mainActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity)getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mainActivity= null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment3,container,false);
        findViewByIdFunc(rootView);

        btnS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.changeScreen(1);
            }
        });
        btnS2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.changeScreen(2);
            }
        });
        btn3A2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity,Sub2Activity.class);
                startActivity(intent);
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swStart.setChecked(false);
            }
        });
        rgPoketmon.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (rgPoketmon.getCheckedRadioButtonId()) {
                    case R.id.rdoCharizard:
                        ivPoketmon.setImageResource(R.drawable.lizard);
                        break;
                    case R.id.rdoGreninja:
                        ivPoketmon.setImageResource(R.drawable.ninja);
                        break;
                    case R.id.rdoZeraora:
                        ivPoketmon.setImageResource(R.drawable.zera);
                        break;
                }
            }
        });

        swStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (swStart.isChecked() == true) {
                    tvChoice.setVisibility(View.VISIBLE);
                    btnClose.setVisibility(View.VISIBLE);
                    btnReset.setVisibility(View.VISIBLE);
                    rgPoketmon.setVisibility(View.VISIBLE);
                    ivPoketmon.setVisibility(View.VISIBLE);
                    btnS1.setVisibility(View.VISIBLE);
                    btnS2.setVisibility(View.VISIBLE);
                    btn3A2.setVisibility(View.VISIBLE);
                } else {
                    tvChoice.setVisibility(View.INVISIBLE);
                    btnClose.setVisibility(View.INVISIBLE);
                    btnReset.setVisibility(View.INVISIBLE);
                    rgPoketmon.setVisibility(View.INVISIBLE);
                    ivPoketmon.setVisibility(View.INVISIBLE);
                    btnS1.setVisibility(View.INVISIBLE);
                    btnS2.setVisibility(View.INVISIBLE);
                    btn3A2.setVisibility(View.INVISIBLE);
                }
            }
        });

        return rootView;
    }

    private void findViewByIdFunc(ViewGroup rootView) {
        swStart = (Switch) rootView.findViewById(R.id.swStart);
        btnClose = (Button) rootView.findViewById(R.id.btnClose);
        btnReset = (Button) rootView.findViewById(R.id.btnReset);
        rgPoketmon = (RadioGroup) rootView.findViewById(R.id.rgPoketmon);
        rdoCharizard = (RadioButton) rootView.findViewById(R.id.rdoCharizard);
        rdoGreninja = (RadioButton) rootView.findViewById(R.id.rdoGreninja);
        rdoZeraora = (RadioButton) rootView.findViewById(R.id.rdoZeraora);
        ivPoketmon = (ImageView) rootView.findViewById(R.id.ivPoketmon);
        tvChoice = (TextView) rootView.findViewById(R.id.tvChoice);
        btnS1 = (Button) rootView.findViewById(R.id.btnS1);
        btnS2 = (Button) rootView.findViewById(R.id.btnS2);
        btn3A2 = (Button) rootView.findViewById(R.id.btn3A2);
    }


}
