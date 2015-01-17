package com.bit.criminalintent;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;

public class DatePickerFragment extends DialogFragment {
	public static final String EXTRA_DATE="com.bit.date";
	private static final String Tag ="DatePicker";
	private Date mDate;
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mDate=(Date)getArguments().getSerializable(EXTRA_DATE);
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(mDate);
		 int year=calendar.get(Calendar.YEAR);
		 final int month=calendar.get(Calendar.MONTH);
		 final int day=calendar.get(Calendar.DAY_OF_MONTH);
		
		View v =getActivity().getLayoutInflater().inflate(R.layout.dialog_date, null);
	
		DatePicker datePicker=(DatePicker)v.findViewById(R.id.dialog_date_datePicker);
		datePicker.init(year,month,day,new OnDateChangedListener() {
			
			public void onDateChanged(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				Log.d(Tag, "year: "+year+"  "+day);
				mDate=new GregorianCalendar(year,month,day).getTime();
				getArguments().putSerializable(EXTRA_DATE, mDate);
				
			}
		});
		return new AlertDialog.Builder(getActivity())
		.setView(v)
		.setTitle(R.string.data_picker_title).
		setPositiveButton(android.R.string.ok,null).create();
		
	}
	
	public static DatePickerFragment newInstance(Date date){
		Bundle args =new Bundle();
		args.putSerializable(EXTRA_DATE, date);
		
		DatePickerFragment fragment =new DatePickerFragment();
		fragment.setArguments(args);
		return fragment;
	}
	

}
