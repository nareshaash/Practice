package com.democustomadaptor;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	SqlHandler sqlHandler;
	ListView lvCustomList;
	EditText etName, etPhone, tvphone;
	Button btnsubmit;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		lvCustomList = (ListView) findViewById(R.id.lv_custom_list);
		
//		View footerView = ((LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.load_messages, null, false);
//		mylist.addFooterView(footerView);
//
//		btnLoadMessages = (Button) footerView.findViewById(R.id.btnLoad);
		
		
		
		etName = (EditText) findViewById(R.id.et_name);
		etPhone = (EditText) findViewById(R.id.et_phone);
		
		btnsubmit = (Button) findViewById(R.id.btn_submit);
		sqlHandler = new SqlHandler(this);
		showList();
		btnsubmit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String name = etName.getText().toString();
				String phoneNo = etPhone.getText().toString();

				String query = "INSERT INTO PHONE_CONTACTS(name,phone) values ('"
						+ name + "','" + phoneNo + "')";
				sqlHandler.executeQuery(query);
				showList();
				etName.setText("");
				etPhone.setText("");

			}
		});
		// tv_phone = (EditText) findViewById(R.id.tv_phone);

		// tv_phone.setOnClickListener(new OnClickListener() {
		//

		// });
		

	}

	
	
	
	
	public void et_onclick(View v) {

		// Toast.makeText(getBaseContext(),
		// "You hv successfully cliked on edittext", Toast.LENGTH_SHORT)
		// .show();

		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(v
				.getRootView().getContext());

		final String[] numberarray = { "1", "2", "3", "4", "5", "6", "7", "8",
				"9", "10", "11", "12", "13", "14", "15", "16", "17", "18" };
		dialogBuilder.setItems(numberarray,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						// Toast.makeText(getApplicationContext(),
						// numberarray[which], Toast.LENGTH_SHORT).show();
						
					
						String phone_number = numberarray[which]; // value of
																	// dialog
																	// box saved
																	// in string

						Toast.makeText(getApplicationContext(), phone_number,
								Toast.LENGTH_SHORT).show();
						// tvphone = (EditText) findViewById(R.id.tv_phone);
						//
						
					
						//tvphone.setText(phone_number);
						dialog.cancel();

					}
				});

		AlertDialog alert = dialogBuilder.create();
		alert.show();
	}

	private void showList() {

		ArrayList<ContactListItems> contactList = new ArrayList<ContactListItems>();
		contactList.clear();
		String query = "SELECT * FROM PHONE_CONTACTS ";
		Cursor c1 = sqlHandler.selectQuery(query);
		if (c1 != null && c1.getCount() != 0) {
			if (c1.moveToFirst()) {
				do {
					ContactListItems contactListItems = new ContactListItems();

					contactListItems.setSlno(c1.getString(c1
							.getColumnIndex("slno")));
					contactListItems.setName(c1.getString(c1
							.getColumnIndex("name")));
					contactListItems.setPhone(c1.getString(c1
							.getColumnIndex("phone")));
					contactList.add(contactListItems);

				} while (c1.moveToNext());

			}

		}
		c1.close();

		ContactListAdapter contactListAdapter = new ContactListAdapter(
				MainActivity.this, contactList);
		lvCustomList.setAdapter(contactListAdapter);

		
		
		
	
	}

}