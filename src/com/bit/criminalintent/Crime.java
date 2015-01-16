package com.bit.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {
	private UUID mId;
	private String mTilte;
	private Date mDate;
	private boolean mSolved;
	private String Tag;
	public Crime(){
		mId=UUID.randomUUID();
		mDate=new Date();
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

	public String getTilte() {
		return mTilte;
	}

	public void setTilte(String mTilte) {
		this.mTilte = mTilte;
	}

	public UUID getId() {
		return mId;
	}

}
