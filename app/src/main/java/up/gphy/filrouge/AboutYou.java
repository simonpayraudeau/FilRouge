package up.gphy.filrouge;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

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
    private String nom;
    private String prenom;
    private String date;
    private String mail;
    private String phone;
    private Integer age;

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

        rbrep3aAY.setChecked(true);
        rbrep1aAY.setChecked(true);

        rbrep1cAY.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                nonBinaire();
            }
        });

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
        /*if (intent.hasExtra("age")){ // vérifie qu'une valeur est associée à la clé “edittext”
            String str = intent.getStringExtra("age");
            age = Integer.parseInt(str); // récupère la valeur associée à la clé
        }*/

    }

    public void toast(String msg) {
        Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
    }

    public void goPage2(View view) {
        calculAge(view);
        Log.d(TAG,"Go page 2");
        Intent intent = new Intent(this, Hobbies.class);
        intent.putExtra("age", age.toString());
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
        Log.d(TAG,"Start quizz");

        //Question1
        if (rbrep1aAY.isChecked()) {
            age = 85;
        }
        else if (rbrep1bAY.isChecked()){
            age=80;
        }
        else if (rbrep1cAY.isChecked()) {
            age = 40;
        }

        //Question2
        Integer value2 = spinrep2AY.getSelectedItemPosition();
        if (value2==0) {
            age = age;
        }
        else if (value2==1){
            age = age -7;
        }
        else if (value2==2){
            age = age -20;
        }
        else if (value2==3){
            age = age -5;
        }
        else if (value2==4){
            age = age +3;
        }

        //Question3
        if (rbrep3aAY.isChecked()) {
            age = age -5;
        }
        else if (rbrep3bAY.isChecked()){
            age = age +4;
        }
        else if (rbrep3cAY.isChecked()){
            age = age;
        }

        //Question4
        if(swrep4AY.isChecked()){
            age = age +5;
        }else{
            age = age -5;
        }

        //Question5
        Integer value5 = spinrep5AY.getSelectedItemPosition();
        if(value5==0){
            age= age -5;
        } else if (value5==1){
            age= age -2;
        } else if (value5==2){
            age= age ;
        } else if (value5==3){
            age= age +2;
        } else if (value5==4){
            age= age -20;
        } else if (value5==5){
            age = age +5;
        }
        Log.d(TAG,"Point après page about you : " +age.toString());
    }

    public void nonBinaire (){
        age = 0;
        Intent intent = new Intent(this, Result.class);
        intent.putExtra("age", age);
        startActivity(intent);
    }
}

