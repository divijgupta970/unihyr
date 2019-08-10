package divij.com.unihyr;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import divij.com.unihyr.Adapters.PositionsRecyclerAdapter;
import divij.com.unihyr.UtilClasses.Products;


/**
 * A simple {@link Fragment} subclass.
 */
public class PositionsFragment extends Fragment {
    Spinner spinner;
    RecyclerView recyclerView;
    List<Products> productList;
    FloatingActionButton fab;

    public PositionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_positions, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        fab=v.findViewById(R.id.positionsFab);
        spinner=v.findViewById(R.id.positionsSpinner);
        recyclerView=v.findViewById(R.id.positionsRecyclerView);
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
        productList = new ArrayList<>();
        productList.add(new Products("FIN437","Management Trainee","Bangalore","Jojin Joseph",1,0,0,1,true));
        productList.add(new Products("FIN437","Management Trainee","Bangalore","Jojin Joseph",1,0,0,1,true));
        productList.add(new Products("FIN437","Management Trainee","Bangalore","Jojin Joseph",1,0,0,1,true));
        productList.add(new Products("FIN437","Management Trainee","Bangalore","Jojin Joseph",1,0,0,1,true));
        productList.add(new Products("FIN437","Management Trainee","Bangalore","Jojin Joseph",1,0,0,1,true));
        productList.add(new Products("FIN437","Management Trainee","Bangalore","Jojin Joseph",1,0,0,1,true));
        productList.add(new Products("FIN437","Management Trainee","Bangalore","Jojin Joseph",1,0,0,1,false));
        final PositionsRecyclerAdapter recyclerAdapter=new PositionsRecyclerAdapter(getActivity(),productList);
        recyclerView.setAdapter(recyclerAdapter);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.positions_spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}
