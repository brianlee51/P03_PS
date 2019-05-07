package sg.edu.rp.c346.p03_ps;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class module_detail extends AppCompatActivity {

    Button btnInfo, btnAdd, btnEmail;
    ListView lvGrades;
    ArrayAdapter aaAdapter;
    ArrayList<Details> dailyGrades;

    private final static int REQUEST_CODE_1 = 1;
    private Intent dataIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_detail);
        Intent intentReceived = getIntent();
        final String moduleCode = intentReceived.getStringExtra("code");
        setTitle("Info for " + moduleCode);

        btnInfo = findViewById(R.id.buttonInfo);
        btnAdd = findViewById(R.id.buttonAdd);
        btnEmail = findViewById(R.id.buttonEmail);
        lvGrades = findViewById(R.id.listViewGrades);

        dailyGrades = new ArrayList<Details>();
        if (moduleCode.equalsIgnoreCase("C347")) {
            dailyGrades.add(new Details(1, "B"));
            dailyGrades.add(new Details(2, "C"));
            dailyGrades.add(new Details(3, "A"));
        } else if (moduleCode.equalsIgnoreCase("C302")) {
            dailyGrades.add(new Details(1, "F"));
            dailyGrades.add(new Details(2, "F"));
            dailyGrades.add(new Details(3, "F"));
        }

        aaAdapter = new DGAdapter(this, R.layout.row_for_details, dailyGrades);
        lvGrades.setAdapter(aaAdapter);

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (moduleCode.equalsIgnoreCase("C347")) {
                    Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                    rpIntent.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C347"));
                    startActivity(rpIntent);
                } else if (moduleCode.equalsIgnoreCase("C302")) {
                    Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                    rpIntent.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C302"));
                    startActivity(rpIntent);
                }
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Hi faci,\nI am ...\n \nPlease see my remarks so far, thank you!\n\n";
                for (int i = 0; i < dailyGrades.size(); i++) {
                    message += "Week "+dailyGrades.get(i).getWeek() + ": DG: " + dailyGrades.get(i).getGrade() + "\n";
                }
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT, "");
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(module_detail.this, add_grade.class);
                int number = dailyGrades.get(dailyGrades.size() - 1).getWeek();
                i.putExtra("number", number);
                startActivityForResult(i, REQUEST_CODE_1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE_1:
                if (resultCode == RESULT_OK) {
                    String grade = data.getStringExtra("grade");
                    dailyGrades.add(new Details(dailyGrades.get(dailyGrades.size() - 1).getWeek()+1, grade));
                    aaAdapter.notifyDataSetChanged();
                }
        }
    }


}
