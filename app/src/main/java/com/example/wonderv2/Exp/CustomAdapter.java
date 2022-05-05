package com.example.wonderv2.Exp;

import android.app.AlertDialog;
import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wonderv2.R;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<productList> arrayList;
    private Context context;

    public CustomAdapter(ArrayList<productList> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.productlist_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        //      Glide.with(holder.itemView).load(arrayList.get(position).getShopName()).into(holder.tv_shopName);
        //    holder.tv_productName.setText(arrayList.get(position).getProductName());
        //  holder.tv_expDay.setText(arrayList.get(position).getExpDay());
        holder.tv_shopName.setText(String.valueOf(arrayList.get(position).getShopName()));
        holder.tv_productName.setText(String.valueOf(arrayList.get(position).getProductName()));
        holder.tv_expDay.setText(String.valueOf(arrayList.get(position).getExpDay()));
        holder.tv_dDay.setText(String.valueOf(arrayList.get(position).getDDay()));
    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        TextView tv_shopName;
        TextView tv_productName;
        TextView tv_expDay;
        TextView tv_dDay;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_shopName = itemView.findViewById(R.id.tv_shopName);
            this.tv_productName = itemView.findViewById(R.id.tv_productName);
            this.tv_expDay = itemView.findViewById(R.id.tv_expDay);
            this.tv_dDay = itemView.findViewById(R.id.tv_dDay);

            itemView.setOnCreateContextMenuListener(this);

        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            MenuItem Delete = menu.add(Menu.NONE, 1001, 1, "삭제");
            Delete.setOnMenuItemClickListener(onEditMenu);
        }

        private final MenuItem.OnMenuItemClickListener onEditMenu = new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case 1001:
                        arrayList.remove(getAdapterPosition());
                        notifyItemRemoved(getAdapterPosition());
                        notifyItemRangeChanged(getAdapterPosition(), arrayList.size());

                        break;
                }
                return true;
            }
        };
    }
}
