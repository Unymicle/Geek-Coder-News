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
            map.put("image",R.drawable.test);
            map.put("title", "�й�δ�Ͽ������20�����а�");
            map.put("description", "20��������ӡ��ռһ�룻�������36λ��������76λ��");
            listitems.add(map);
        }
          
         SimpleAdapter simpleAdapter=new SimpleAdapter(
                 getActivity(),
                 listitems,
                 R.layout.item,
                 new String[]{"image","title","description"}, 
                 new int[]{R.id.image, R.id.title,R.id.description});
         listview.setAdapter(simpleAdapter);
         //����listview�е�ÿһ���б�����õ������¼�������
         listview.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				//�˴�������position�ж�����һ������
				Toast.makeText(getActivity().getApplicationContext(), "��"+position+"���б����������", Toast.LENGTH_SHORT).show();
				//����Activity����ת
				Intent intent = new Intent();
				intent.setClass(getActivity().getApplicationContext(), NewsDetailActivity.class);
				startActivity(intent);
			}
         });
         return rootView;
    }
}
