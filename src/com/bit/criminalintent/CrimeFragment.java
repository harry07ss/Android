package com.bit.criminalintent;

import java.util.Date;
import java.util.UUID;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
	private static final String DIALOG_DATE="date";
	private static final int REQUET_DATE=0;
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
    public void updateDate() {
        mDateButton.setText(mCrime.getDate().toString());
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
		updateDate();
		//mDateButton.setEnabled(false);
		mDateButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FragmentManager fm =getActivity().getSupportFragmentManager();
				//DatePickerFragment dialog =new DatePickerFragment();
				DatePickerFragment dialog=DatePickerFragment.newInstance(mCrime.getDate());
				dialog.setTargetFragment(CrimeFragment.this, REQUET_DATE);
				dialog.show(fm, DIALOG_DATE);
				
			}
		});
		
		
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
	
	@Override
	 public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) return;
        if (requestCode == REQUET_DATE) {
            Date date = (Date)data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            mCrime.setDate(date);
            updateDate();
        }
    }
	

}
