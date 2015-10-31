package shugal.com.msanjeevani;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by abhishek on 31/10/15.
 */
public class SampleListAdapter extends ArrayAdapter<SampleData> {

    public SampleListAdapter(Context context, List<SampleData> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        SampleData data = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_samples, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView doctor = (TextView) convertView.findViewById(R.id.doctor);
        TextView status = (TextView) convertView.findViewById(R.id.status);

        TextView bloodGroup = (TextView) convertView.findViewById(R.id.bloodGroup);
        TextView platelet = (TextView) convertView.findViewById(R.id.platelet);
        TextView rbc = (TextView) convertView.findViewById(R.id.rbc);
        TextView wbc = (TextView) convertView.findViewById(R.id.wbc);



        name.setText(data.getPatient_name());
        doctor.setText("Sample Type: " + data.getSample());
        status.setText("Date: "+data.getDate());
        bloodGroup.setText("Bloodgroup: O+ve");
        platelet.setText("Platelet: 175k");
        rbc.setText("RBC: 5.2 Milllion");
        wbc.setText("WBC: 4300 cells/cubic ml");


        return convertView;

    }
}