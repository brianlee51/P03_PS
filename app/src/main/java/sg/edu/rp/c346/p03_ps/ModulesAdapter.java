package sg.edu.rp.c346.p03_ps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ModulesAdapter extends ArrayAdapter<Modules> {
    private ArrayList<Modules> modules;
    private Context context;
    private TextView tvMCode, tvMName;

    public ModulesAdapter(Context context, int resource, ArrayList<Modules> objects) {
        super(context, resource, objects);
        modules = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvMCode = rowView.findViewById(R.id.textViewModuleCode);
        tvMName = rowView.findViewById(R.id.textViewModuleName);

        Modules currentModule = modules.get(position);

        tvMCode.setText(currentModule.getModuleCode());
        tvMName.setText(currentModule.getModuleName());

        return rowView;
    }
}
