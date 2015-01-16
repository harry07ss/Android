package com.bit.criminalintent;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;


public class CrimeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);
        
        FragmentManager fm =getFragmentManager(); //��ù�����
        Fragment fragment=fm.findFragmentById(R.id.fragmentContainer);//�󶨵���Ӧ��������
        
        if(fragment==null){//һ��fragment����
        	fragment=new CrimeFragment();
        	fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        }
    }




}
