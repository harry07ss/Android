package com.bit.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {//模型层对象的类
	private UUID mId;//ID好
	private String mTitle;//标题
	private Date mDate;//日期
	private boolean mSolved;//一个是否解决的选框
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
