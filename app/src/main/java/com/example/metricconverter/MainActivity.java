package com.example.metricconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText numInput;
    TextView dpMG, dpG, dpKG, dpMT;
    double num=0, mg=0, g=0, kg=0, mt=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner MetricUnits=findViewById(R.id.MetricUnits);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MetricUnits.setAdapter(adapter);
        MetricUnits.setOnItemSelectedListener(this);

        numInput=findViewById(R.id.Number);
        dpMG=findViewById(R.id.MgRes);
        dpG=findViewById(R.id.GRes);
        dpKG=findViewById(R.id.KGRes);
        dpMT=findViewById(R.id.MTRes);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (parent.getItemAtPosition(position).equals("Choose Unit"))
        {
            numInput.setEnabled(false);
        }

        else if (parent.getItemAtPosition(position).equals("Milligram"))
        {
                numInput.setEnabled(true);
//                if (numInput.getText().equals("")) {
//                    numInput.setText(String.valueOf(0));
//                }
                numInput.setText(String.valueOf(0));
                numInput.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if(numInput.getText().length() < 1) numInput.setText(String.valueOf(0));
                        Toast.makeText(MainActivity.this, numInput.getText(), Toast.LENGTH_SHORT).show();
                        num = Double.parseDouble(numInput.getText().toString());
                        mg = num;
                        g = num * 1000;
                        kg = num * 1000000;
                        mt = num * 1000000000;

                        dpMG.setText(String.valueOf(mg));
                        dpG.setText(String.valueOf(g));
                        dpKG.setText(String.valueOf(kg));
                        dpMT.setText(String.valueOf(mt));

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

        }
        else {

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        // TODO Auto-generated method stub
    }
}