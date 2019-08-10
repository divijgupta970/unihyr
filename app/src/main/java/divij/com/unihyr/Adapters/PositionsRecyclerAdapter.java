package divij.com.unihyr.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import divij.com.unihyr.PositionsFragment;
import divij.com.unihyr.R;
import divij.com.unihyr.UtilClasses.Products;

public class PositionsRecyclerAdapter extends RecyclerView.Adapter<PositionsRecyclerAdapter.ProductViewHolder> {


    private Context mCtx;
    private ArrayList<Products> productList;

    public PositionsRecyclerAdapter(Context mCtx, ArrayList<Products> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.positions_cardview, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, final int position) {
        Products product = productList.get(position);
        holder.textViewPosition.setText(product.getPosition());
        holder.textViewLocation.setText(product.getLocation());
        holder.textViewInitiator.setText(product.getInitiator());
        holder.textViewId.setText(product.getId());
        if(product.isActivated()){
            holder.deactivateButton.setVisibility(View.VISIBLE);
            holder.activatedButton.setVisibility(View.INVISIBLE);
            holder.editButton.setVisibility(View.VISIBLE);
        }
        else{
            holder.deactivateButton.setVisibility(View.INVISIBLE);
            holder.activatedButton.setVisibility(View.VISIBLE);
            holder.editButton.setVisibility(View.INVISIBLE);
        }
        holder.deactivateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(mCtx);
                builder.setTitle("Deactivation");
                builder.setMessage("Are you sure?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        productList.get(position).setActivated(false);
                        PositionsFragment.productList.get(position).setActivated(false);
                        notifyDataSetChanged();
                        //int temp=PositionsFragment.spinner.getSelectedItemPosition();
                        PositionsFragment.spinner.setSelection(0);
                        //PositionsFragment.spinner.setSelection(temp);
                        Toast.makeText(mCtx, "Deactivated", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.show();
            }
        });
        holder.activatedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(mCtx);
                builder.setTitle("Activation");
                builder.setMessage("Are you sure?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        productList.get(position).setActivated(true);
                        PositionsFragment.productList.get(position).setActivated(true);
                        notifyDataSetChanged();
                        //int temp=PositionsFragment.spinner.getSelectedItemPosition();
                        PositionsFragment.spinner.setSelection(0);
                        //PositionsFragment.spinner.setSelection(temp);
                        Toast.makeText(mCtx, "Activated", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textViewPosition, textViewLocation, textViewInitiator, textViewId;
        ImageView editButton,activatedButton,deactivateButton;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewPosition = itemView.findViewById(R.id.textViewPosition);
            textViewLocation = itemView.findViewById(R.id.textViewLocation);
            textViewInitiator = itemView.findViewById(R.id.textViewInitiator);
            textViewId=itemView.findViewById(R.id.positionId);
            editButton=itemView.findViewById(R.id.editButton);
            activatedButton=itemView.findViewById(R.id.activateButton);
            deactivateButton=itemView.findViewById(R.id.deactivateButton);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Products currItem=productList.get(getLayoutPosition());
            String moreInfoMessage="\nUpcoming: "+currItem.getUpcoming()+"\n\nOngoing: "+currItem.getOngoing()+"\n\nPast: "+currItem.getPast()+"\n\nTotalProfiles: "+currItem.getTotalProfiles();
            AlertDialog.Builder builder=new AlertDialog.Builder(mCtx);
            builder.setTitle("More Info");
            builder.setMessage(moreInfoMessage);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.show();
        }
    }
}
