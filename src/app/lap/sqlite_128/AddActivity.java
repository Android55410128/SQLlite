package app.lap.sqlite_128;


import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends Activity {

	private EditText edt1, edt2, edt3, edt4, edt5, edt6, edt7, edt8;
	private Button btn1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add);

		btn1 = (Button) findViewById(R.id.btn_save);

		btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (v == btn1) {
					Save();
				}
			}

		});
	}

	public boolean Save() {
		edt1 = (EditText) findViewById(R.id.edt_name);
		edt2 = (EditText) findViewById(R.id.edt_tel);
		edt3 = (EditText) findViewById(R.id.edt_age);
		edt4 = (EditText) findViewById(R.id.edt_birthday);
		edt5 = (EditText) findViewById(R.id.edt_city);
		edt6 = (EditText) findViewById(R.id.edt_study);
		edt7 = (EditText) findViewById(R.id.edt_facebook);
		edt8 = (EditText) findViewById(R.id.edt_email);
		final AlertDialog.Builder adb = new AlertDialog.Builder(this);
		AlertDialog ad = adb.create();
		if (edt1.getText().length() == 0) {
			ad.setMessage("Please input Name");
			edt1.requestFocus();
			return false;
		}
		if (edt2.getText().length() == 0) {
			ad.setMessage("Please input Tel");
			edt2.requestFocus();
			return false;
		}
		if (edt3.getText().length() == 0) {
			ad.setMessage("Please input Age");
			edt3.requestFocus();
			return false;
		}
		if (edt4.getText().length() == 0) {
			ad.setMessage("Please input Birthday");
			edt4.requestFocus();
			return false;
		}
		if (edt5.getText().length() == 0) {
			ad.setMessage("Please input City");
			edt5.requestFocus();
			return false;
		}
		if (edt6.getText().length() == 0) {
			ad.setMessage("Please input Study");
			edt6.requestFocus();
			return false;
		}
		if (edt7.getText().length() == 0) {
			ad.setMessage("Please input Facebook");
			edt7.requestFocus();
			return false;
		}
		if (edt8.getText().length() == 0) {
			ad.setMessage("Please input Email");
			edt8.requestFocus();
			return false;
		}
		control128DB dbClass = new control128DB(this);
		long savedata = dbClass.InsertData(edt1.getText().toString(), 
				edt2.getText().toString(), edt3.getText().toString(), 
				edt4.getText().toString(), edt5.getText().toString(),
				edt6.getText().toString(), edt7.getText().toString(),
				edt8.getText().toString());
		if (savedata <= 0) {
			ad.setMessage("Error !!!!");
			ad.show();
			return false;
		}
		Toast.makeText(getApplicationContext(), "Add Data Successfully",
				Toast.LENGTH_SHORT).show();
		return true;
	}

}
