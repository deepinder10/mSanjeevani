package shugal.com.msanjeevani;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class OneClickHelp extends AppCompatActivity {

    static String BLOODBANK = "01722756480";
    static String AMBULANCE = "102";
    static String EYEBANK = "1919";
    static String PGI = "102";
    static String FORTIS = "102";
    static String MAX = "102";

    String[] Helplines = new String[] {
            "AMBULANCE",
            "BLOODBANK",
            "EYEBANK",
            "PGI",
            "FORTIS",
            "MAX"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_click_help);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.listview_layout, R.id.txt, Helplines);
        // Getting a reference to listview of main.xml layout file
        final ListView listView = ( ListView ) findViewById(R.id.helplineList);

        // Setting the adapter to the listView
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int intposition = position;
                String clickedValue = listView.getItemAtPosition(intposition).toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + clickedValue));
                startActivity(callIntent);
            }
        });
    }

}


