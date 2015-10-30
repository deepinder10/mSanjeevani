package shugal.com.msanjeevani;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class emal_symptoms extends AppCompatActivity {
    EditText tot , sub , msg;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emal_symptoms);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tot=(EditText)findViewById(R.id.emailid);
        sub=(EditText)findViewById(R.id.sub);
        msg=(EditText)findViewById(R.id.msglist);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Share symptoms With Doctor ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        fab.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0 ){
                String to = tot.getText().toString();
                String subject = sub.getText().toString();
                String message = msg.getText().toString();
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{to });
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));
                finish();
            }
        });
    }


}
