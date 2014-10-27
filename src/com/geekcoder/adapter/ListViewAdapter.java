package com.geekcoder.adapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.geekcoder.R;

public class ListViewAdapter extends BaseAdapter {
	
	private Context context;
	private List<Map<String, Object>> data;
	//用于优化ListView的静态类，通过缓存的方式
	static class ViewHolder{
		ImageView image;
		TextView title;
		TextView description;
	}
	public ListViewAdapter(Context context, List<Map<String, Object>> data) {
		this.context = context;
		this.data = data;
	}
	
	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if(convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.item, null);
			holder.image = (ImageView)convertView.findViewById(R.id.image);
			holder.title = (TextView)convertView.findViewById(R.id.title);
			holder.description = (TextView)convertView.findViewById(R.id.description);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.image.setBackgroundResource((Integer)data.get(position).get("img"));
		holder.title.setText((String)data.get(position).get("title"));
		holder.description.setText((String)data.get(position).get("description"));
		return convertView;
	}
	
}
