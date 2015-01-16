package com.bit.criminalintent;

import java.util.ArrayList;
import java.util.UUID;

import android.content.Context;

public class CrimeLab {//ģ�Ͳ�����࣬��Crime���һ������ ����ֻ��һ����̬�Ե���
	private ArrayList<Crime> mCrimes;//����Crime��List����
	private static CrimeLab sCrimeLab; //�������÷�����̬�����
	private Context mAppContext;//���������Ĳ������Կ���activity
	
	private CrimeLab(Context appContex){//�����÷����������캯������ȡ������
		mAppContext=appContex;
		mCrimes=new ArrayList<Crime>();
		for(int i=0;i<100;i++){//Crime����ĳ�ʼ�������޸�
			Crime c =new Crime();
			c.setTitle("Crime #"+i);
			c.setSolved(i%2==0);
			mCrimes.add(c);
		}
	}
	public static CrimeLab get(Context c){//get�������ڷ���CrimeLab�������������������캯��
		if(sCrimeLab==null){
			sCrimeLab=new CrimeLab(c.getApplicationContext());
		}
		return sCrimeLab;
	}
	public ArrayList<Crime> getCrimes() {//������������
		return mCrimes;
	}
	
	public Crime getCrime(UUID id) {//����ID���������ص���Crime����
		for(Crime c : mCrimes){
			if(c.getId().equals(id)){
				return c;
			}
		}
		return null;
	}
	
}
