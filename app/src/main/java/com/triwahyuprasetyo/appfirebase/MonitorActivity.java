package com.triwahyuprasetyo.appfirebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MonitorActivity extends AppCompatActivity {

    private TextView tvMonitor;
    private DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);
        tvMonitor = (TextView) findViewById(R.id.textViewMonitor);
        mRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://appfirebase-2fd28.firebaseio.com/Monitor");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String snapshoot = dataSnapshot.getValue(String.class);
                tvMonitor.setText(snapshoot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
