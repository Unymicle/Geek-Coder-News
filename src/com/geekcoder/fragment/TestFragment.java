package com.geekcoder.fragment;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.geekcoder.R;
import com.geekcoder.activity.NewsDetailActivity;

public class TestFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
    	View rootView = inflater.inflate(R.layout.guide_2, container, false);
        ListView listview = (ListView) rootView.findViewById(R.id.lv);
        List<Map<String,Object>> listitems=new ArrayList<Map<String,Object>>();
         for (int i = 0; i < 50; i++) {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("image",R.drawable.ic_launcher);
            map.put("title", "测试标题");
            map.put("description", "测试的新闻描述");
            listitems.add(map);
        }
          
         SimpleAdapter simpleAdapter=new SimpleAdapter(
                 getActivity(),
                 listitems,
                 R.layout.item,
                 new String[]{"image","title","description"}, 
                 new int[]{R.id.image, R.id.title,R.id.description});
         listview.setAdapter(simpleAdapter);
         //对于listview中的每一个列表项，设置单击的事件监听器
         listview.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				//此处，根据position判断是哪一项被点击了
				Toast.makeText(getActivity().getApplicationContext(), "第"+position+"个列表项被您单击了", Toast.LENGTH_SHORT).show();
				//进行Activity的跳转
				Intent intent = new Intent();
				intent.setClass(getActivity().getApplicationContext(), NewsDetailActivity.class);
				startActivity(intent);
			}
         });
         return rootView;
    }
}
