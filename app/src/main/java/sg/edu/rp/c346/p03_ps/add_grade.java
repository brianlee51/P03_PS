package sg.edu.rp.c346.p03_ps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class add_grade extends AppCompatActivity {

    TextView tvWeek;
    Button btnSubmit;
    RadioGroup rgGrades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grade);
        tvWeek = findViewById(R.id.textViewWeek);
        btnSubmit = findViewById(R.id.buttonSubmit);
        rgGrades = findViewById(R.id.rgGradesGroup);

        Intent i = getIntent();
        int number = i.getIntExtra("number",0) + 1;

        tvWeek.setText("Week " + number);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedButton = rgGrades.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selectedButton);
                String grade = rb.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("grade", grade);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
