package up.gphy.filrouge;

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

    }

    public void toast(String msg) {
        Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
    }

    public void GoPage3(View view) {
        Log.d(TAG,"Go page 4");
//        Intent intent = new Intent(this, AtWork.class);
//        startActivity(intent);
    }

}
