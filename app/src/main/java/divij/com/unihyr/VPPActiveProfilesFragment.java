package divij.com.unihyr;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class VPPActiveProfilesFragment extends Fragment {
    Spinner selectChannelSpinner;
    Spinner selectStatusSpinner;

    public VPPActiveProfilesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_vppactive_profiles, container, false);
        selectChannelSpinner=v.findViewById(R.id.spinnerSelectChannel);
        selectStatusSpinner=v.findViewById(R.id.spinnerSelectStatus);
        ArrayAdapter<CharSequence> adapter1= ArrayAdapter.createFromResource(getActivity(),
                R.array.select_status_spinner_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.select_chanel_spinner_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectChannelSpinner.setAdapter(adapter2);
        selectStatusSpinner.setAdapter(adapter1);
        return v;
    }

}
