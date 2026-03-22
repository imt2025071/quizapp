package com.example.activity_4;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.activity_4.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final EditText principle= findViewById(R.id.editTextText);
        final EditText year= findViewById(R.id.editTextText4);
        final EditText fraction= findViewById(R.id.editTextText3);
        final EditText rate= findViewById(R.id.editTextText2);
        final TextView OutPut= findViewById(R.id.textView5);

        Button enterButton= findViewById(R.id.button);
        Button clearButton=findViewById(R.id.button2);

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String PrincipleData=principle.getText().toString();
                String yearData=year.getText().toString();
                String fractionData=fraction.getText().toString();
                String rateData=rate.getText().toString();
                double p= Double.valueOf(PrincipleData);
                double r= Double.valueOf(rateData);
                double t= Double.valueOf(yearData);
                double n= Double.valueOf(fractionData);
                double A= p*(r/n)/100*(n*t);
                double B= p*(Math.pow((1+(r/n)*100),n*t));
                OutPut.setText("Simple Interest: "+A+
                        "\n Compound Interest: "+(B-p)+
                        "\nFinal amount with CI: "+B+
                        "\nFinal amount with SI: "+(A+p));
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                principle.setText("");
                year.setText("");
                rate.setText("");
                fraction.setText("");
                OutPut.setText(" ");
            }
        });
    }
}