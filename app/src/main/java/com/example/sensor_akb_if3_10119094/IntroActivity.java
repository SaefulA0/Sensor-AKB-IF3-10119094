package com.example.sensor_akb_if3_10119094;
// Saeful Anwar Oktariansah 10119094
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPager introViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        //fill  list screen
        List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Selamat Datang Di DisMak", "Mari menjelajahi wisata kuliner Bandung dengan DisMak!",R.drawable.imgnote1));
        mList.add(new ScreenItem("Cari makanan yang kamu inginkan", "membantumu mencari makan yang kamu inginkan",R.drawable.imgnote2));
        mList.add(new ScreenItem("Cari tempat makan didekat mu", "Menampilkan tempat makanan menarik didekat mu",R.drawable.imgnote3));

        //setup viewpager
        screenPager = findViewById(R.id.ScreenViewPager);
        introViewPager = new IntroViewPager(this,mList);
        screenPager.setAdapter(introViewPager);

        Button btnnext = findViewById(R.id.nextbtn);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}