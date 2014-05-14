package gold.calc.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GoldCalculatorActivity extends Activity
  implements View.OnClickListener
{
  Button but1;
  Button but2;
  Button but3;

  public void onClick(View paramView)
  {
    if (paramView.equals(this.but1))
      startActivity(new Intent(this, pto.class));
    if (paramView.equals(this.but2))
      startActivity(new Intent(this, Otp.class));
    if (paramView.equals(this.but3))
      startActivity(new Intent(this, Ptp.class));
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903041);
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
    this.but1 = ((Button)findViewById(2131099649));
    this.but2 = ((Button)findViewById(2131099650));
    this.but3 = ((Button)findViewById(2131099651));
    this.but1.setOnClickListener(this);
    this.but2.setOnClickListener(this);
    this.but3.setOnClickListener(this);
  }
}

/* Location:           C:\Users\NAC\Desktop\APK\classes_dex2jar.jar
 * Qualified Name:     gold.calc.app.GoldCalculatorActivity
 * JD-Core Version:    0.6.0
 */