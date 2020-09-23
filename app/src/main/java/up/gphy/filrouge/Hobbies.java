package up.gphy.filrouge;

import android.content.Intent;
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

import androidx.appcompat.app.AppCompatActivity;

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
    private Integer age;

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

        Log.d(TAG, "recuperer age");
        Intent intent = getIntent();
        if (intent.hasExtra("age")){ // vérifie qu'une valeur est associée à la clé “edittext”
            String str = intent.getStringExtra("age"); // récupère la valeur associée à la clé
            age = Integer.parseInt(str);
        }

    }

    public void toast(String msg) {
        Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
    }

    public void GoPage3(View view) {
        calculAge(view);
        Log.d(TAG,"Go page 3");
        Intent intent = new Intent(this, Lifestyle.class);
        Log.d(TAG, "sauvegarde age");
        intent.putExtra("age", age.toString()); // ajout du couple nom/valeur dans le dictionnaire
        startActivity(intent);
    }

    public void calculAge(View view){
        //Question 6
        int sbq6 = skrep6.getProgress();
        if(sbq6 == 0){
            age = age-5;
        } else if (sbq6 == 1){
            age = age+2;
        } else if (sbq6 == 2){
            age = age+5;
        } else if (sbq6 == 3){
            age = age+8;
        }

        //Question 7
        int sbq7  = skrep7.getProgress();
        if(sbq7 == 0){
            age = age+5;
        } else if (sbq7 == 1){
            age = age+1;
        } else if (sbq7 == 2){
            age = age;
        } else if (sbq7 == 3){
            age  = age-1;
        } else if (sbq7 == 4){
            age = age-2;
        } else if (sbq7 == 5){
            age = age-4;
        } else if (sbq7 == 6){
            age = age-6;
        } else if (sbq7 == 7){
            age = age-10;
        }

        //Question 8
        if (rbrep8a.isChecked()){
            age = age-10;
        } else if (rbrep8b.isChecked()){
            age = age-5;
        } else if (rbrep8c.isChecked()){
            age = age+3;
        }

        //Question 9
        int rep9 = spirep9.getSelectedItemPosition();
        if (rep9 == 0){
            age = age-10;
        } else if (rep9 == 1){
            age = age - 6;
        } else if (rep9 == 2){
            age = age - 3;
        } else if (rep9 == 3){
            age = age;
        } else if (rep9 == 4){
            age = age + 3;
        }

        //Question 10
        int rep10 = spirep10.getSelectedItemPosition();
        if (rep10 == 0){
            age = age-5;
        } else if (rep10 == 1){
            age = age+5;
        } else if (rep10 == 2){
            age = age+2;
        } else if (rep10 == 3){
            age = age-1;
        } else if (rep10 == 4){
            age = age-3;
        } else if (rep10 == 5){
            age = age-5;
        }

        //Question 11
        if (swirep11.isChecked()) {
            age = age+3;
        } else {
            age = age-3;
        }

    }

}