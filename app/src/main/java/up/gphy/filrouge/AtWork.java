package up.gphy.filrouge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class AtWork extends AppCompatActivity {

    private TextView txtcat4;
    private TextView txtquest18;
    private TextView txtr18yes;
    private Switch swr18;
    private TextView txtr18no;
    private TextView txtquest19;
    private RadioButton rbr19a;
    private RadioButton rbr19b;
    private TextView txtquest20;
    private Spinner spinr20;
    private Button btnSR;

    public static String TAG = "GMD At work";// Identifiant pour les messages de log

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at_work);

        txtcat4 = findViewById(R.id.cat4);
        txtquest18 = findViewById(R.id.txtquest18);
        txtr18yes = findViewById(R.id.txtrep18);
        swr18 = findViewById(R.id.swrep18);
        txtr18no = findViewById(R.id.txtrep18no);
        txtquest19 = findViewById(R.id.txtquest19);
        rbr19a = findViewById(R.id.rbrep19a);
        rbr19b = findViewById(R.id.rbrep19b);
        txtquest20 = findViewById(R.id.txtquest20);
        spinr20 = findViewById(R.id.spinner20);
        btnSR = findViewById(R.id.btnEnd);
    }

    public void goResult(View view) {
        Log.d(TAG,"Go page end");
        Intent intent = new Intent(this, Result.class);
        startActivity(intent);
    }
}