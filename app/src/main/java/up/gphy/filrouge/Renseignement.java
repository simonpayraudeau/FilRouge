package up.gphy.filrouge;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Renseignement extends AppCompatActivity {

    public static String TAG = "Renseignement"; // Identifiant pour les messages de log

    private TextView txtNom;
    private TextView txtPrenom;
    private TextView txtNaissance;
    private TextView txtMail;
    private TextView txtTitre;
    private TextView txtPhone;
    private EditText edtNom;
    private EditText edtPrenom;
    private EditText edtMail;
    private EditText edtPhone;
    private DatePicker dpDate;
    private Button btnStart;
    private String nom;
    private String prenom;
    private String mail;
    private String date;
    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renseignement);

        txtNom = findViewById(R.id.txtNom);
        txtPrenom = findViewById(R.id.txtPrenom);
        txtNaissance = findViewById(R.id.txtNaissance);
        txtMail = findViewById(R.id.txtMail);
        txtTitre = findViewById(R.id.txtTitre);
        txtPhone = findViewById(R.id.txtPhone);
        edtNom = findViewById(R.id.edtNom);
        edtPrenom = findViewById(R.id.edtPrenom);
        edtMail = findViewById(R.id.edtMail);
        edtPhone = findViewById(R.id.edtPhone);
        dpDate = findViewById(R.id.dpDate);
        btnStart = findViewById(R.id.btnStart);
        dpDate.setCalendarViewShown(false);

        edtNom.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                edtNom.setText("");
                return false;
            }
        });

        edtPrenom.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                edtPrenom.setText("");
                return false;
            }
        });

        edtMail.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                edtMail.setText("");
                return false;
            }
        });

        edtPhone.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                edtPhone.setText("");
                return false;
            }
        });
    }

    public void start(View view) {
        Log.d(TAG,"start");
        recupData();
        Intent intent = new Intent(this, AboutYou.class);
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


//    public static boolean isValidEmail(CharSequence target) {
//        if (target == null) {
//            return false;
//        } else {
//            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
//        }
//    }

    public static java.util.Date getDateFromDatePicker(DatePicker datePicker){
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year =  datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar.getTime();
    }

    public void recupData(){
        nom = edtNom.getText().toString();
        prenom = edtPrenom.getText().toString();
        date = getDateFromDatePicker(dpDate).toString();
        mail = edtMail.getText().toString();
        phone = edtPhone.getText().toString();
    }
}