package com.example.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;



public class profile extends AppCompatActivity {
    //profile edite text
    public EditText profile_address, profile_Phone, profile_middlename, profile_firstname, profile_EmailAddress, profile_lastname;

    public Button profile_save_btn, profile_edite_btn;
    int PhoneStr;
    String F_nameStr;
    String EmailStr;
    String AddressStr;
    String M_nameStr;
    String L_nameStr;

    SharedPreferences sp;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //profile_activity edite text

        sp = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences sp = getApplicationContext().getSharedPreferences("prefs", Context.MODE_PRIVATE);
        profile_Phone= findViewById(R.id.profile_Phone);
        profile_address = findViewById(R.id.profile_address);
        profile_middlename = findViewById(R.id.profile_middlename);
        profile_firstname = findViewById(R.id.profile_firstname);
        profile_EmailAddress = findViewById(R.id.profile_EmailAddress);
        profile_lastname = findViewById(R.id.profile_lastname);
        profile_save_btn = findViewById(R.id.profile_save_btn);
        profile_edite_btn = findViewById(R.id.profile_edite_btn);




        //retrieve data


        String first= sp.getString("profile_firstname","");
        profile_firstname.setText(first);

        String midllename= sp.getString("profile_middlename","");
        profile_middlename.setText(midllename);

        String email= sp.getString("profile_EmailAddress","");
        profile_EmailAddress.setText(email);

        String adress= sp.getString("profile_address","");
        profile_address.setText(adress);
        String last= sp.getString("profile_lastname","");
        profile_lastname.setText(last);
      // int  pho= sp.getInt("profile_Phone", 0);
      // profile_Phone.setId(pho);





        //save data
        profile_save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AddressStr = profile_address.getText().toString();
                M_nameStr = profile_middlename.getText().toString();
                F_nameStr = profile_firstname.getText().toString();
                EmailStr = profile_EmailAddress.getText().toString();
                L_nameStr = profile_lastname.getText().toString();
                PhoneStr = profile_Phone.getId();

                SharedPreferences.Editor editor = sp.edit();

                editor.putInt("profile_Phone", PhoneStr);
                editor.putString("profile_address", AddressStr);
                editor.putString("profile_firstname", F_nameStr);
                editor.putString("profile_EmailAddress", EmailStr);
                editor.putString("profile_lastname", L_nameStr);
                editor.putString("profile_middlename", M_nameStr);
                editor.apply();



            }

        });


    }}







