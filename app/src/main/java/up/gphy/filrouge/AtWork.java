package up.gphy.filrouge;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
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
    private String phone;
    private Integer age;
    private Integer ageMalus =0;

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
        if (intent.hasExtra("phone")){ // vérifie qu'une valeur est associée à la clé “edittext”
            phone = intent.getStringExtra("phone"); // récupère la valeur associée à la clé
        }
        if (intent.hasExtra("date")){ // vérifie qu'une valeur est associée à la clé “edittext”
            date = intent.getStringExtra("date"); // récupère la valeur associée à la clé
        }
        if (intent.hasExtra("age")){ // vérifie qu'une valeur est associée à la clé “edittext”
            String str = intent.getStringExtra("age");
            age = Integer.parseInt(str); // récupère la valeur associée à la clé
        }
    }

    public void vibrate(long duration_ms) {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if(duration_ms < 1)
            duration_ms = 1;
        if(v != null && v.hasVibrator()) {
// Attention changement comportement avec API >= 26 (cf doc)
            if(Build.VERSION.SDK_INT >= 26) {
                v.vibrate(VibrationEffect.createOneShot(duration_ms,
                        VibrationEffect.DEFAULT_AMPLITUDE));
            }
            else {
                v.vibrate(duration_ms);
            }
        }
// sinon il n'y a pas de mécanisme de vibration
    }

    public void goResult(View view) {
        vibrate(100);
        calculAge(view);
        Log.d(TAG,"Go Result");
        Intent intent = new Intent(this, Result.class);
        intent.putExtra("age", age.toString());
        intent.putExtra("ageMalus", ageMalus.toString());
        intent.putExtra("nom", nom);
        intent.putExtra("prenom", prenom);
        intent.putExtra("date", date);
        intent.putExtra("mail", mail);
        intent.putExtra("phone", phone);
        Log.d(TAG,"nom : "+ nom );
        Log.d(TAG,"date : "+ date );
        Log.d(TAG,"prenom : "+ prenom );
        Log.d(TAG,"mail : "+ mail );
        Log.d(TAG,"phone : "+ phone );
        startActivity(intent);
    }

    public void calculAge(android.view.View v) {
        Log.d(TAG, "At Work");
        age =age-ageMalus;
        ageMalus = 0;

        //Question18
        if(swr18.isChecked()){
            ageMalus = ageMalus -5;
        }else{
            ageMalus = ageMalus;
        }

        //Question19
        if (rbr19a.isChecked()) {
            ageMalus = ageMalus-3;
        }
        else if (rbr19b.isChecked()){
            ageMalus = ageMalus +3;
        }

        //Question20
        Integer value20 = spinr20.getSelectedItemPosition();
        if (value20==0) {
            ageMalus = ageMalus -5;
        }
        else if (value20==1){
            ageMalus = ageMalus;
        }
        else if (value20==2){
            ageMalus = ageMalus -15;
        }
        else if (value20==3){
            ageMalus = ageMalus +5;
        }
        age = age + ageMalus;
        Log.d(TAG,"Point après page at work : " +age.toString());

    }
}