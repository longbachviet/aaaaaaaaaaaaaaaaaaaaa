package com.example.final1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.final1.Helper.ManagementCart;

import java.text.DecimalFormat;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private Context context;
    private List<ProductModel> arrContact;
    private ManagementCart managementCart;

    public CustomAdapter(Context context, List<ProductModel> arrContact) {
        this.context = context;
        this.arrContact = arrContact;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false);
        managementCart = new ManagementCart(view.getContext());
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductModel listModel = arrContact.get(position);
        holder.name.setText(listModel.getProductName());
        holder.price.setText(currencyFormat(Double.parseDouble(listModel.getProductPrice())) + " VNĐ");

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductModel tempMon = arrContact.get(position);
                tempMon.setSoluongdathang(1);
                managementCart.insertFood(tempMon);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrContact.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView price, name;
        Button add;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            price = (TextView) itemView.findViewById(R.id.price);
            name = (TextView) itemView.findViewById(R.id.name);
            add = (Button) itemView.findViewById(R.id.dathang);
        }
    }
    public static String currencyFormat(Double amount) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format((amount));
    }

}

