package divij.com.unihyr.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import divij.com.unihyr.R;
import divij.com.unihyr.UtilClasses.Products;

public class PositionsRecyclerAdapter extends RecyclerView.Adapter<PositionsRecyclerAdapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Products> productList;

    //getting the context and product list with constructor
    public PositionsRecyclerAdapter(Context mCtx, List<Products> productList) {
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
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Products product = productList.get(position);
        holder.textViewPosition.setText(product.getPosition());
        holder.textViewLocation.setText(product.getLocation());
        holder.textViewInitiator.setText(product.getInitiator());
        holder.textViewId.setText(product.getId());
        if(product.isActivated()){
            holder.deactivateButton.setVisibility(View.INVISIBLE);
        }
        else{
            holder.activatedButton.setVisibility(View.INVISIBLE);
            holder.editButton.setVisibility(View.INVISIBLE);
        }

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

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
        }
    }
}
