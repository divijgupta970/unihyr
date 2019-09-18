package divij.com.unihyr;


import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import divij.com.unihyr.UtilClasses.NetworkUtils;

public class fetchDataPositions extends AsyncTask<String,Void,String> {
    public static ArrayList<String> finalData=new ArrayList<>();
    public static JSONArray JA;
    private OnPositionsFetched listener;
    public fetchDataPositions(OnPositionsFetched listener){
        this.listener=listener;
    }
    @Override
    protected String doInBackground(String... strings) {
        return NetworkUtils.getInfo(strings[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            finalData.clear();
            JA= new JSONArray(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        listener.OnPositionsFetched();
    }
}
