package sg.edu.rp.c346.p03_ps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DGAdapter extends ArrayAdapter<Details> {
    private ArrayList<Details> details;
    private Context context;
    private TextView tvWeek, tvGrade;
    private ImageView ivImage;


    public DGAdapter(Context context, int resource, ArrayList<Details> objects) {
        super(context, resource, objects);
        details = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_for_details, parent, false);

        tvWeek = rowView.findViewById(R.id.textViewWeek);
        tvGrade = rowView.findViewById(R.id.textViewGrade);

        ivImage = rowView.findViewById(R.id.imageView);

        Details currentGrade = details.get(position);

        tvWeek.setText("Week " + String.valueOf(currentGrade.getWeek()));
        tvGrade.setText(currentGrade.getGrade());
        ivImage.setImageResource(R.drawable.dg);

        return rowView;
    }
}
