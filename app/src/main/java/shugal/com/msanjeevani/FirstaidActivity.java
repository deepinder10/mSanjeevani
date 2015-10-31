package shugal.com.msanjeevani;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

public class FirstaidActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstaid);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("First Aid");

        ColorGenerator generator = ColorGenerator.MATERIAL; // or use DEFAULT
// generate random color
        int color1 = generator.getRandomColor();
// generate color based on a key (same key returns the same color), useful for list/grid views
        int color2 = generator.getRandomColor();;

// reuse the builder specs to create multiple drawables
        TextDrawable ic1 = TextDrawable.builder().buildRound("G", color1);
        TextDrawable ic2 = TextDrawable.builder().buildRound("F", color2);

        ImageView image = (ImageView) findViewById(R.id.image_view);
        image.setImageDrawable(ic1);

        ImageView image2 = (ImageView) findViewById(R.id.image_view2);
        image2.setImageDrawable(ic2);
    }

    public void generalInstructions(View view) {
        startActivity(new Intent(this,GeneralInstructions.class));
    }

    public void BoxItems(View view) {
        startActivity(new Intent(this, AidBoxItems.class));
    }
}

