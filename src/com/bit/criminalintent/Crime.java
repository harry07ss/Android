package com.bit.criminalintent;

import java.util.Date;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;
public class Crime {
	//ģ�Ͳ�������
    private static final String JSON_ID = "id";
    private static final String JSON_TITLE = "title";
    private static final String JSON_DATE = "date";
    private static final String JSON_SOLVED = "solved";
    
	private UUID mId;//ID��
	private String mTitle;//����
	private Date mDate;//����
	private boolean mSolved;//һ���Ƿ�����ѡ��
	private String Tag;
	public Crime(){
		mId=UUID.randomUUID();
		mDate=new Date();
	}
	
    public Crime(JSONObject json) throws JSONException {//��ȡ
        mId = UUID.fromString(json.getString(JSON_ID));
        mTitle = json.getString(JSON_TITLE);
        mSolved = json.getBoolean(JSON_SOLVED);
        mDate = new Date(json.getLong(JSON_DATE));
    }

    public JSONObject toJSON() throws JSONException {//����
        JSONObject json = new JSONObject();
        json.put(JSON_ID, mId.toString());
        json.put(JSON_TITLE, mTitle);
        json.put(JSON_DATE, mDate.getTime());
        json.put(JSON_SOLVED, mSolved);
        return json;
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
