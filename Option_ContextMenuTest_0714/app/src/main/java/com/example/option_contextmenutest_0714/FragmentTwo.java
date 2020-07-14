package com.example.option_contextmenutest_0714;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment {
    private EditText etId;
    private EditText etPassword;
    private Button btnLogin;
    private MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
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
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_two,container,false);

        btnLogin = (Button) viewGroup.findViewById(R.id.btnLogin);
        etId = (EditText) viewGroup.findViewById(R.id.etId);
        etPassword = (EditText) viewGroup.findViewById(R.id.etPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLoginDialog();
            }
        });

        return viewGroup;
    }

    private void showLoginDialog() {
        final EditText edtId;
        final EditText edtPw;
        View dialogView = View.inflate(getActivity(),R.layout.login_dialog,null);
        edtId = dialogView.findViewById(R.id.edtId);
        edtPw = dialogView.findViewById(R.id.edtPw);

        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle("로그인");
        dialog.setView(dialogView);

        dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                etId.setText(edtId.getText().toString());
                etPassword.setText(edtPw.getText().toString());
            }
        });
        dialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                etId.setText("");
                etPassword.setText("");
            }
        });

        dialog.show();

    }
}
