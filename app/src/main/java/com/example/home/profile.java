package com.example.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profile extends AppCompatActivity {
    //profile edite text
    public EditText profile_address, profile_Phone, profile_middlename, profile_firstname, profile_EmailAddress, profile_lastname;

    public Button profile_save_btn, profile_edite_btn;



    SharedPreferences sp;

    // creating a variable for our
    // Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;

    // creating a variable for
    // our object class
    EmployeeInfo employeeInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        sp = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences sp = getApplicationContext().getSharedPreferences("prefs", Context.MODE_PRIVATE);
        // initializing our edittext and button
        profile_Phone= findViewById(R.id.profile_Phone);
        profile_address = findViewById(R.id.profile_address);
        profile_middlename = findViewById(R.id.profile_middlename);
        profile_firstname = findViewById(R.id.profile_firstname);
        profile_EmailAddress = findViewById(R.id.profile_EmailAddress);
        profile_lastname = findViewById(R.id.profile_lastname);
        profile_save_btn = findViewById(R.id.profile_save_btn);
        profile_edite_btn = findViewById(R.id.profile_edite_btn);

        // below line is used to get the
        // instance of our FIrebase database.
        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase.getReference("EmployeeInfo");

        // initializing our object
        // class variable.

        employeeInfo = new EmployeeInfo();





        //retrieve data o sharedprefre
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

          int  pho= sp.getInt("profile_Phone", 0);
          profile_Phone.setId(pho);

        // adding on click listener for our button.
        profile_save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting text from our edittext fields.
                int phone = Integer.parseInt(profile_Phone.getText().toString());
                String address = profile_address.getText().toString();
                String mname = profile_middlename.getText().toString();
                String fname = profile_firstname.getText().toString();
                String email = profile_EmailAddress.getText().toString();
                String lname = profile_lastname.getText().toString();



                    // data to our database.
                    addDatatoFirebase(fname,mname,lname, phone, address,email);


                //save data to user

                SharedPreferences.Editor editor = sp.edit();

                editor.putInt("profile_Phone", phone);
                editor.putString("profile_address", address);
                editor.putString("profile_firstname", fname);
                editor.putString("profile_EmailAddress", email);
                editor.putString("profile_lastname", lname);
                editor.putString("profile_middlename", mname);
                editor.apply();








            }
        });
    }

    private void addDatatoFirebase(String fname, String mname, String lname, int phone, String address,String email) {
        // below 3 lines of code is used to set
        // data in our object class.
        employeeInfo.setEmployeeFName(fname);
        employeeInfo.setEmployeeMName(mname);
        employeeInfo.setEmployeeLName(lname);
        employeeInfo.setEmployeeContactNumber(phone);
        employeeInfo.setEmployeeAddress(address);
        employeeInfo.setEmployeeEmail(email);
        // we are use add value event listener method
        // which is called with database reference.
        databaseReference.addValueEventListener(new ValueEventListener() {

            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // inside the method of on Data change we are setting
                // our object class to our database reference.
                // data base reference will sends data to firebase.
                databaseReference.setValue(employeeInfo);

                // after adding this data we are showing toast message.
                Toast.makeText(profile.this, "data added", Toast.LENGTH_SHORT).show();
            }


            public void onCancelled(@NonNull DatabaseError error) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                Toast.makeText(profile.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }

}






