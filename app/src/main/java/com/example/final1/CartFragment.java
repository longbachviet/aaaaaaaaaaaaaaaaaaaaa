package com.example.final1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.final1.Helper.ManagementCart;
import com.example.final1.Interface.ChangeNumberItemsListener;

import java.text.DecimalFormat;

public class CartFragment extends Fragment {
    ListView lvmonGH;
    ManagementCart managementCart;
    Button mua;
    TextView total;
    MonAdapter  monGHAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_donhang, container, false);
        total = (TextView) view.findViewById(R.id.total);
        mua = (Button) view.findViewById(R.id.btnTHTT);
        managementCart = new ManagementCart(getContext());
        lvmonGH = (ListView) view.findViewById(R.id.rvcart);
        monGHAdapter= new MonAdapter(getContext(), R.layout.item_cart, managementCart.getListCard(), new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                calculateCard();
            }
        });
        lvmonGH.setAdapter(monGHAdapter);
        return view;
    }

    private void calculateCard() {
        total.setText(currencyFormat(managementCart.getTotalFee()) + " VNĐ");
    }

    public static String currencyFormat(Double amount) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format((amount));
    }

}
