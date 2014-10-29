package com.geekcoder.fragment;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import com.example.geekcoder.R;
import com.geekcoder.activity.NewsDetailActivity;
import com.geekcoder.adapter.ListViewAdapter;
import com.geekcoder.widget.AutoListView;
import com.geekcoder.widget.AutoListView.OnLoadListener;
import com.geekcoder.widget.AutoListView.OnRefreshListener;

public class TestFragment extends Fragment implements OnRefreshListener,OnLoadListener {
	
	private AutoListView lstv;
	private ListViewAdapter adapter;
	private List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			List<Map<String, Object>> result = (List<Map<String, Object>>) msg.obj;
			switch (msg.what) {
			case AutoListView.REFRESH:
				lstv.onRefreshComplete();
				list.clear();
				list.addAll(result);
				break;
			case AutoListView.LOAD:
				lstv.onLoadComplete();
				list.addAll(result);
				break;
			}
			lstv.setResultSize(result.size());
			adapter.notifyDataSetChanged();
		};
	};
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
    	View rootView = inflater.inflate(R.layout.fragment, container, false);
		lstv = (AutoListView) rootView.findViewById(R.id.lstv);
		adapter = new ListViewAdapter(getActivity(), list);
		lstv.setAdapter(adapter);
		lstv.setOnRefreshListener(this);
		lstv.setOnLoadListener(this);
		initData();
        //����listview�е�ÿһ���б�����õ������¼�������
        lstv.setOnItemClickListener(new OnItemClickListener(){
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
    
	private void initData() {
		loadData(AutoListView.REFRESH);
	}

	private void loadData(final int what) {
		// 这里模拟从服务器获取数据
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(700);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Message msg = handler.obtainMessage();
				msg.what = what;
				msg.obj = getData();
				handler.sendMessage(msg);
			}
		}).start();
	}

	@Override
	public void onRefresh() {
		loadData(AutoListView.REFRESH);
	}

	@Override
	public void onLoad() {
		loadData(AutoListView.LOAD);
	}

	// ��ȡ���Ե�����
	public List<Map<String, Object>> getData() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			long l = random.nextInt(10000);
			map.put("thumbImage", R.drawable.test);
			map.put("newsTitle", "���Ե����ű���" + l);
			map.put("newsSummary", "��������ժҪ" + l);
			result.add(map);
		}
		return result;
	}
}
