package up.gphy.filrouge;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

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
    private String nom;
    private String prenom;
    private String date;
    private String mail;
    private Integer age;
    private String phone;
    private String phoneMessage;
    private MediaPlayer dead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtResultat = findViewById(R.id.txtResultat);
        txtrank = findViewById(R.id.txtrank);
        txtage = findViewById(R.id.txtage);
        txtphrase = findViewById(R.id.txtphrase);
        rtbar = findViewById(R.id.rtbar);


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
        if (intent.hasExtra("date")){ // vérifie qu'une valeur est associée à la clé “edittext”
            date = intent.getStringExtra("date"); // récupère la valeur associée à la clé
        }
        if (intent.hasExtra("phone")){ // vérifie qu'une valeur est associée à la clé “edittext”
            phone = intent.getStringExtra("phone"); // récupère la valeur associée à la clé
        }
        if (intent.hasExtra("age")){ // vérifie qu'une valeur est associée à la clé “edittext”
            String str = intent.getStringExtra("age");
            age = Integer.parseInt(str); // récupère la valeur associée à la clé
        }

        verifyStoragePermissions(this);
        resultat(null);

        dead= MediaPlayer.create(this,R.raw.dead);
        dead.start();

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
        try (FileOutputStream fos = new FileOutputStream(fileout,true)) {
            PrintStream ps = new PrintStream(fos);
            ps.println("Évaluation of the application");
            ps.println("Tu as donné la note de : "+value);
            ps.println(nom + prenom);
            ps.println("Ton age de mort est de : " + age);


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

    public void sendEmail(View v) {
        vibrate(100);
        toast("Ouverture de la boite mail");
        Log.i("Send email", "");
        String[] TO = {mail};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Result Life Expectancy Simulation");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Hey " + nom + prenom + "! \n"+
                "Tu vas mourir à "+age+" ans \n Bon courage ;)");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            toast("There is no email client installed.");
        }
    }


    public void finish(View view){
        vibrate(100);
        toast("Fin");
        value = rtbar.getRating();
        write_historic_in_file();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        dead.stop();
        finish();
        startActivity(intent);


    }

    public void restart(View view){
        vibrate(100);
        toast("Nouvelle simulation");
        value = rtbar.getRating();
        write_historic_in_file();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("RESTART", true);
        dead.stop();
        startActivity(intent);
    }

    @Override
    public void onBackPressed(){
        //super.onBackPressed();
    }

    public void sendSMS(View v){
        vibrate(100);
        toast("SMS envoyé");
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);
        phoneMessage = "Hey " + nom + prenom + "! \n"+
                "Tu vas mourir à "+age+" ans \n Bon courage ;)";
        SmsManager.getDefault().sendTextMessage(phone, null, phoneMessage, null, null);
    }
}