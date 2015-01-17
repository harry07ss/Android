package com.bit.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {//ģ�Ͳ�������
	private UUID mId;//ID��
	private String mTitle;//����
	private Date mDate;//����
	private boolean mSolved;//һ���Ƿ�����ѡ��
	private String Tag;
	public Crime(){
		mId=UUID.randomUUID();
		mDate=new Date();
	}
	@Override
	public String toString(){
		return mTitle;
	}
	public Date getDate() {
		return mDate;
	}

	public void setDate(Date mDate) {
		this.mDate = mDate;
	}

	public boolean isSolved() {
		return mSolved;
	}

	public void setSolved(boolean mSolved) {
		this.mSolved = mSolved;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String mTilte) {
		this.mTitle = mTilte;
	}

	public UUID getId() {
		return mId;
	}

}
