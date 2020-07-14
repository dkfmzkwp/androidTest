package com.example.option_contextmenutest_0714;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentThree extends Fragment {
    private MainActivity mainActivity;
    private ImageView ivImage;

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
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_three,container,false);

        ivImage = (ImageView) viewGroup.findViewById(R.id.ivImage);
        registerForContextMenu(ivImage);


        return viewGroup;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.ctmEvil : ivImage.setImageResource(R.drawable.evil);
                break;
            case R.id.ctmRa : ivImage.setImageResource(R.drawable.ra);
                break;
            case R.id.ctmAlba : ivImage.setImageResource(R.drawable.alba);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
