package up.gphy.filrouge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Hobbies extends AppCompatActivity {

    public static String TAG = "Page2"; // Identifiant pour les messages de log

    private TextView txtcat2;
    private TextView txtquest6;
    private TextView txtquest7;
    private TextView txtquest8;
    private TextView txtquest9;
    private TextView txtquest10;
    private TextView txtquest11;
    private SeekBar skrep6;
    private SeekBar skrep7;
    private RadioButton rbrep8a;
    private RadioButton rbrep8b;
    private RadioButton rbrep8c;
    private Spinner spirep9;
    private Spinner spirep10;
    private Switch swirep11;
    private Button btngopage3;
    private TextView txtyes;
    private TextView txtno;
    private TextView txtrep6;
    private TextView txtrep7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobbies);
        Log.d(TAG,"start");

        txtcat2 = findViewById(R.id.txtcat2);
        txtquest6 = findViewById(R.id.txtquest6);
        txtquest7 = findViewById(R.id.txtquest7);
        txtquest8 = findViewById(R.id.txtquest8);
        txtquest9 = findViewById(R.id.txtquest9);
        txtquest10 = findViewById(R.id.txtquest10);
        txtquest11 = findViewById(R.id.txtquest11);
        skrep6 = findViewById(R.id.skrep6);
        skrep7 = findViewById(R.id.skrep7);
        rbrep8a = findViewById(R.id.rbrep8a);
        rbrep8b = findViewById(R.id.rbrep8b);
        rbrep8c = findViewById(R.id.rbrep8c);
        spirep9 = findViewById(R.id.spirep9);
        spirep10 = findViewById(R.id.spirep10);
        swirep11 = findViewById(R.id.swirep11);
        btngopage3 = findViewById(R.id.btngopage3);
        txtyes = findViewById(R.id.txtyes);
        txtno = findViewById(R.id.txtno);
        txtrep6 = findViewById(R.id.txtrep6);
        txtrep7 = findViewById(R.id.txtrep7);

        Log.d(TAG,"Fin création");

    }

    public void toast(String msg) {
        Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
    }

    public void GoPage3(View view) {

//        Intent intent = new Intent(this, Page2.class);
//        startActivity(intent);
        finish();
    }
}