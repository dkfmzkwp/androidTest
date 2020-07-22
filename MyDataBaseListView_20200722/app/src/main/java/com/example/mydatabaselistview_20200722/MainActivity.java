package com.example.mydatabaselistview_20200722;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText etName, etCount;
    private Button btnClear, btnInsert, btnDelete, btnList, btnEdit;
    private ListView listView;
    private ArrayList<PersonModel> groupList;
    private SQLiteDatabase sqLiteDatabase;
    private MyDataBaseHelper myDataBaseHelper;
    private CustomAdapter customAdapter;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewByIdFnc();

        myDataBaseHelper = new MyDataBaseHelper(getApplicationContext(),"Group List");

        customAdapter =new CustomAdapter(getApplicationContext());
        customAdapter.setArrayList(this.groupList);

        btnClear.setOnClickListener(this);
        btnInsert.setOnClickListener(this);
        btnEdit.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnList.setOnClickListener(this);

        selectTBLFunc();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                position = i;
                etName.setText(groupList.get(i).getName());
                etCount.setText(String.valueOf(groupList.get(i).getCount()));
            }
        });

    }

    private void findViewByIdFnc() {
        etName = findViewById(R.id.etName);
        etCount = findViewById(R.id.etCount);
        btnClear = findViewById(R.id.btnClear);
        btnInsert = findViewById(R.id.btnInsert);
        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);
        btnList = findViewById(R.id.btnList);
        listView = findViewById(R.id.listView);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnClear :
                sqLiteDatabase=myDataBaseHelper.getWritableDatabase();
                myDataBaseHelper.onUpgrade(sqLiteDatabase,1,2);
                sqLiteDatabase.close();

                Toast.makeText(getApplicationContext(),"초기화 성공",Toast.LENGTH_SHORT).show();

                etCount.setText("");
                etName.setText("");
                selectTBLFunc();
                break;
            case R.id.btnInsert :
                String name = etName.getText().toString();
                int count = Integer.parseInt(etCount.getText().toString());

                PersonModel personModel = new PersonModel(name,count);
                boolean returnValue1 = myDataBaseHelper.insertTBL(personModel);
                if(returnValue1 == true){
                    Toast.makeText(getApplicationContext(),"입력 성공",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"입력 오류",Toast.LENGTH_SHORT).show();
                }
                selectTBLFunc();
                break;

            case R.id.btnEdit :
                String name2 = etName.getText().toString();
                int count2 = Integer.parseInt(etCount.getText().toString());

                PersonModel personModel2 = new PersonModel(name2,count2);

                boolean returnValue3 = myDataBaseHelper.updateTBL(personModel2);
                if(returnValue3 == true){
                    Toast.makeText(getApplicationContext(),"수정 성공",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"수정 오류",Toast.LENGTH_SHORT).show();
                }
                selectTBLFunc();
                break;

            case R.id.btnDelete :
                String name1 = groupList.get(position).getName();
                int count1 = groupList.get(position).getCount();

                PersonModel personModel1 = new PersonModel(name1,count1);

                boolean returnValue2 = myDataBaseHelper.deleteTBL(personModel1);
                if(returnValue2 == true){
                    Toast.makeText(getApplicationContext(),"삭제 성공",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"삭제 오류",Toast.LENGTH_SHORT).show();
                }
                selectTBLFunc();
                break;

            case R.id.btnList :
                selectTBLFunc();

                break;
            default : break;
        }
    }
    public void selectTBLFunc(){
        groupList = myDataBaseHelper.selectTBL();
        customAdapter.setArrayList(myDataBaseHelper.selectTBL());
        listView.setAdapter(customAdapter);
    }
}
