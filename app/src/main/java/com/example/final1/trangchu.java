package com.example.final1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class trangchu extends AppCompatActivity {
        Button  taikhoan, tb, thayd, dhpr, combo2, combo3;
        TextView diachi;
        Database database;
    String Sten,Sphuongxa,Squanhuyen,Ssonha,Stinhthanh;
    ListView list_piz;
    ArrayList<listpizza> arraylispizza;
    DataAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_trangchu);
        database = new Database(this, "user.sqlite", null, 1);


        taikhoan = (Button) findViewById(R.id.tk);
        tb = (Button) findViewById(R.id.thongbao);

        thayd = (Button) findViewById(R.id.thaydoi);
        dhpr = (Button) findViewById(R.id.dh);
        combo2 = (Button)findViewById(R.id.cb2);
        combo3 = (Button)findViewById(R.id.cb3);
        diachi = (TextView)findViewById(R.id.tc_diachi);


        Cursor datauser = database.GetData("select * from thongtinuser2 where taikhoanuser = '"+dangnhap.tk+"'");
        while (datauser.moveToNext()) {
            Sten = datauser.getString(3);

            Stinhthanh = datauser.getString(8);
            Squanhuyen = datauser.getString(9);
            Sphuongxa = datauser.getString(10);
            Ssonha = datauser.getString(11);
            Sten = Ssonha+" , " + Sphuongxa+" , " + Squanhuyen+" , " + Stinhthanh;

        }
        diachi.setText(Sten);


        combo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentcb2 = new Intent(trangchu.this, combo_nhom.class);
                startActivity(intentcb2);
            }
        });
        combo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentcb2 = new Intent(trangchu.this, cb_uudai.class);
                startActivity(intentcb2);
            }
        });
        dhpr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(trangchu.this, donhangpr.class);
                startActivity(intent);
            }
        });
        thayd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(trangchu.this, themdiachimoi.class);
                startActivity(intent);
            }
        });
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(trangchu.this, thongbao.class);
                startActivity(intent);
            }
        });
        taikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(trangchu.this, canhan.class);
                startActivity(intent);
            }
        });

        Anhxa();
        adapter = new DataAdapter(this, R.layout.item_name, arraylispizza);
        list_piz.setAdapter(adapter);
    }
    private void Anhxa(){
        list_piz = (ListView) findViewById(R.id.list_view);
        arraylispizza = new ArrayList<>();

        arraylispizza.add(new listpizza("COMBO PIZZAHUB A 145.000??","1 Pizza th???p c???m size L","1 Pizza b?? ph?? mai + 1 pepsi",R.drawable.cb111));
        arraylispizza.add(new listpizza("COMBO PIZZAHUB MIX 99.000??","2 Pizza th???p c???m v?? ph?? mai","Khoai t??y chi??n + 1 coca",R.drawable.combo1));
        arraylispizza.add(new listpizza("COMBO PIZZAHUB B 125.000??","1 M??? ?? t??m th???t","1 Pizza t??? ch???n",R.drawable.combo12));
        arraylispizza.add(new listpizza("COMBO PIZZAHUB A 145.000??","1 Pizza th???p c???m","1 Pizza th???p c???m",R.drawable.cb111));
    }
}