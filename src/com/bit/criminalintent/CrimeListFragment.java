package com.bit.criminalintent;

import java.util.ArrayList;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class CrimeListFragment extends ListFragment {//控制器层，处理List列表视图和Crimes容器的fragment，继承自ListFragment
	private static final String TAG = "CrimeListFragment";
	private ArrayList<Crime> mCrimes;

	@Override
	public void onCreate(Bundle savedInstanceState) {//创建列表支配器
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.crime_title);
		mCrimes=CrimeLab.get(getActivity()).getCrimes();//获取单例
		
		/*ArrayAdapter<Crime> adapter=new ArrayAdapter<Crime>(//列表支配器 使用默认的ArrayAdapter类创建
				getActivity(),android.R.layout.simple_list_item_1,mCrimes);*/
		CrimeAdapter adapter= new CrimeAdapter(mCrimes);//使用新定义的CrimeAdapter创建
		setListAdapter(adapter);
		
	}
	@Override
	public void onListItemClick(ListView l,View v,int position,long id){//响应点击事件
		//Crime c= (Crime)(getListAdapter()).getItem(position);
		Crime c=((CrimeAdapter)getListAdapter()).getItem(position);
		Log.d(TAG, c.getTitle()+" was clicked");
	}
	private class CrimeAdapter extends ArrayAdapter<Crime>{//内部类重新定义列表视图和视图与Crime对象的关系，继承自ArrayAdapter
		public CrimeAdapter(ArrayList<Crime> crimes){ //构造函数与父类相同
			super(getActivity(), 0,crimes);
		}
		@Override
		public View getView(int position,View convertView,ViewGroup parent){//重写getview方法，修改返回的 视图
			if(convertView==null){
				convertView=getActivity().getLayoutInflater()
						.inflate(R.layout.list_item_crime, null);//利用编写的xml布局
			}
			
			Crime c=getItem(position);
			
			//如何对应布局和Crime类
			TextView titleTV=(TextView) convertView.findViewById(R.id.crime_list_item_titleTextView);
			titleTV.setText(c.getTitle());
			TextView dataTV=(TextView) convertView.findViewById(R.id.crime_list_item_dateTextView);
			dataTV.setText(c.getDate().toString());
			CheckBox solvedCB=(CheckBox)(TextView) convertView.findViewById(R.id.crime_list_item_sCheckBox);
			solvedCB.setChecked(c.isSolved());
			
			return convertView;
		}
	}

}
