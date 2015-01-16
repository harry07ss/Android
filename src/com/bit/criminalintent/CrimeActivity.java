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
        
        FragmentManager fm =getFragmentManager(); //获得管理器
        Fragment fragment=fm.findFragmentById(R.id.fragmentContainer);//绑定到对应的容器中
        
        if(fragment==null){//一个fragment事务
        	fragment=new CrimeFragment();
        	fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        }
    }




}
