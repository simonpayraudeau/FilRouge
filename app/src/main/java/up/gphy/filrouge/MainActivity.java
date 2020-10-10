package up.gphy.filrouge;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "FilRouge"; // Identifiant pour les messages de log

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
            }
    }

    public void toast(String msg) {
        Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
    }

    public void doConnect(View view) {
        Log.d(TAG,"do connect");
        Intent intent = new Intent(this, Renseignement.class);
        startActivity(intent);
    }

    public void closeApp(View view) {
        finish();
    }
}
