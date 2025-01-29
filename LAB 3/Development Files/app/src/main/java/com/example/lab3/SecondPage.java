package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SecondPage extends AppCompatActivity {

    ListView ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        ls=findViewById(R.id.ls_dt);
        String[] lv_item = getResources().getStringArray(R.array.menu);
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, R.layout.layout, lv_item);
        ls.setAdapter(adapt);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                TextView tv=(TextView) view;
                String str=tv.getText().toString();
                switch (position)
                {
                    case 0:
                        startActivity(new Intent(SecondPage.this,Third.class));
                        break;
                    case 1:
                        str = "tel: " +str;
                        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(str)));
                        break;
                    case 2:
                        Linkify.addLinks(tv, Linkify.EMAIL_ADDRESSES);
                        break;
                    case 3:
                        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.google.co.in")));
                        break;
                    case 4:
                        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.tutorialpoint.com/android")));
                        break;


                }
            }
        });


    }
}