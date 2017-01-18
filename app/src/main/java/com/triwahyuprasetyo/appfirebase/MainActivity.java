package com.triwahyuprasetyo.appfirebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mRef1,mRef2,mRef3;
    private Button buttonAddValue1,buttonAddValue2, btPost;
    private EditText editTextValue, etKey,etValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRef1 = FirebaseDatabase.getInstance().getReferenceFromUrl("https://appfirebase-2fd28.firebaseio.com");
        mRef2 = FirebaseDatabase.getInstance().getReferenceFromUrl("https://appfirebase-2fd28.firebaseio.com/Users");

        editTextValue= (EditText) findViewById(R.id.editTextValue);
        buttonAddValue1 = (Button) findViewById(R.id.btAddVal);
        buttonAddValue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value=editTextValue.getText().toString();
                DatabaseReference dbR = mRef1.child("Name");
                dbR.setValue(value);
            }
        });
        buttonAddValue2 = (Button) findViewById(R.id.btAddVal2);
        buttonAddValue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value=editTextValue.getText().toString();
                DatabaseReference dbR = mRef2.child("Age");
                dbR.setValue(value);
            }
        });

        etKey= (EditText) findViewById(R.id.etKey);
        etValue= (EditText) findViewById(R.id.etValue);
        btPost= (Button) findViewById(R.id.buttonPost);
        btPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key=etKey.getText().toString();
                String value=etValue.getText().toString();
                DatabaseReference dbR = mRef2.child(key);
                dbR.setValue(value);
            }
        });
    }
}
