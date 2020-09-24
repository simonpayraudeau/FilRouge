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

    private String nom;
    private String prenom;
    private String date;
    private String mail;
    private Integer age;

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

        rbr19a.setChecked(true);

        Intent intent = getIntent();
        if (intent.hasExtra("nom")){ // vérifie qu'une valeur est associée à la clé “edittext”
            nom = intent.getStringExtra("nom"); // récupère la valeur associée à la clé
        }
        if (intent.hasExtra("prenom")){ // vérifie qu'une valeur est associée à la clé “edittext”
            prenom = intent.getStringExtra("prenom"); // récupère la valeur associée à la clé
        }
        if (intent.hasExtra("mail")){ // vérifie qu'une valeur est associée à la clé “edittext”
            mail = intent.getStringExtra("mail"); // récupère la valeur associée à la clé
        }
        if (intent.hasExtra("date")){ // vérifie qu'une valeur est associée à la clé “edittext”
            date = intent.getStringExtra("date"); // récupère la valeur associée à la clé
        }
    }

    public void goResult(View view) {
        calculAge(view);
        Log.d(TAG,"Go Result");
        Intent intent = new Intent(this, Result.class);
        intent.putExtra("age", age.toString());
        intent.putExtra("nom", nom);
        intent.putExtra("prenom", prenom);
        intent.putExtra("date", date);
        intent.putExtra("mail", mail);
        Log.d(TAG,"nom : "+ nom );
        Log.d(TAG,"date : "+ date );
        Log.d(TAG,"prenom : "+ prenom );
        Log.d(TAG,"mail : "+ mail );
        startActivity(intent);
    }

    public void calculAge(android.view.View v) {
        Log.d(TAG, "At Work");

        //Question18
        if(swr18.isChecked()){
            age = age -5;
        }else{
            age = age;
        }

        //Question19
        if (rbr19a.isChecked()) {
            age = age-3;
        }
        else if (rbr19b.isChecked()){
            age = age +3;
        }

        //Question20
        Integer value20 = spinr20.getSelectedItemPosition();
        if (value20==0) {
            age = age -5;
        }
        else if (value20==1){
            age = age;
        }
        else if (value20==2){
            age = age -15;
        }
        else if (value20==3){
            age = age +5;
        }

        Log.d(TAG,"Point après page at work : " +age.toString());

    }
}