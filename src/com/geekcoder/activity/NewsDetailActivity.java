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
		//此处暂时未完成，仅用于界面模拟(下一步用mock数据实现所有基本功能,后期用真实数据)
		TextView newsTitle = (TextView)findViewById(R.id.news_title);
		TextView newsReleaseTime = (TextView)findViewById(R.id.news_release_time);
		TextView newsContent = (TextView)findViewById(R.id.news_content);
		newsTitle.setText("阿移合作，飞信会变成怎样的怪兽？");
		newsReleaseTime.setText("10月27日 07:10");
		newsContent.setText("中国移动与阿里巴巴就飞信将展开合作的这个消息是由腾讯方面率先披露的，而毋庸置疑，如果这个合作达成，最受伤的肯定是腾讯。所以，这个消息的曝光有点匪夷所思且意味深长。按照网络的管理，秀恩爱的都会分手，难道这个合作也会曝光死？中国移动与阿里巴巴的合作有一定的基础，存在继续深化合作的可能性：一是双方门当户对，阿里巴巴如今刚刚在美国资本市场创造史上最大IPO记录而上市，中国移动是当仁不让的通信市场王者，双方的合作是典型的强强联合。二是中国移动与阿里巴巴在业务上的直接竞争并不多，且资源互补，合作之后会同时受益，这也让双方能够坦诚相待精诚合作。三是双方的共同对手都是腾讯，腾讯几乎在全业务上与阿里巴巴有冲突，中国移动更是在腾讯的微信等OTT业务的冲击下几乎要溃不成军，双方的合作有利于对抗共同的对手。");
	}

}
