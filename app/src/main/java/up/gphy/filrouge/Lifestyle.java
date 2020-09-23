package up.gphy.filrouge;

import android.content.Intent;
import android.os.Bundle;
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
        Log.d(TAG,"Go page 4");
        Intent intent = new Intent(this, AtWork.class);
        intent.putExtra("age", age.toString());
        startActivity(intent);
    }

    public void calculAge(android.view.View v) {
        Log.d(TAG,"Lifestyle");

        //Question12
        Integer value12 = spirep12.getSelectedItemPosition();
        if (value12==0) {
            age = age +5;
        }
        else if (value12==1){
            age = age +3;
        }
        else if (value12==2){
            age = age;
        }
        else if (value12==3){
            age = age -5;
        }
        else if (value12==4){
            age = age -10;
        }

        //Question13
        Integer value13 = spirep12.getSelectedItemPosition();
        if (value13==0) {
            age = age -5;
        }
        else if (value13==1){
            age = age;
        }
        else if (value13==2){
            age = age -15;
        }
        else if (value13==3){
            age = age +5;
        }

        //Question14
        if(skrep14.getProgress()==0){
            age = age -8;
        }else if (skrep14.getProgress()==1){
            age = age -4;
        }else if (skrep14.getProgress()==2){
            age = age;
        } else if (skrep14.getProgress()==3){
            age = age +4;
        }

        //Question15
        if(skrep15.getProgress()==0){
            age = age -20;
        }else if (skrep15.getProgress()==1){
            age = age -5;
        }else if (skrep15.getProgress()==2){
            age = age -2;
        }else if (skrep15.getProgress()==3){
            age = age +1;
        }else if (skrep15.getProgress()==4){
            age = age -2;
        }

        //Question16
        if(swrep16.isChecked()){
            age = age -5;
        }else{
            age = age +5;
        }

        //Question17
        Integer value17 = spirep12.getSelectedItemPosition();
        if (value17==0) {
            age = age -2;
        }
        else if (value17==1){
            age = age+2;
        }
        else if (value17==2){
            age = age -2;
        }
        else if (value17==3){
            age = age -4;
        }
        else if (value17==4){
            age = age -6;
        }
        Log.d(TAG,"Point après page lifestyle : " + age.toString());

    }
}
