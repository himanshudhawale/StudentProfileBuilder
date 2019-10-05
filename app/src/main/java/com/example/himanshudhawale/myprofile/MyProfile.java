package com.example.himanshudhawale.myprofile;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MyProfile extends AppCompatActivity {

static final int REQ_CODE=100;
static final String VALUE_KEY="text";
static final String USER_KEY="USER";
 public int imageno=-1;

    private ImageView imageView;
    private EditText fname, lname, studentId;
    private RadioGroup department;
    private RadioButton csbutton, sisbutton, biobutton, otherbutton;
    private Button save;
    private TextView myAvatar;

    private String departmentstring;
    private int rbuttonId=-1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);



        imageView = findViewById(R.id.imageViewId);


        myAvatar=findViewById(R.id.myavatarid);
        csbutton=findViewById(R.id.radioButton1);
        sisbutton=findViewById(R.id.radioButton2);
        biobutton=findViewById(R.id.radioButton3);
        otherbutton=findViewById(R.id.radioButton4);




        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent1 = new Intent(getBaseContext(), SelectAvatar.class);
                    startActivityForResult(intent1, REQ_CODE);
                    myAvatar.setVisibility(View.GONE);


                //finish();
            }
        });

        fname=findViewById(R.id.editText);
        lname=findViewById(R.id.editText2);
        studentId=findViewById(R.id.editText3);
        department=findViewById(R.id.radioGroup);




        department.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                 rbuttonId= department.getCheckedRadioButtonId();

                 if(rbuttonId==R.id.radioButton1)
                 {
                     departmentstring="CS";
                 } else if(rbuttonId==R.id.radioButton2)
                {
                    departmentstring="SIS";
                } else if(rbuttonId==R.id.radioButton3)
                {
                    departmentstring="BIO";
                }
                else if (rbuttonId==R.id.radioButton4)
                 {
                     departmentstring="Other";
                 }




                }

        });


        save=findViewById(R.id.button);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(imageno==-1)
                {
                    Toast.makeText(MyProfile.this, "Select an Avatar", Toast.LENGTH_LONG).show();
                }

                else if(fname.getText().toString().isEmpty())
                {
                    Toast.makeText(MyProfile.this, "Enter first name", Toast.LENGTH_LONG).show();
                }

               else if(lname.getText().toString().isEmpty())
                {
                    Toast.makeText(MyProfile.this, "Enter last name", Toast.LENGTH_LONG).show();
                }

                else if (studentId.getText().toString().length()!=9) {

                    Toast.makeText(MyProfile.this, "Enter 9 digit student ID", Toast.LENGTH_LONG).show();

                }

                else if(rbuttonId==-1){
                    Toast.makeText(MyProfile.this, "Select a department", Toast.LENGTH_LONG).show();
                }
                else {


                    User user = new User(fname.getText().toString(), lname.getText().toString(), departmentstring, (studentId.getText().toString()), imageno);


                    Intent intent2 = new Intent(MyProfile.this, DisplayMyProfile.class);
                    intent2.putExtra(USER_KEY, user);
                    startActivity(intent2);



                }
            }


        });


        if(getIntent()!=null && getIntent().getExtras()!=null) {
            final User user= (User) getIntent().getExtras().getSerializable(DisplayMyProfile.USER_KEY1);


            myAvatar.setVisibility(View.GONE);
            fname.setText(user.fname);
            lname.setText(user.lname);
            studentId.setText(user.studentId);
            String departmentString=user.department;
            if(departmentString.equals("CS"))
            {
                csbutton.setChecked(true);
            }
            else if(departmentString.equals("SIS"))
            {
                sisbutton.setChecked(true);
            }else if(departmentString.equals("BIO"))
            {
                biobutton.setChecked(true);
            }else if(departmentString.equals("Other"))
            {
                otherbutton.setChecked(true);
            }


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


        }










    }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode==REQ_CODE)
            {
                if(resultCode==RESULT_OK)
                {
                    String value= data.getExtras().getString(VALUE_KEY);

                    if(value.equals("img1")){

                        imageView.setImageResource(R.drawable.avatar_f_1);
                        imageno=1;
                    }
                    else if(value.equals("img2"))
                    {
                        imageView.setImageResource(R.drawable.avatar_m_1);
                        imageno=2;

                    }
                    else if(value.equals("img3"))
                    {
                        imageView.setImageResource(R.drawable.avatar_f_2);
                        imageno=3;

                    }
                    else if(value.equals("img4"))
                    {
                        imageView.setImageResource(R.drawable.avatar_m_2);
                        imageno=4;

                    }
                    else if(value.equals("img5"))
                    {
                        imageView.setImageResource(R.drawable.avatar_f_3);
                        imageno=5;

                    }
                    else if(value.equals("img6"))
                    {
                        imageView.setImageResource(R.drawable.avatar_m_3);
                        imageno=6;

                    }






                }
                else if(resultCode==RESULT_CANCELED){

                }
            }

        }




}
