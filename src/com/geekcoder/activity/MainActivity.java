package com.geekcoder.activity;

import java.util.ArrayList;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geekcoder.R;
import com.geekcoder.adapter.MyFragmentPagerAdapter;
import com.geekcoder.fragment.TestFragment;

public class MainActivity extends FragmentActivity {
	private ViewPager viewPager;
	private ArrayList<Fragment> fragmentList;
	private ImageView image;
	private TextView headline;
	private TextView hotpoint;
	private TextView entertainment;
	private TextView sport;
	private TextView technology;
	private int currIndex;//��ǰҳ�����
	private int bmpW;//����ͼƬ���
	private int offset;//ͼƬ�ƶ���ƫ����

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		InitTextView();
		InitImage();
		InitViewPager();
	}
	
	
	/*
	 * ��ʼ����ǩ��
	 */
	public void InitTextView(){
		headline = (TextView)findViewById(R.id.headline);
		hotpoint = (TextView)findViewById(R.id.hotpoint);
		entertainment = (TextView)findViewById(R.id.entertainment);
		sport = (TextView)findViewById(R.id.sport);
		technology = (TextView)findViewById(R.id.technology);
		
		headline.setOnClickListener(new txListener(0));
		hotpoint.setOnClickListener(new txListener(1));
		entertainment.setOnClickListener(new txListener(2));
		sport.setOnClickListener(new txListener(3));
		technology.setOnClickListener(new txListener(4));
	}
	
	
	public class txListener implements View.OnClickListener{
		private int index=0;
		
		public txListener(int i) {
			index =i;
		}
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			viewPager.setCurrentItem(index);
		}
	}
	
	
	/*
	 * ��ʼ��ͼƬ��λ������
	 */
	public void InitImage(){
		image = (ImageView)findViewById(R.id.cursor);
		bmpW = BitmapFactory.decodeResource(getResources(), R.drawable.cursor).getWidth();
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenW = dm.widthPixels;
		offset = (screenW/5 - bmpW)/2;
		
		//imgageview����ƽ�ƣ�ʹ�»���ƽ�Ƶ���ʼλ�ã�ƽ��һ��offset��
		Matrix matrix = new Matrix();
		matrix.postTranslate(offset, 0);
		image.setImageMatrix(matrix);
	}
	
	/*
	 * ��ʼ��ViewPager
	 */
	public void InitViewPager(){
		viewPager = (ViewPager)findViewById(R.id.viewpager);
		fragmentList = new ArrayList<Fragment>();
		Fragment firstFragment = new TestFragment();
		Fragment secondFragment = new TestFragment();
		Fragment thirdFragment = new TestFragment();
		Fragment fourthFragment = new TestFragment();
		Fragment fifthFragment = new TestFragment();
		fragmentList.add(firstFragment);
		fragmentList.add(secondFragment);
		fragmentList.add(thirdFragment);
		fragmentList.add(fourthFragment);
		fragmentList.add(fifthFragment);
		
		//��ViewPager����������
		viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList));
		viewPager.setCurrentItem(0);//���õ�ǰ��ʾ��ǩҳΪ��һҳ
		headline.setTextColor(Color.parseColor("#f65050"));
		hotpoint.setTextColor(Color.parseColor("#999999"));
		entertainment.setTextColor(Color.parseColor("#999999"));
		sport.setTextColor(Color.parseColor("#999999"));
		technology.setTextColor(Color.parseColor("#999999"));
		viewPager.setOnPageChangeListener(new MyOnPageChangeListener());//ҳ��仯ʱ�ļ�����
	}

	
	public class MyOnPageChangeListener implements OnPageChangeListener{
		private int one = offset *2 +bmpW;//��������ҳ���ƫ����
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			Animation animation = new TranslateAnimation(currIndex*one,arg0*one,0,0);//ƽ�ƶ���
			currIndex = arg0;
			animation.setFillAfter(true);//������ֹʱͣ�������һ֡����Ȼ��ص�û��ִ��ǰ��״̬
			animation.setDuration(200);//��������ʱ��0.2��
			image.startAnimation(animation);//����ImageView����ʾ������
			int i = currIndex + 1;
			switch(currIndex){
				case 0:
					headline.setTextColor(Color.parseColor("#f65050"));
					hotpoint.setTextColor(Color.parseColor("#999999"));
					entertainment.setTextColor(Color.parseColor("#999999"));
					sport.setTextColor(Color.parseColor("#999999"));
					technology.setTextColor(Color.parseColor("#999999"));
					break;
				case 1:
					headline.setTextColor(Color.parseColor("#999999"));
					hotpoint.setTextColor(Color.parseColor("#f65050"));
					entertainment.setTextColor(Color.parseColor("#999999"));
					sport.setTextColor(Color.parseColor("#999999"));
					technology.setTextColor(Color.parseColor("#999999"));
					break;
				case 2:
					headline.setTextColor(Color.parseColor("#999999"));
					hotpoint.setTextColor(Color.parseColor("#999999"));
					entertainment.setTextColor(Color.parseColor("#f65050"));
					sport.setTextColor(Color.parseColor("#999999"));
					technology.setTextColor(Color.parseColor("#999999"));
					break;
				case 3:
					headline.setTextColor(Color.parseColor("#999999"));
					hotpoint.setTextColor(Color.parseColor("#999999"));
					entertainment.setTextColor(Color.parseColor("#999999"));
					sport.setTextColor(Color.parseColor("#f65050"));
					technology.setTextColor(Color.parseColor("#999999"));
					break;
				case 4:
					headline.setTextColor(Color.parseColor("#999999"));
					hotpoint.setTextColor(Color.parseColor("#999999"));
					entertainment.setTextColor(Color.parseColor("#999999"));
					sport.setTextColor(Color.parseColor("#999999"));
					technology.setTextColor(Color.parseColor("#f65050"));
					break;
			}
			Toast.makeText(MainActivity.this, "��ѡ���˵�"+i+"��ҳ��", Toast.LENGTH_SHORT).show();
		}
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}