package com.bit.criminalintent;


import java.util.UUID;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;


public class CrimeActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {		
		//return new CrimeFragment();//使用原本的构造方法生成CrimeFragment
		UUID crimeId=(UUID)getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
		return CrimeFragment.newInstance(crimeId);//使用从intent传来的Id创建CrimeFragment；
	}

 
   



}
