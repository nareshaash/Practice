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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class pto extends Activity
{
  Button btn;
  double copper;
  double mix;
  double ornament;
  double percentage;
  double pure;
  RadioButton rbutton;
  RadioButton rbutton0;
  RadioButton rbutton1;
  RadioGroup rgroup;
  double silver;
  EditText text1;
  EditText text2;
  TextView text3;
  TextView text4;
  TextView text5;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903044);
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
    this.text1 = ((EditText)findViewById(2131099653));
    this.text2 = ((EditText)findViewById(2131099655));
    this.text3 = ((TextView)findViewById(2131099657));
    this.text4 = ((TextView)findViewById(2131099664));
    this.text5 = ((TextView)findViewById(2131099665));
    this.rbutton0 = ((RadioButton)findViewById(2131099661));
    this.rbutton1 = ((RadioButton)findViewById(2131099660));
    this.btn = ((Button)findViewById(2131099649));
    this.btn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramView)
      {
        pto.this.pure = Double.valueOf(pto.this.text1.getText().toString()).doubleValue();
        pto.this.percentage = Double.valueOf(pto.this.text2.getText().toString()).doubleValue();
        pto.this.ornament = (100.0D * (pto.this.pure / pto.this.percentage));
        pto.this.mix = (pto.this.ornament - pto.this.pure);
        pto.this.rgroup = ((RadioGroup)pto.this.findViewById(2131099659));
        int i = pto.this.rgroup.getCheckedRadioButtonId();
        pto.this.rbutton = ((RadioButton)pto.this.findViewById(i));
        if (pto.this.rbutton.equals(pto.this.rbutton0))
          pto.this.copper = (0.8D * pto.this.mix);
        for (pto.this.silver = (0.2D * pto.this.mix); ; pto.this.silver = (0.3D * pto.this.mix))
        {
          String str1 = new Double(pto.this.ornament).toString();
          pto.this.text3.setText(str1);
          String str2 = new Double(pto.this.copper).toString();
          pto.this.text4.setText(str2);
          String str3 = new Double(pto.this.silver).toString();
          pto.this.text5.setText(str3);
          return;
          pto.this.copper = (0.7D * pto.this.mix);
        }
      }
    });
  }
}

/* Location:           C:\Users\NAC\Desktop\APK\classes_dex2jar.jar
 * Qualified Name:     gold.calc.app.pto
 * JD-Core Version:    0.6.0
 */