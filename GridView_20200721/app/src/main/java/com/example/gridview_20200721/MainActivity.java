package com.example.gridview_20200721;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    private ArrayList<Pokemon> poketList =new ArrayList<Pokemon>();
    private Integer[] pImage = {R.drawable.mon01,R.drawable.mon02,R.drawable.mon03,R.drawable.mon04,
            R.drawable.mon05,R.drawable.mon06,R.drawable.mon07,R.drawable.mon08,R.drawable.mon09,
            R.drawable.mon10,R.drawable.mon11,R.drawable.mon12,R.drawable.mon13,R.drawable.mon14,
            R.drawable.mon15,R.drawable.mon16,R.drawable.mon17,R.drawable.mon18,R.drawable.mon19,
            R.drawable.mon20,R.drawable.mon21,R.drawable.mon22,R.drawable.mon23,R.drawable.mon24,
            R.drawable.mon25,R.drawable.mon26,R.drawable.mon27,R.drawable.mon28};
    private String[] pName = {"이상해씨","이상해풀","이상해꽃","파이리","리자드","리자몽",
            "꼬부기","어니부기","거북왕","캐터피","단데기","버터풀","뿔충이","딱충이","독침붕",
            "구구","피죤","피죤투","꼬렛","레트라","깨비참","깨비드릴조","아보","아보크","피카츄","라이츄",
            "모래두지","고지"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        for(int i=0;i<pImage.length;i++){
            poketList.add(new Pokemon(pImage[i],pName[i],i+1));
        }

        PokemonAdapter pokemonAdapter =new PokemonAdapter(getApplicationContext());
        pokemonAdapter.pokeList =this.poketList;

        gridView.setAdapter(pokemonAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Pokemon pokemon = poketList.get(i);

                View dialogView = getLayoutInflater().inflate(R.layout.dialog,null);
                ImageView dialImage = dialogView.findViewById(R.id.dialImage);
                TextView dialName = dialogView.findViewById(R.id.dialName);
                TextView dialNum = dialogView.findViewById(R.id.dialNum);

                AlertDialog.Builder dialog =new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("오늘의 포켓몬?!");
                dialog.setView(dialogView);

                dialImage.setImageResource(poketList.get(i).getImage());
                dialName.setText(poketList.get(i).getName());
                dialNum.setText("도감번호 : 00"+poketList.get(i).getNum());

                dialog.setNegativeButton("닫기",null);

                dialog.show();
            }
        });

    }
}
