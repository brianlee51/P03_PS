package sg.edu.rp.c346.p03_ps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvModule;
    ArrayList<Modules> moduleList;
    ModulesAdapter caModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("View Activities");

        lvModule = findViewById(R.id.listViewHome);
        moduleList = new ArrayList<>();
        Modules item1 = new Modules("C347", "Android Programming II");
        Modules item2 = new Modules("C302", "Web Services");
        moduleList.add(item1);
        moduleList.add(item2);
        caModule = new ModulesAdapter(this, R.layout.activity_main, moduleList);

        lvModule.setAdapter(caModule);
        lvModule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), module_detail.class);
                Modules currentMod = moduleList.get(position);
                intent.putExtra("code", currentMod.getModuleCode());
                startActivity(intent);
            }
        });
    }
}
