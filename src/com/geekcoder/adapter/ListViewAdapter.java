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

	private ViewHolder holder;
	private List<Map<String, Object>> list;
	private Context context;

	public ListViewAdapter(Context context, List<Map<String, Object>> list) {
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {
		return list.size();
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
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(
					R.layout.listview_item, null);
			holder.thumbImage = (ImageView) convertView.findViewById(R.id.thumb_image);
			holder.newsTitle = (TextView) convertView.findViewById(R.id.news_title);
			holder.newsSummary = (TextView) convertView.findViewById(R.id.news_summary);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.thumbImage.setBackgroundResource((Integer)list.get(position).get("thumbImage"));
		holder.newsTitle.setText((String)list.get(position).get("newsTitle"));
		holder.newsSummary.setText((String)list.get(position).get("newsSummary"));
		return convertView;
	}

	private static class ViewHolder {
		ImageView thumbImage;
		TextView newsTitle;
		TextView newsSummary;
	}

}
