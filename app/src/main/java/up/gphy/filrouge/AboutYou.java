package up.gphy.filrouge;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutYou extends AppCompatActivity {

    private TextView titleAY;
    private TextView txtcatAY;
    private TextView txtq1AY;
    private RadioButton rbrep1aAY;
    private RadioButton rbrep1bAY;
    private RadioButton rbrep1cAY;
    private TextView txtq2AY;
    private Spinner spinrep2AY;
    private TextView txtq3AY;
    private RadioButton rbrep3aAY;
    private RadioButton rbrep3bAY;
    private RadioButton rbrep3cAY;
    private TextView txtq4AY;
    private TextView txtrep4yesAY;
    private TextView txtrep4noAY;
    private Switch swrep4AY;
    private TextView txtq5AY;
    private Spinner spinrep5AY;
    private Button btnnextAY;

    public static String TAG = "GMD About You";// Identifiant pour les messages de log

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_you);

        titleAY = findViewById(R.id.tittle);
        txtcatAY = findViewById(R.id.txtcat1);
        txtq1AY = findViewById(R.id.txtquest1);
        rbrep1aAY = findViewById(R.id.rbrep1a);
        rbrep1bAY = findViewById(R.id.rbrep1b);
        rbrep1cAY = findViewById(R.id.rbrep1c);
        txtq2AY = findViewById(R.id.txtquest2);
        spinrep2AY = findViewById(R.id.spinrep2);
        txtq3AY = findViewById(R.id.txtquest3);
        rbrep3aAY = findViewById(R.id.rbrep3a);
        rbrep3bAY = findViewById(R.id.rbrep3b);
        rbrep3cAY = findViewById(R.id.rbrep3c);
        txtq4AY = findViewById(R.id.txtquest4);
        txtrep4yesAY = findViewById(R.id.txtr4yes);
        txtrep4noAY = findViewById(R.id.txtr4no);
        swrep4AY = findViewById(R.id.stchrep4);
        txtq5AY = findViewById(R.id.txtquest5);
        spinrep5AY = findViewById(R.id.spinrep5);
        btnnextAY = findViewById(R.id.bnextQ1);

    }

    public void GoPage2(View view) {
        Log.d(TAG,"Go page 2");
        Intent intent = new Intent(this, Hobbies.class);
        startActivity(intent);
    }
}