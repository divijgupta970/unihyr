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

import divij.com.unihyr.CardClasses.driver_ka;
import divij.com.unihyr.R;

public class driverCaredAdapter extends RecyclerView.Adapter<driverCaredAdapter.driverCaredAdapterViewHolder>{
private Context mCtx;
private List<driver_ka> driver_ka;
    public driverCaredAdapter(Context mCtx, List<driver_ka> driver_ka)
{
    this.mCtx=mCtx;
    this.driver_ka.clear();
    this.driver_ka=new ArrayList<>();
    this.driver_ka.addAll(driver_ka);
}

    @NonNull
    @Override
    public driverCaredAdapter.driverCaredAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mCtx);
        View view=inflater.inflate(R.layout.drivecard_ka, null);
        return new driverCaredAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull driverCaredAdapter.driverCaredAdapterViewHolder holder, final int position) {
        holder.infoButton_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               driver_ka currentItem=driver_ka.get(position);

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
        holder.drive.setText(driver_ka.get(position).getDrive());
        holder.postion.setText(driver_ka.get(position).getPosition());
        holder.contact.setText(driver_ka.get(position).getCont_person());
        holder.location.setText(driver_ka.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return driver_ka.size();
    }
    class  driverCaredAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView drive,location,postion,contact;
        ImageView infoButton_d;
        public driverCaredAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            drive =itemView.findViewById(R.id.ddriveId);
            location=itemView.findViewById(R.id.dlocationId);
            postion= itemView.findViewById(R.id.dpositionId);
            contact=itemView.findViewById(R.id.dsaleId);
            infoButton_d=itemView.findViewById(R.id.infoButton_p);
        }
    }
}
