package shugal.com.msanjeevani;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bmi_index extends AppCompatActivity {

    EditText ht,wt;
    TextView result;
    Button calculate;
    float height=0,weight=0;
    float resultBmi;
    String resultText;
    TextInputLayout inputLayoutWeight,inputLayoutHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_index);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Calculate BMI");

        result = (TextView) findViewById(R.id.bmiResult);
        calculate = (Button) findViewById(R.id.calculate);
        inputLayoutWeight = (TextInputLayout) findViewById(R.id.input_layout_weight);
        inputLayoutHeight = (TextInputLayout) findViewById(R.id.input_layout_height);
        wt = (EditText) findViewById(R.id.WeightBmi);
        ht = (EditText) findViewById(R.id.HeightBmi);

        wt.addTextChangedListener(new MyTextWatcher(wt));
        ht.addTextChangedListener(new MyTextWatcher(ht));

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();

                resultBmi = weight/((height*height)/10000) ;

                if(resultBmi < 18.50)
                    resultText = "Underweight";
                if(resultBmi > 18.50 && resultBmi < 24.99);
                resultText = "Healthy";
                if(resultBmi >= 25.00 && resultBmi < 29.99)
                    resultText = "Overweight";
                if(resultBmi >= 30.00)
                    resultText = "Obese";

                result.setText(resultText);

            }
        });
    }

    /**
     * Validating form
     */
    private void submitForm() {
        if (!validateWeight()) {
            return;
        }

        if (!validateHeight()) {
            return;
        }
    }

    private boolean validateWeight() {
        String wtValue = wt.getText().toString().trim();

        if (wt.getText().toString().trim().isEmpty()) {
            inputLayoutWeight.setError(getString(R.string.err_msg_wt));
            requestFocus(wt);
            return false;
        } else {
            weight = Integer.parseInt(wtValue);
            inputLayoutWeight.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateHeight() {
        String htValue = ht.getText().toString().trim();

        if (htValue.isEmpty()) {
            inputLayoutHeight.setError(getString(R.string.err_msg_ht));
            requestFocus(ht);
            return false;
        } else {
            height = Integer.parseInt(htValue);
            inputLayoutHeight.setErrorEnabled(false);
        }

        return true;
    }




    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.WeightBmi:
                    validateWeight();
                    break;
                case R.id.HeightBmi:
                    validateHeight();
                    break;

            }
        }
     }
}
