package com.emily.userinfo_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //绑定layout里面的ListView
        ListView list=this.findViewById(R.id.ListView01);
        //生成动态数组
        ArrayList<HashMap<String,Object>> listItem=new ArrayList<HashMap<String,Object>>();
        for(int i=0;i<10;i++){
            HashMap<String,Object> map=new HashMap<String, Object>();
            map.put("ItemImage",R.drawable.bt1);
            map.put("ItemTitle","Level"+i);
            map.put("ItemText","Finish in Min 54 Secs,70 Moves!");
            listItem.add(map);
        }
        SimpleAdapter listItemAdapter=new SimpleAdapter(this,listItem,R.layout.items,new String[]{"ItemTitle","ItemText","ItemImage"},
                new int[]{R.id.ItemTitle,R.id.ItemText,R.id.ItemImage});
        //添加并且显示
        list.setAdapter(listItemAdapter);
        //添加点击
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setTitle("单击第"+position+"个项目");
            }
        });
        //添加长按单击
        list.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                menu.setHeaderTitle("长按菜单");
                menu.add(0,0,0,"弹出长按菜单0");
                menu.add(0,1,0,"弹出长按菜单1");

            }
        });
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        setTitle("单击长按菜单里面的第"+item.getItemId()+"个项目");
        return super.onContextItemSelected(item);
    }

}
