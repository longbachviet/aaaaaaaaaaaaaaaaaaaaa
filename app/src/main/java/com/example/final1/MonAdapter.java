package com.example.final1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;


import com.example.final1.Helper.ManagementCart;
import com.example.final1.Interface.ChangeNumberItemsListener;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MonAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<ProductModel> ProductModelList;
    ManagementCart managementCart;
    private ChangeNumberItemsListener changeNumberItemsListener;

    public MonAdapter(Context context, int layout, ArrayList<ProductModel> ProductModelList, ChangeNumberItemsListener changeNumberItemsListener) {
        this.context = context;
        this.layout = layout;
        this.ProductModelList = ProductModelList;
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @Override
    public int getCount() {
        return ProductModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        // ánh xạ view
        TextView txttenProductModel = (TextView) view.findViewById(R.id.tv4);
        TextView txtgia = (TextView) view.findViewById(R.id.tien);
        TextView txtSoLuong = (TextView) view.findViewById(R.id.soluong);
        Button dec = (Button) view.findViewById(R.id.xoa);
        Button inc = (Button) view.findViewById(R.id.them);
        managementCart = new ManagementCart(view.getContext());
        changeNumberItemsListener = changeNumberItemsListener;
        // Gán Giá tri

        txttenProductModel.setText(ProductModelList.get(i).getProductName());
        txtgia.setText(currencyFormat(Double.parseDouble(ProductModelList.get(i).getProductPrice())) + " VNĐ");
        txtSoLuong.setText(String.valueOf(ProductModelList.get(i).getSoluongdathang()));
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managementCart.MinusNumerFood(ProductModelList, i, new ChangeNumberItemsListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemsListener.changed();
                    }
                });
            }
        });

        inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                managementCart.plusNumberFood(ProductModelList, i, new ChangeNumberItemsListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemsListener.changed();
                    }
                });
            }
        });


        return view;
    }

    public static String currencyFormat(Double amount) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format((amount));
    }
}
