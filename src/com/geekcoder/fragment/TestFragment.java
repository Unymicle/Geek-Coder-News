package com.geekcoder.fragment;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.geekcoder.R;

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
         return rootView;
    }
}
