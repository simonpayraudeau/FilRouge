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

    public static String TAG = "GMD At work";// Identifiant pour les messages de log
    private Integer age;

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

        Log.d(TAG, "recuperer age");
        Intent intent = getIntent();
        if (intent.hasExtra("age")){ // vérifie qu'une valeur est associée à la clé “edittext”
            String str = intent.getStringExtra("age"); // récupère la valeur associée à la clé
            age = Integer.parseInt(str);
        }
    }

    public void goResult(View view) {
        calculAge(view);
        Log.d(TAG,"Go Result");
        Intent intent = new Intent(this, Result.class);
        intent.putExtra("age", age.toString());
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