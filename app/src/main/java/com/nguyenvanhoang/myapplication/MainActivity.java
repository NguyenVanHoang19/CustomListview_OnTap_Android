package com.nguyenvanhoang.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listViewContry;
    private List<Contry> contryList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contryList = new ArrayList<>();
        contryList.add(new Contry("Viet Nam","c1",1));
        contryList.add(new Contry("Viet Nam","c6",2));
        contryList.add(new Contry("Viet Nam","c8",3));
        contryList.add(new Contry("Viet Nam","d4",4));

        listViewContry = (ListView) findViewById(R.id.listViewCustom);
        CustomListAdapter adapter = new CustomListAdapter(this,contryList);
        listViewContry.setAdapter(adapter);
        adapter.notifyDataSetChanged();
     //   listViewContry.setSelector(R.drawable.list_selector);
        listViewContry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Contry: " + contryList.get(i),Toast.LENGTH_LONG).show();
            }
        });
        TextView tv = (TextView) findViewById(R.id.textView);
        registerForContextMenu(tv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Chon tên");
        menu.add(0,v.getId(),0,"Hoa lan");
        menu.add(0,v.getId(),0,"Hoa Hong");
        menu.add(0,v.getId(),0,"Hoa Mai");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Toast.makeText(MainActivity.this,"Da chon: " + item.getTitle(),Toast.LENGTH_LONG).show();
        return true;
    }
}