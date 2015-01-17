package com.bit.criminalintent;

import java.util.UUID;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
/**
 *控制器部分完成界面到数据的过程 
 *CrimeFragment 完成“创建Crime”界面 和创建对应Crime对象
 * @author zhili
 * @version 1.0.0
 */
public class CrimeFragment extends Fragment {
	public static final String EXTRA_CRIME_ID="com.bit.android.crime_id";
	private Crime mCrime;
	private EditText mTitleField;
	private Button mDateButton;
	private CheckBox mSolvedCheckBox;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//UUID crimeId=(UUID)getActivity().getIntent().getSerializableExtra(EXTRA_CRIME_ID);
		UUID crimeId=(UUID)getArguments().getSerializable(EXTRA_CRIME_ID);
		mCrime=CrimeLab.get(getActivity()).getCrime(crimeId);
	}
/**
 * 关联视图
 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.fragment_crime,parent,false);
		
		mTitleField=(EditText)v.findViewById(R.id.crime_title);
		mTitleField.setText(mCrime.getTitle());
		mTitleField.addTextChangedListener(new TextWatcher(){//监听的设置
			public void onTextChanged(
					CharSequence c,int start,int before,int count){
				mCrime.setTitle(c.toString());
			}
			
			public void beforeTextChanged(
					CharSequence c,int start,int count,int before){
				//space
			}
			
			public void afterTextChanged(Editable c){
				//space
			}
		});
		
		mDateButton=(Button)v.findViewById(R.id.crime_date);
		mDateButton.setText(mCrime.getDate().toString());
		mDateButton.setEnabled(false);
		
		mSolvedCheckBox=(CheckBox)v.findViewById(R.id.crime_solved);
		mSolvedCheckBox.setChecked(mCrime.isSolved());
		mSolvedCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener(){
			public void  onCheckedChanged(CompoundButton buttonView,boolean isChecked){
				mCrime.setSolved(isChecked);
				}
		});
		return v;
	}
	/**
	 * 用于替代Fragment的构造方法，根据CrimeLab内的Id号创建对应的Fragment
	 * @param crimeId 
	 * @return CrimeFragment
	 * 在对应的activity里调用
	 */
	public static CrimeFragment newInstance(UUID crimeId){
		Bundle args =new Bundle();
		args.putSerializable(EXTRA_CRIME_ID, crimeId);
		
		CrimeFragment fragment=new CrimeFragment();
		fragment.setArguments(args);
		
		return fragment;
	}


}
