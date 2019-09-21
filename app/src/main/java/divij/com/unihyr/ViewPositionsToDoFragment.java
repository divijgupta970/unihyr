package divij.com.unihyr;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.tabs.TabLayout;

import divij.com.unihyr.Adapters.ViewPositionsAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPositionsToDoFragment extends Fragment {
    Spinner spinner;
    public ViewPositionsToDoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_view_positions_to_do, container, false);
        spinner=v.findViewById(R.id.todoSpinner);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(getActivity(),
                R.array.todo_spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        return v;
    }

}
