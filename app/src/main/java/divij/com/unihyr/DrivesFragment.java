package divij.com.unihyr;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import divij.com.unihyr.Adapters.driverCaredAdapter;
import divij.com.unihyr.CardClasses.driver_ka;


/**
 * A simple {@link Fragment} subclass.
 */
public class DrivesFragment extends Fragment {
    private Spinner spinner;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private ArrayList<driver_ka> driver_ka;
    private driverCaredAdapter recyclerViewAdapter;
    private FloatingActionButton fab;

    public DrivesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_drives, container, false);
        return v;
    }
    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        progressBar=v.findViewById(R.id.pbActiveProfiles_driver);
        progressBar.setVisibility(View.VISIBLE);
        spinner=v.findViewById(R.id.spinnerDrives);
        fab=v.findViewById(R.id.fabDrives);
        recyclerView=v.findViewById(R.id.recyclerView_driver);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if(dy>0){
                    fab.hide();
                    return;
                }
                if(dy<0){
                    fab.show();
                }
            }
        });
        driver_ka=new ArrayList<>();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.drives_spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        driver_ka.clear();
                        progressBar.setVisibility(View.INVISIBLE);
                        driver_ka.add(new driver_ka("campus", "Delhi", "senior Analyst", "rohit", "5", "05 Oct 2019 10:00AM", "0", "0", "0"));
                        driver_ka.add(new driver_ka("campus", "Delhi", "senior Analyst", "rohit", "5", "05 Oct 2019 10:00AM", "0", "0", "0"));
                        driver_ka.add(new driver_ka("campus", "Delhi", "senior Analyst", "rohit", "5", "05 Oct 2019 10:00AM", "0", "0", "0"));
                        driver_ka.add(new driver_ka("campus", "Delhi", "senior Analyst", "rohit", "5", "05 Oct 2019 10:00AM", "0", "0", "0"));
                        driver_ka.add(new driver_ka("campus", "Delhi", "senior Analyst", "rohit", "5", "05 Oct 2019 10:00AM", "0", "0", "0"));
                        recyclerViewAdapter=new driverCaredAdapter(getActivity(),driver_ka,true);
                        recyclerView.setAdapter(recyclerViewAdapter);
                        break;
                    case 1:
                        driver_ka.clear();
                        progressBar.setVisibility(View.INVISIBLE);
                        driver_ka.add(new driver_ka("campus", "Delhi", "senior Analyst", "rohit", "5", "05 Oct 2019 10:00AM", "0", "0", "0"));
                        driver_ka.add(new driver_ka("campus", "Delhi", "senior Analyst", "rohit", "5", "05 Oct 2019 10:00AM", "0", "0", "0"));
                        driver_ka.add(new driver_ka("campus", "Delhi", "senior Analyst", "rohit", "5", "05 Oct 2019 10:00AM", "0", "0", "0"));
                        driver_ka.add(new driver_ka("campus", "Delhi", "senior Analyst", "rohit", "5", "05 Oct 2019 10:00AM", "0", "0", "0"));
                        driver_ka.add(new driver_ka("campus", "Delhi", "senior Analyst", "rohit", "5", "05 Oct 2019 10:00AM", "0", "0", "0"));
                        driver_ka.add(new driver_ka("campus", "Delhi", "senior Analyst", "rohit", "5", "05 Oct 2019 10:00AM", "0", "0", "0"));
                        recyclerViewAdapter=new driverCaredAdapter(getActivity(),driver_ka,true);
                        recyclerView.setAdapter(recyclerViewAdapter);
                        break;
                    case 2:
                        driver_ka.clear();
                        progressBar.setVisibility(View.INVISIBLE);
                        driver_ka.add(new driver_ka("asd", "sdf", "dfg", "ghj", "5", "05 Oct 2019 10:00AM", "1", "2", "3"));
                        driver_ka.add(new driver_ka("asd", "sdf", "dfg", "ghj", "5", "05 Oct 2019 10:00AM", "1", "2", "3"));
                        driver_ka.add(new driver_ka("asd", "sdf", "dfg", "ghj", "5", "05 Oct 2019 10:00AM", "1", "2", "3"));
                        driver_ka.add(new driver_ka("asd", "sdf", "dfg", "ghj", "5", "05 Oct 2019 10:00AM", "1", "2", "3"));
                        driver_ka.add(new driver_ka("asd", "sdf", "dfg", "ghj", "5", "05 Oct 2019 10:00AM", "1", "2", "3"));
                        driver_ka.add(new driver_ka("asd", "sdf", "dfg", "ghj", "5", "05 Oct 2019 10:00AM", "1", "2", "3"));
                        recyclerViewAdapter=new driverCaredAdapter(getActivity(),driver_ka,false);
                        recyclerView.setAdapter(recyclerViewAdapter);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    }

