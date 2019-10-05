package com.example.himanshudhawale.myprofile;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.Serializable;

public class SelectAvatar extends AppCompatActivity {

    private ImageView imageView2, imageView3, imageView4, imageView5, imageView6, imageView7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_avatar);

        imageView2= findViewById(R.id.imageViewId2);
        imageView3= findViewById(R.id.imageViewId3);
        imageView4= findViewById(R.id.imageViewId4);
        imageView5= findViewById(R.id.imageViewId5);
        imageView6= findViewById(R.id.imageViewId6);
        imageView7= findViewById(R.id.imageViewId7);


        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent();
                String value="img1";
                intent1.putExtra(MyProfile.VALUE_KEY, value);
                setResult(RESULT_OK, intent1);
                finish();
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent();
                String value="img2";
                intent1.putExtra(MyProfile.VALUE_KEY, value);
                setResult(RESULT_OK, intent1);
                finish();

            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent();
                String value="img3";
                intent1.putExtra(MyProfile.VALUE_KEY, value);
                setResult(RESULT_OK, intent1);
                finish();


            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent(getBaseContext(), MyProfile.class);
                String value="img4";
                intent1.putExtra(MyProfile.VALUE_KEY, value);
                setResult(RESULT_OK, intent1);
                finish();


            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent(getBaseContext(), MyProfile.class);
                String value="img5";
                intent1.putExtra(MyProfile.VALUE_KEY, value);
                setResult(RESULT_OK, intent1);
                finish();


            }
        });
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent(getBaseContext(), MyProfile.class);
                String value="img6";
                intent1.putExtra(MyProfile.VALUE_KEY, value);
                setResult(RESULT_OK, intent1);
                finish();


            }
        });





    }
}
