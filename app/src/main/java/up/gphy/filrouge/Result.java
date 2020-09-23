package up.gphy.filrouge;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {

    private TextView txtResultat;
    private TextView txtrank;
    private TextView txtage;
    private TextView txtphrase;
    private RatingBar rtbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtResultat = findViewById(R.id.txtResultat);
        txtrank = findViewById(R.id.txtrank);
        txtage = findViewById(R.id.txtage);
        txtphrase = findViewById(R.id.txtphrase);
        rtbar = findViewById(R.id.rtbar);
    }
}