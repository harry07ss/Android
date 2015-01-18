package com.bit.criminalintent;

import java.util.ArrayList;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class CrimeListFragment extends ListFragment {//�������㣬����List�б���ͼ��Crimes������fragment���̳���ListFragment
	private static final String TAG = "CrimeListFragment";
	private ArrayList<Crime> mCrimes;

	@Override
	public void onCreate(Bundle savedInstanceState) {//�����б�֧����
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		getActivity().setTitle(R.string.crime_title);
		mCrimes=CrimeLab.get(getActivity()).getCrimes();//��ȡ����
		
		/*ArrayAdapter<Crime> adapter=new ArrayAdapter<Crime>(//�б�֧���� ʹ��Ĭ�ϵ�ArrayAdapter�ഴ��
				getActivity(),android.R.layout.simple_list_item_1,mCrimes);*/
		CrimeAdapter adapter= new CrimeAdapter(mCrimes);//ʹ���¶����CrimeAdapter����
		setListAdapter(adapter);
		
	}
	@Override
	public void onListItemClick(ListView l,View v,int position,long id){//��Ӧ����¼�
		//Crime c= (Crime)(getListAdapter()).getItem(position);
		Crime c=((CrimeAdapter)getListAdapter()).getItem(position);
		Log.d(TAG, c.getTitle()+" was clicked");
		 //
		//Intent i =new Intent(getActivity(),CrimeActivity.class);
		Intent i =new Intent(getActivity(),CrimePagerActivity.class);
		i.putExtra(CrimeFragment.EXTRA_CRIME_ID, c.getId());
		startActivity(i);
	}
	
	@Override
	public void onResume(){
		super.onResume();
		((CrimeAdapter)getListAdapter()).notifyDataSetChanged();
	}
	
	
	private class CrimeAdapter extends ArrayAdapter<Crime>{//�ڲ������¶����б���ͼ����ͼ��Crime����Ĺ�ϵ���̳���ArrayAdapter
		public CrimeAdapter(ArrayList<Crime> crimes){ //���캯���븸����ͬ
			super(getActivity(), 0,crimes);
		}
		@Override
		public View getView(int position,View convertView,ViewGroup parent){//��дgetview�������޸ķ��ص� ��ͼ
			if(convertView==null){
				convertView=getActivity().getLayoutInflater()
						.inflate(R.layout.list_item_crime, null);//���ñ�д��xml����
			}
			
			Crime c=getItem(position);
			
			//��ζ�Ӧ���ֺ�Crime��
			TextView titleTV=(TextView) convertView.findViewById(R.id.crime_list_item_titleTextView);
			titleTV.setText(c.getTitle());
			TextView dataTV=(TextView) convertView.findViewById(R.id.crime_list_item_dateTextView);
			dataTV.setText(c.getDate().toString());
			CheckBox solvedCB=(CheckBox)(TextView) convertView.findViewById(R.id.crime_list_item_sCheckBox);
			solvedCB.setChecked(c.isSolved());
			
			return convertView;
		}
		
		
	}


	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.fragment_crime_list, menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		
		switch (item.getItemId()){
		case R.id.menu_item_new_crime:
			Crime crime=new Crime();
			CrimeLab.get(getActivity()).addCrime(crime);
			Intent i =new Intent(getActivity(),CrimePagerActivity.class);
			i.putExtra(CrimeFragment.EXTRA_CRIME_ID, crime.getId());
			startActivityForResult(i,0);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	
	


    
}
