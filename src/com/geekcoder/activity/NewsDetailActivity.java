package com.geekcoder.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.geekcoder.R;

public class NewsDetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_newsdetail);
		//�˴���ʱδ��ɣ������ڽ���ģ��(��һ����mock����ʵ�����л�������,��������ʵ����)
		TextView newsTitle = (TextView)findViewById(R.id.news_title);
		TextView newsReleaseTime = (TextView)findViewById(R.id.news_release_time);
		TextView newsContent = (TextView)findViewById(R.id.news_content);
		newsTitle.setText("���ƺ��������Ż��������Ĺ��ޣ�");
		newsReleaseTime.setText("10��27�� 07:10");
		newsContent.setText("�й��ƶ��밢��Ͱ;ͷ��Ž�չ�������������Ϣ������Ѷ����������¶�ģ�����ӹ���ɣ�������������ɣ������˵Ŀ϶�����Ѷ�����ԣ������Ϣ���ع��е������˼����ζ�����������Ĺ���������Ķ�����֣��ѵ��������Ҳ���ع������й��ƶ��밢��Ͱ͵ĺ�����һ���Ļ��������ڼ���������Ŀ����ԣ�һ��˫���ŵ����ԣ�����Ͱ����ո��������ʱ��г�����ʷ�����IPO��¼�����У��й��ƶ��ǵ��ʲ��õ�ͨ���г����ߣ�˫���ĺ����ǵ��͵�ǿǿ���ϡ������й��ƶ��밢��Ͱ���ҵ���ϵ�ֱ�Ӿ��������࣬����Դ����������֮���ͬʱ���棬��Ҳ��˫���ܹ�̹��������Ϻ���������˫���Ĺ�ͬ���ֶ�����Ѷ����Ѷ������ȫҵ�����밢��Ͱ��г�ͻ���й��ƶ���������Ѷ��΢�ŵ�OTTҵ��ĳ���¼���Ҫ�����ɾ���˫���ĺ��������ڶԿ���ͬ�Ķ��֡�");
	}

}
