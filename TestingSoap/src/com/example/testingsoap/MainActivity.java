package com.example.testingsoap;

import java.util.ArrayList;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	List<M_Test> ls = new ArrayList<M_Test>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		setTestValue();
		String status = getTestValue();

		List<String> lsStr = new ArrayList<String>();
		for (M_Test temp : ls)
			lsStr.add(temp.getCusName());

		ListView lv = (ListView) findViewById(R.id.lvName);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lsStr);
		lv.setAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public String setTestValue() {

		String URL = "http://192.168.0.1:92/Intern_TestingWebService/InternTesting.svc";
		String NAMESPACE = "http://tempuri.org/";

		final String soap_action = "http://tempuri.org/BankInterface/InsertIntoTable";
		final String methodName = "InsertIntoTable";
		// SoapPrimitive response =new SoapPrimitive(NAMESPACE, name, value)
		SoapObject request = new SoapObject(NAMESPACE, methodName);
		request.addProperty("Name", "Test");

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);

		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);

		try {
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

			androidHttpTransport.call(soap_action, envelope);
			SoapPrimitive soapValue = (SoapPrimitive) envelope.getResponse();
			
			int i = 0 + 9;
			int j = i;
			
		} catch (Exception e) {
			return ("Error_Server : " + e.toString() + "--> Not getting Server Country Details");
		}
		return "success";
	}

	public String getTestValue() {

		String URL = "http://192.168.0.1:92/Intern_TestingWebService/InternTesting.svc";
		String NAMESPACE = "http://tempuri.org/";

		final String soap_action = "http://tempuri.org/BankInterface/selectCommand";
		final String methodName = "selectCommand";

		SoapObject request = new SoapObject(NAMESPACE, methodName);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);

		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);

		try {
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

			androidHttpTransport.call(soap_action, envelope);

			SoapObject soapValue = (SoapObject) envelope.getResponse();

			String custName;

			if (soapValue.getPropertyCount() > 0) {
				for (int i = 0; i < soapValue.getPropertyCount(); i++) {
					SoapObject row = (SoapObject) soapValue.getProperty(i);
					if (row.getPropertySafely("Name") != null) {
						custName = row.getPropertyAsString("Name");

						M_Test temp = new M_Test(custName);
						ls.add(temp);
					}
				}
			}

		} catch (Exception e) {
			return ("Error_Server : " + e.toString() + "--> Not getting Server Country Details");
		}
		return "retrived success";
	}

	public void parseVlue(List<M_Test> lsTest) {
		String name = null;

		for (M_Test mTest : lsTest) {
			name = mTest.getCusName();
			// String id = mTest.getCustId();
		}
		/*
		 * for(int i = 0;i<lsTest.size();i++) { M_Test mTest = lsTest.get(i); }
		 */
	}
}
