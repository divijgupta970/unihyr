package divij.com.unihyr;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import divij.com.unihyr.Adapters.PositionsRecyclerAdapter;
import divij.com.unihyr.UtilClasses.Products;


/**
 * A simple {@link Fragment} subclass.
 */
public class PositionsFragment extends Fragment{
    public static Spinner spinner;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    FloatingActionButton fab;
    JSONArray result;
    EditText search_bar;

    public PositionsFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_positions, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        fab=v.findViewById(R.id.positionsFab);
        progressBar=v.findViewById(R.id.progressBarPositions);
        progressBar.setVisibility(View.VISIBLE);
        spinner=v.findViewById(R.id.positionsSpinner);
        recyclerView=v.findViewById(R.id.positionsRecyclerView);
        search_bar=v.findViewById(R.id.positionsSearchEditText);
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
        new fetchDataPositions(new OnPositionsFetched() {
            @Override
            public void OnPositionsFetched() {
                Log.d(PositionsFragment.class.getSimpleName(),"It executed!");
                progressBar.setVisibility(View.INVISIBLE);
                ArrayList<Products> productList = new ArrayList<>();
                productList.clear();
                result=fetchDataPositions.JA;
                for(int i =0 ;i <result.length(); i++){
                    try {
                        JSONObject JO = (JSONObject) result.get(i);
                        productList.add(new Products(JO.getString("jobCode"),JO.getString("title"),JO.getString("location"),JO.getString("initiator"),JO.getString("spoc"),JO.getInt("noOfPosts"),JO.getBoolean("active")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                final PositionsRecyclerAdapter recyclerAdapter=new PositionsRecyclerAdapter(getActivity(),productList,getActivity());
                search_bar.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        recyclerAdapter.getFilter().filter(s);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.setJsonArray(result);
            }
        }).execute("https://demorms.unihyr.com/demo/api/allpost");
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.positions_spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0://TODO: Add all here
                        break;
                    case 1://TODO: Add active here
                        break;
                    case 2://TODO: Add inactive here
                        break;
                    case 3://TODO: Add pending approval here
                        break;
                    case 4://TODO: Add pending validation here
                        break;
                    case 5://TODO: Add closed here
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
