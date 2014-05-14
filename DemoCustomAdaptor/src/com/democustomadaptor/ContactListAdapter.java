package com.democustomadaptor;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ContactListAdapter extends BaseAdapter {

	Context context;
	ArrayList<ContactListItems> contactList;

	public ContactListAdapter(Context context, ArrayList<ContactListItems> list) {

		this.context = context;
		contactList = list;

	}

//	static class ViewHolder {
//
//		TextView tvSlNo;
//
//		TextView tvName;
//		EditText tvphone;
//	}

	@Override
	public int getCount() {

		return contactList.size();
	}

	@Override
	public Object getItem(int position) {

		return contactList.get(position);
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		ContactListItems contactListItems = contactList.get(position);

		//ViewHolder holder = null;

		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.contact_list_row, null);

		}
		TextView tvSlNo = (TextView) convertView.findViewById(R.id.tv_slno);
		tvSlNo.setText(contactListItems.getSlno());
		TextView tvName = (TextView) convertView.findViewById(R.id.tv_name);
		tvName.setText(contactListItems.getName());
		final EditText tvphone = (EditText) convertView
				.findViewById(R.id.tv_phone);
		tvphone.setText(contactListItems.getPhone());

//		holder.tvSlNo = tvSlNo;
//		holder.tvName = tvName;
//		holder.tvphone = tvphone;
//
//		holder.tvphone.setTag(holder);
//
//		holder.tvphone.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//
//				AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(v
//						.getRootView().getContext());
//
//				final String[] numberarray = { "1", "2", "3", "4", "5", "6",
//						"7", "8", "9", "10", "11", "12", "13", "14", "15",
//						"16", "17", "18" };
//				dialogBuilder.setItems(numberarray,
//						new DialogInterface.OnClickListener() {
//
//							@Override
//							public void onClick(DialogInterface dialog,
//									int which) {
//								//
//								// // Toast.makeText(getApplicationContext(),
//								// // numberarray[which],
//								// Toast.LENGTH_SHORT).show();
//
//								String phone_number = numberarray[which]; // value of dialog box saved in string
//
//								// Toast.makeText(getApplicationContext(),
//								// phone_number,
//								// Toast.LENGTH_SHORT).show();
//								// tvphone = (EditText)
//								// findViewById(R.id.tv_phone);
//								//
//
//								tvphone.setText(phone_number);
//
//								dialog.cancel();
//								//
//							}
//						});
//
//				AlertDialog alert = dialogBuilder.create();
//				alert.show();
//
//			}
//		});
		return convertView;
	}

}
