package com.aakash.recycleviewsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,ad,phone,bg;
    Button insert,view;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        ad = findViewById(R.id.ad);
        phone = findViewById(R.id.phone);
        bg = findViewById(R.id.bg);
        insert = findViewById(R.id.btnInsert);
        view = findViewById(R.id.btnView);
        DB = new DBHelper(this);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Userlist.class));
            }
        });
        
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String adTXT = ad.getText().toString();
                String phoneTXT = phone.getText().toString();
                String bgTXT = bg.getText().toString();
                
                Boolean checkinsertdata = DB.insertuserdata(nameTXT,adTXT,phoneTXT,bgTXT);
                if (checkinsertdata==true)
                {
                    Toast.makeText(MainActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}