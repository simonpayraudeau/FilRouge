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
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Lifestyle extends AppCompatActivity {

    public static String TAG = "Page3"; // Identifiant pour les messages de log
    private Integer age;
    private Integer ageMalus =0;
    private TextView txtTitre;
    private TextView txtquest12;
    private Spinner spirep12;
    private TextView txtquest13;
    private Spinner spirep13;
    private TextView txtquest14;
    private TextView txtrep14;
    private SeekBar skrep14;
    private TextView txtquest15;
    private SeekBar skrep15;
    private TextView txtrep15;
    private TextView txtquest16;
    private Switch swrep16;
    private TextView txtyes;
    private TextView txtno;
    private TextView txtquest17;
    private Spinner spirep17;
    private Button btnNextPage;

    private String nom;
    private String prenom;
    private String date;
    private String mail;
    private String phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifestyle);

        txtTitre = findViewById(R.id.txtTitre);
        txtquest12 = findViewById(R.id.txtquest12);
        spirep12 = findViewById(R.id.spirep12);
        txtquest13 = findViewById(R.id.txtquest13);
        spirep13 = findViewById(R.id.spirep13);
        txtquest14 = findViewById(R.id.txtquest14);
        txtrep14 = findViewById(R.id.txtrep14);
        skrep14 = findViewById(R.id.skrep14);
        txtquest15 = findViewById(R.id.txtquest15);
        skrep15 = findViewById(R.id.skrep15);
        txtrep15 = findViewById(R.id.txtrep15);
        txtquest16 = findViewById(R.id.txtquest16);
        swrep16 = findViewById(R.id.swrep16);
        txtyes = findViewById(R.id.txtyes);
        txtno = findViewById(R.id.txtno);
        txtquest17 = findViewById(R.id.txtquest17);
        spirep17 = findViewById(R.id.spirep17);
        btnNextPage = findViewById(R.id.btnNextPage);

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

        setSkRep14();
        skrep14.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                setSkRep14();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                setSkRep14();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                setSkRep14();
            }
        });

        setSkrep15();
        skrep15.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                setSkrep15();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                setSkrep15();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                setSkrep15();
            }
        });

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

    public void toast(String msg) {
        Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
    }

    public void GoPage4(View view) {
        vibrate(100);
        calculAge(view);
        Log.d(TAG,"Go page 4");
        Intent intent = new Intent(this, AtWork.class);
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
        Log.d(TAG,"Lifestyle");
        age = age - ageMalus;
        ageMalus = 0;

        //Question12
        Integer value12 = spirep12.getSelectedItemPosition();
        if (value12==0) {
            ageMalus = ageMalus +5;
        }
        else if (value12==1){
            ageMalus = ageMalus +3;
        }
        else if (value12==2){
            ageMalus = ageMalus;
        }
        else if (value12==3){
            ageMalus = ageMalus -5;
        }
        else if (value12==4){
            ageMalus = ageMalus -10;
        }

        //Question13
        Integer value13 = spirep12.getSelectedItemPosition();
        if (value13==0) {
            ageMalus = ageMalus -5;
        }
        else if (value13==1){
            ageMalus = ageMalus;
        }
        else if (value13==2){
            ageMalus = ageMalus -15;
        }
        else if (value13==3){
            ageMalus = ageMalus +5;
        }

        //Question14
        if(skrep14.getProgress()==0){
            ageMalus = ageMalus -8;
        }else if (skrep14.getProgress()==1){
            ageMalus = ageMalus -4;
        }else if (skrep14.getProgress()==2){
            ageMalus = ageMalus;
        } else if (skrep14.getProgress()==3){
            ageMalus = ageMalus +4;
        }

        //Question15
        if(skrep15.getProgress()==0){
            ageMalus = ageMalus -20;
        }else if (skrep15.getProgress()==1){
            ageMalus = ageMalus -5;
        }else if (skrep15.getProgress()==2){
            ageMalus = ageMalus -2;
        }else if (skrep15.getProgress()==3){
            ageMalus = ageMalus +1;
        }else if (skrep15.getProgress()==4){
            ageMalus = ageMalus -2;
        }

        //Question16
        if(swrep16.isChecked()){
            ageMalus = ageMalus -5;
        }else{
            ageMalus = ageMalus +5;
        }

        //Question17
        Integer value17 = spirep12.getSelectedItemPosition();
        if (value17==0) {
            ageMalus = ageMalus -2;
        }
        else if (value17==1){
            ageMalus = ageMalus+2;
        }
        else if (value17==2){
            ageMalus = ageMalus -2;
        }
        else if (value17==3){
            ageMalus = ageMalus -4;
        }
        else if (value17==4){
            ageMalus = ageMalus -6;
        }
        age = age + ageMalus;
        Log.d(TAG,"Point après page lifestyle : " + age.toString());
    }

    public void setSkRep14(){
        if(skrep14.getProgress()==0){
            txtrep14.setText("0");
        }else if (skrep14.getProgress()==1){
            txtrep14.setText("1");
        }else if (skrep14.getProgress()==2){
            txtrep14.setText("2");
        } else if (skrep14.getProgress()==3){
            txtrep14.setText("3 & +");
        }
    }

    public void setSkrep15(){
        if(skrep15.getProgress()==0){
            txtrep15.setText("0 #thuglife");
        }else if (skrep15.getProgress()==1){
            txtrep15.setText("1-5");
        }else if (skrep15.getProgress()==2){
            txtrep15.setText("6-7");
        } else if (skrep15.getProgress()==3){
            txtrep15.setText("8-9");
        } else if (skrep15.getProgress()==4){
            txtrep15.setText("10 et +");
        }
    }


}
