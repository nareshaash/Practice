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

public class Otp extends Activity
{
  Button btn;
  double ornament;
  double percentage;
  double pure;
  EditText text1;
  EditText text2;
  TextView tv;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903043);
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
    this.tv = ((TextView)findViewById(2131099657));
    this.btn = ((Button)findViewById(2131099649));
    this.btn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramView)
      {
        Otp.this.ornament = Double.valueOf(Otp.this.text1.getText().toString()).doubleValue();
        Otp.this.percentage = Double.valueOf(Otp.this.text2.getText().toString()).doubleValue();
        Otp.this.pure = (Otp.this.ornament * Otp.this.percentage / 100.0D);
        String str = new Double(Otp.this.pure).toString();
        Otp.this.tv.setText(str);
      }
    });
  }
}

/* Location:           C:\Users\NAC\Desktop\APK\classes_dex2jar.jar
 * Qualified Name:     gold.calc.app.Otp
 * JD-Core Version:    0.6.0
 */