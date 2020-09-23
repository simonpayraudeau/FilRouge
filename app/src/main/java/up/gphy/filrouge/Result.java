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
        txtage.setText(age.toString()+" Ans");

        if (age==0){
            txtphrase.setText("01000101 01110010 01110010 01100101 01110101 01110010");
        }else if (age <0){
            txtphrase.setText("Vous êtes encore vivant, cela relève du miracle");
        }else if (age <25){
            txtphrase.setText("Profitez c’est que du bonus");
        }else if (age <40){
            txtphrase.setText("Tu as la même hygiène de vie que Benoit Paire toi");
        }else if (age <60){
            txtphrase.setText("C’est con de cotiser toute sa vie pour ne pas en profiter");
        }else if (age <80){
            txtphrase.setText("Tu auras le temps de faire du jardin");
        }else if (age <100){
            txtphrase.setText("Inscris toi en maison de retraite");
        }else if (age >100){
            txtphrase.setText("Tu dois descendre de la tortue toi");
        }
    }
}