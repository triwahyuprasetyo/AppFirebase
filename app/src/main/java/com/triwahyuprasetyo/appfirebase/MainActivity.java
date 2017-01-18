package com.triwahyuprasetyo.appfirebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    DatabaseReference mRef;
    private Button buttonAddValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://appfirebase-2fd28.firebaseio.com/");
        buttonAddValue = (Button) findViewById(R.id.btAddVal);

        buttonAddValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference dbR = mRef.child("Name");
                dbR.setValue("Wahyu");
            }
        });
    }
}
