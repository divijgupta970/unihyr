package divij.com.unihyr;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

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
    private MaterialSearchView searchView;
    private Toolbar toolbar;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    FloatingActionButton fab;
    JSONArray result;
    private TextView errorOccurred;

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
        toolbar=v.findViewById(R.id.search_toolbar_positions);
        recyclerView=v.findViewById(R.id.positionsRecyclerView);
        searchView=v.findViewById(R.id.search_view_positions);
        errorOccurred=v.findViewById(R.id.tvError);
        toolbar.inflateMenu(R.menu.menu_search_filter);
        MenuItem item=toolbar.getMenu().findItem(R.id.action_search);
        searchView.setMenuItem(item);
        MenuItem item2 = toolbar.getMenu().findItem(R.id.spinner);
        Spinner spinner = (Spinner) item2.getActionView();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.positions_spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
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
                progressBar.setVisibility(View.INVISIBLE);
                ArrayList<Products> productList = new ArrayList<>();
                productList.clear();
                if (fetchDataPositions.JA!=null) {
                    result = fetchDataPositions.JA;
                    for (int i = 0; i < result.length(); i++) {
                        try {
                            JSONObject JO = (JSONObject) result.get(i);
                            productList.add(new Products(JO.getString("jobCode"), JO.getString("title"), JO.getString("location"), JO.getString("initiator"), JO.getString("spoc"), JO.getInt("noOfPosts"), JO.getBoolean("active"), JO));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    final PositionsRecyclerAdapter recyclerAdapter = new PositionsRecyclerAdapter(getActivity(), productList, getActivity());
                    searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
                        @Override
                        public boolean onQueryTextSubmit(String query) {
                            return true;
                        }

                        @Override
                        public boolean onQueryTextChange(String newText) {
                            recyclerAdapter.getFilter().filter(newText);
                            return false;
                        }
                    });
                    recyclerView.setAdapter(recyclerAdapter);
                }else {
                    errorFunction();
                }
            }
        }).execute("https://demorms.unihyr.com/demo/api/allpost");
    }

    private void errorFunction() {
        progressBar.setVisibility(View.INVISIBLE);
        errorOccurred.setVisibility(View.VISIBLE);
    }
}
