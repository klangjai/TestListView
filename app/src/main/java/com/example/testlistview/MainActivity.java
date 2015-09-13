package com.example.testlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    /*
    final String[] colors = {
            "red", "green", "blue", "yellow", "black", "white"
    };
    */

    private ArrayList<HashMap<String,Object>> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        HashMap<String,Object> map = new HashMap<>();
        map.put("image",android.R.drawable.ic_menu_camera);
        map.put("text","aaa");
        dataList.add(map);

        map = new HashMap<>();
        map.put("image",android.R.drawable.ic_menu_add);
        map.put("text","bbb");
        dataList.add(map);


        map = new HashMap<>();
        map.put("image",android.R.drawable.ic_menu_delete);
        map.put("text","cc");
        dataList.add(map);
       /* ArrayAdapter<String> color = new ArrayAdapter<String>(
                this,
                R.layout.item,
                R.id.color_name,
                colors);
        list.setAdapter(color);
        */
        ListView list = (ListView) findViewById(R.id.listView);
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                dataList,
                R.layout.item,
                new String[]{"image","text"},
                new int[]{R.id.item_image,R.id.item_text}
        );
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String,Object> map = dataList.get(position);
                String text = map.get("text").toString();
                String msg = "You Selected "+text;
                Toast.makeText(
                        MainActivity.this,
                        msg,Toast.LENGTH_LONG
                ).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
