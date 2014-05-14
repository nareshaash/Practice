package gold.calc.app;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Ptp extends Activity
{
  Button btn;
  double copper;
  double cs;
  double excessgold;
  double goldtoadd;
  double ornament;
  double ornament2;
  double percentagefrom;
  double percentageto;
  double pure1;
  double pure2;
  double silver;
  EditText text1;
  EditText text2;
  EditText text3;
  double total;
  TextView tv1;
  TextView tv2;
  TextView tv3;
  TextView tv4;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903045);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2130903042, paramMenu);
    return true;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    Dialog localDialog = new Dialog(this);
    localDialog.setContentView(2130903040);
    localDialog.setTitle("About");
    localDialog.show();
    return true;
  }

  public void onStart()
  {
    super.onStart();
    this.text1 = ((EditText)findViewById(2131099666));
    this.text2 = ((EditText)findViewById(2131099655));
    this.text3 = ((EditText)findViewById(2131099667));
    this.tv1 = ((TextView)findViewById(2131099668));
    this.tv2 = ((TextView)findViewById(2131099669));
    this.tv3 = ((TextView)findViewById(2131099670));
    this.tv4 = ((TextView)findViewById(2131099671));
    this.btn = ((Button)findViewById(2131099649));
    this.btn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramView)
      {
        Ptp.this.ornament = Double.valueOf(Ptp.this.text1.getText().toString()).doubleValue();
        Ptp.this.percentagefrom = Double.valueOf(Ptp.this.text2.getText().toString()).doubleValue();
        Ptp.this.percentageto = Double.valueOf(Ptp.this.text3.getText().toString()).doubleValue();
        Ptp.this.pure1 = (0.01D * (Ptp.this.ornament * Ptp.this.percentagefrom));
        Ptp.this.pure2 = (0.01D * (Ptp.this.ornament * Ptp.this.percentageto));
        if (Ptp.this.percentagefrom < Ptp.this.percentageto)
        {
          double d1 = 100.0D * (Ptp.this.pure1 / Ptp.this.percentageto);
          double d2 = Ptp.this.ornament - d1;
          Ptp.this.goldtoadd = (d2 * (Ptp.this.percentageto / (100.0D - Ptp.this.percentageto)));
          Ptp.this.total = (Ptp.this.ornament + Ptp.this.goldtoadd);
          String str4 = new Double(Ptp.this.total).toString();
          Ptp.this.tv1.setText(str4);
          String str5 = new Double(Ptp.this.goldtoadd).toString();
          Ptp.this.tv2.setText(str5);
          Ptp.this.tv3.setText("Dont Add");
          Ptp.this.tv4.setText("Dont Add");
          return;
        }
        Ptp.this.excessgold = (Ptp.this.pure1 - Ptp.this.pure2);
        Ptp.this.ornament2 = (100.0D * (Ptp.this.excessgold / Ptp.this.percentageto));
        Ptp.this.cs = (Ptp.this.ornament2 - Ptp.this.excessgold);
        Ptp localPtp = Ptp.this;
        localPtp.cs += Ptp.this.pure1 - Ptp.this.pure2;
        Ptp.this.total = (Ptp.this.ornament + Ptp.this.cs);
        Ptp.this.copper = (0.8D * Ptp.this.cs);
        Ptp.this.silver = (0.2D * Ptp.this.cs);
        String str1 = new Double(Ptp.this.total).toString();
        Ptp.this.tv1.setText(str1);
        Ptp.this.tv2.setText("Dont Add");
        String str2 = new Double(Ptp.this.copper).toString();
        Ptp.this.tv3.setText(str2);
        String str3 = new Double(Ptp.this.silver).toString();
        Ptp.this.tv4.setText(str3);
      }
    });
  }
}

/* Location:           C:\Users\NAC\Desktop\APK\classes_dex2jar.jar
 * Qualified Name:     gold.calc.app.Ptp
 * JD-Core Version:    0.6.0
 */