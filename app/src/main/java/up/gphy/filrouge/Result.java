package up.gphy.filrouge;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Result extends AppCompatActivity {

    private TextView txtResultat;
    private TextView txtrank;
    private TextView txtage;
    private TextView txtphrase;
    private RatingBar rtbar;
    private Float value;

    public static String TAG = "Resultat";// Identifiant pour les messages de log
    private Integer age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtResultat = findViewById(R.id.txtResultat);
        txtrank = findViewById(R.id.txtrank);
        txtage = findViewById(R.id.txtage);
        txtphrase = findViewById(R.id.txtphrase);
        rtbar = findViewById(R.id.rtbar);

        Log.d(TAG, "recuperer age");
        Intent intent = getIntent();
        if (intent.hasExtra("age")){ // vérifie qu'une valeur est associée à la clé “edittext”
            String str = intent.getStringExtra("age"); // récupère la valeur associée à la clé
            age = Integer.parseInt(str);
            resultat(null);
        }

        verifyStoragePermissions(this);
    }

    public void resultat(android.view.View v) {
        txtage.setText(age.toString()+" Ans");

        if (age==0){
            txtphrase.setText("01000101 01110010 01110010 01100101 01110101 01110010");
        }else if (age <0){
            txtphrase.setText("Vous êtes encore vivant, cela relève du miracle");
        }else if (age <25){
            txtphrase.setText("Profitez c’est que du bonus");
        }else if (age <40){
            txtphrase.setText("Tu as la même hygiène de vie que Benoit Paire toi");
        }else if (age <60){
            txtphrase.setText("C’est con de cotiser toute sa vie pour ne pas en profiter");
        }else if (age <80){
            txtphrase.setText("Tu auras le temps de faire du jardin");
        }else if (age <100){
            txtphrase.setText("Inscris toi en maison de retraite");
        }else if (age >100){
            txtphrase.setText("Tu dois descendre de la tortue toi");
        }
    }

    // Listes des permissions
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    public static void verifyStoragePermissions(Activity activity) {
        // Vérifie si nous avons les droits d'écriture
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // Aïe, il faut les demander à l'utilisateur
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    public void write_historic_in_file() {
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File fileout = new File(folder, "RatingFilRouge.txt");
        try (FileOutputStream fos = new FileOutputStream(fileout)) {
            PrintStream ps = new PrintStream(fos);
            ps.println("Évaluation of the application");
            ps.println(value);

            // TODO: YOU MUST COMPLETE ICI

            ps.close();
        } catch (FileNotFoundException e) {
            Log.e(TAG, "File not found", e);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, "Error I/O", e);
        }

    }

    public void getRating (View view){
        value = rtbar.getRating();
        write_historic_in_file();
    }

    public void exitApplication(View view){
        getRating(view);
        System.exit(0);
    }
}