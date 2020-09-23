package up.gphy.filrouge;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {

    private TextView txtResultat;
    private TextView txtrank;
    private TextView txtage;
    private TextView txtphrase;
    private RatingBar rtbar;

    public static String TAG = "Resultat";// Identifiant pour les messages de log
    private Integer age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtResultat = findViewById(R.id.txtResultat);
        txtrank = findViewById(R.id.txtrank);
        txtage = findViewById(R.id.txtage);
        txtphrase = findViewById(R.id.txtphrase);
        rtbar = findViewById(R.id.rtbar);

        Log.d(TAG, "recuperer age");
        Intent intent = getIntent();
        if (intent.hasExtra("age")){ // vérifie qu'une valeur est associée à la clé “edittext”
            String str = intent.getStringExtra("age"); // récupère la valeur associée à la clé
            age = Integer.parseInt(str);
            resultat(null);
        }



    }

    public void resultat(android.view.View v) {
        txtage.setText(age.toString());
        txtphrase.setText("Cheh");
    }
}