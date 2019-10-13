package divij.com.unihyr.Adapters;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


import divij.com.unihyr.CardClasses.driver_past;
import divij.com.unihyr.R;
public class driver_past_Adapter extends RecyclerView.Adapter<driver_past_Adapter.driver_past_AdapterViewHolder> {
    private Context mCtx;
    private List<driver_past> driver_past;
    public driver_past_Adapter(Context mCtx, ArrayList<driver_past> driver_past)
    {
        this.mCtx=mCtx;
        this.driver_past.clear();
        this.driver_past=new ArrayList<>();
        this.driver_past.addAll(driver_past);
    }

    @NonNull
    @Override
    public driver_past_Adapter.driver_past_AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mCtx);
        View view=inflater.inflate(R.layout.driver_past_card, null);
        return new driver_past_AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull driver_past_Adapter.driver_past_AdapterViewHolder holder, final int position) {
        holder.infobutton_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                driver_past currentItem=driver_past.get(position);

                Log.d(PositionsRecyclerAdapter.class.getSimpleName(),"info clicked");
                String moreInfoMessage="\nDate & Time: "+currentItem.getDate()
                        +"\n\ncandidates: "+currentItem.getCandidate()
                        +"\n\nShortListed: "+currentItem.getShortlisted()
                        +"\n\nRejected: "+currentItem.getReject()
                        +"\n\nNO.Show: "+currentItem.getNoshow();
                AlertDialog.Builder builder=new AlertDialog.Builder(mCtx);
                builder.setTitle("More Info");
                builder.setMessage(moreInfoMessage);
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });
        holder.drive.setText(driver_past.get(position).getDrive());
        holder.postion.setText(driver_past.get(position).getPosition());
        holder.contact.setText(driver_past.get(position).getCont_person());
        holder.location.setText(driver_past.get(position).getLocation());
    }


    @Override
    public int getItemCount() {
        return driver_past.size();
    }
    class driver_past_AdapterViewHolder extends RecyclerView.ViewHolder {
TextView drive,postion,location, contact;
ImageView infobutton_p;
        public driver_past_AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            drive=itemView.findViewById(R.id.pdriveId);
            postion=itemView.findViewById(R.id.ppositionId);
            location=itemView.findViewById(R.id.plocationId);
            contact=itemView.findViewById(R.id.psaleId);
            infobutton_p=itemView.findViewById(R.id.infoButton_p);
        }
    }
}
