package com.example.mydatabaselistview_20200722;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<PersonModel> arrayList;

    public void setArrayList(ArrayList<PersonModel> arrayList) {
        this.arrayList = arrayList;
    }

    public CustomAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        //화면 객체 만들기
        LayoutInflater layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =layoutInflater.inflate(R.layout.list_partition,null);
        //위젯 객체 찾기
        TextView etNameList = view.findViewById(R.id.etNameList);
        TextView etCountList = view.findViewById(R.id.etCountList);

        //보여져야할 위치를 ArrayList 에 대입
        PersonModel personModel = arrayList.get(i);
        etNameList.setText(personModel.getName());
        etCountList.setText(String.valueOf(personModel.getCount()));

        return view;
    }
}
