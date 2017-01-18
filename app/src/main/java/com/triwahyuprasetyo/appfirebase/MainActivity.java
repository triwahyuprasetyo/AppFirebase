package com.triwahyuprasetyo.appfirebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mRef;
    private Button buttonAddValue1,buttonAddValue2;
    private EditText editTextValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextValue= (EditText) findViewById(R.id.editTextValue);
        buttonAddValue1 = (Button) findViewById(R.id.btAddVal);
        buttonAddValue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://appfirebase-2fd28.firebaseio.com");
                String value=editTextValue.getText().toString();
                DatabaseReference dbR = mRef.child("Name");
                dbR.setValue(value);
            }
        });
        buttonAddValue2 = (Button) findViewById(R.id.btAddVal2);
        buttonAddValue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://appfirebase-2fd28.firebaseio.com/Users");
                String value=editTextValue.getText().toString();
                DatabaseReference dbR = mRef.child("Age");
                dbR.setValue(value);
            }
        });
    }
}
