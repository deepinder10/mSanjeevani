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
public class CustomAppointmentAdapter extends ArrayAdapter<AppointmentData> {

    public CustomAppointmentAdapter(Context context, List<AppointmentData> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        AppointmentData data = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_appointments, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView hospital = (TextView) convertView.findViewById(R.id.hospital);
        TextView doctor = (TextView) convertView.findViewById(R.id.doctor);
        TextView status = (TextView) convertView.findViewById(R.id.status);



        name.setText(data.getPatient_name());
        hospital.setText(data.getHospital());
        doctor.setText(data.getDoctor());
        status.setText("Status: "+data.getStatus());

        return convertView;

    }
}