package com.example.himanshudhawale.myprofile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayMyProfile extends AppCompatActivity {


    private TextView fullname, studentID, departmentname;
    private ImageView imageView;
    private Button editbutton;
    int imageno;
    static final String USER_KEY1="USER1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_my_profile);




        final User user= (User) getIntent().getExtras().getSerializable(MyProfile.USER_KEY);


        fullname=findViewById(R.id.fullnameId);
        studentID=findViewById(R.id.studentdisplayId);
        departmentname=findViewById(R.id.departmentdisplayId);

        imageView=findViewById(R.id.imageViewDisplay);


        editbutton=findViewById(R.id.editbuttonId);

        String str =user.fname + " " + user.lname;

        fullname.setText(str);

        studentID.setText(user.studentId);

        departmentname.setText(user.department);

        imageno=user.imageno;


        if(imageno==1)
        {
            imageView.setImageResource(R.drawable.avatar_f_1);

        }
        else if(imageno==2)
        {
            imageView.setImageResource(R.drawable.avatar_m_1);

        }

        else if(imageno==3)
        {
            imageView.setImageResource(R.drawable.avatar_f_2);

        }
        else if(imageno==4)
        {
            imageView.setImageResource(R.drawable.avatar_m_2);

        }
        else if(imageno==5)
        {
            imageView.setImageResource(R.drawable.avatar_f_3);

        }
        else if(imageno==6)
        {
            imageView.setImageResource(R.drawable.avatar_m_3);

        }


        editbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent3= new Intent(DisplayMyProfile.this, MyProfile.class);
                intent3.putExtra(USER_KEY1, user);

                startActivity(intent3);
                finish();



            }
        });







    }
}
