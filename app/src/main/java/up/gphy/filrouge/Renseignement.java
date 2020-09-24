package up.gphy.filrouge;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Renseignement extends AppCompatActivity {

    public static String TAG = "Renseignement"; // Identifiant pour les messages de log

    private TextView txtNom;
    private TextView txtPrenom;
    private TextView txtNaissance;
    private TextView txtMail;
    private TextView txtTitre;
    private EditText edtNom;
    private EditText edtPrenom;
    private EditText edtMail;
    private DatePicker dpDate;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renseignement);

        txtNom = findViewById(R.id.txtNom);
        txtPrenom = findViewById(R.id.txtPrenom);
        txtNaissance = findViewById(R.id.txtNaissance);
        txtMail = findViewById(R.id.txtMail);
        txtTitre = findViewById(R.id.txtTitre);
        edtNom = findViewById(R.id.edtNom);
        edtPrenom = findViewById(R.id.edtPrenom);
        edtMail = findViewById(R.id.edtMail);
        dpDate = findViewById(R.id.dpDate);
        btnStart = findViewById(R.id.btnStart);

    }

    public void start(View view) {
        Log.d(TAG,"start");
        Intent intent = new Intent(this, AboutYou.class);
        startActivity(intent);
    }
}