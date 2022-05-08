package com.example.wonderv2.AR;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wonderv2.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;
import java.util.List;

public class AR_card_adapter extends RecyclerView.Adapter<AR_card_adapter.MyHolder> {

    private Context context;
    private ArrayList<AR_card_model> arrayList;


    public AR_card_adapter(ArrayList<AR_card_model> arrayList,Context context){
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ar_card, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AR_card_adapter.MyHolder holder, int i) {
        final String shop_name = arrayList.get(i).getShop_name();
        final String item_name = arrayList.get(i).getItem_name();
        final String item_gram = arrayList.get(i).getItem_gram();
        final String item_price = arrayList.get(i).getItem_price();

        if(shop_name != null){
            holder.shopName.setText(shop_name);
            holder.itemName.setText(item_name);
            holder.itemGram.setText(item_gram);
            holder.itemPrice.setText(item_price);
        }

    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView shopName, itemName, itemGram, itemPrice;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            this.shopName = itemView.findViewById(R.id.shop_name);
            this.itemName = itemView.findViewById(R.id.item_name);
            this.itemGram = itemView.findViewById(R.id.item_gram);
            this.itemPrice = itemView.findViewById(R.id.item_price);
        }
    }
}
