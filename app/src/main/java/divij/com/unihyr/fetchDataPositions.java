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
    private static final String LOG_TAG = fetchDataPositions.class.getSimpleName();
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
            JSONArray JA = new JSONArray(s);
            for(int i =0 ;i <JA.length(); i++){
                JSONObject JO = (JSONObject) JA.get(i);
                finalData.add(JO.getString("title"));
                Log.d(LOG_TAG,JO.getString("title"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        listener.OnPositionsFetched();
    }
    public static ArrayList<String> getArrayList(){
        return finalData;
    }
}
