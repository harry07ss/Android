package com.bit.criminalintent;


import java.util.UUID;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;


public class CrimeActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {		
		//return new CrimeFragment();//ʹ��ԭ���Ĺ��췽������CrimeFragment
		UUID crimeId=(UUID)getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
		return CrimeFragment.newInstance(crimeId);//ʹ�ô�intent������Id����CrimeFragment��
	}

 
   



}
