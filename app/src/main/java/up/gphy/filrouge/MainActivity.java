package up.gphy.filrouge;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "FilRouge"; // Identifiant pour les messages de log

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toast(String msg) {
        Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
    }

    public void doConnect(View view) {
        Log.d(TAG,"do connect");
        Intent intent = new Intent(this, AboutYou.class);
        startActivity(intent);
    }
}
