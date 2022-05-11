package com.example.wonderv2.Exp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wonderv2.R;
import com.example.wonderv2.Setting.Setting_alarm;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<productList> arrayList;
    private Context context;
    private OnItemClickListener itemClickListener;
    private Intent intent;

    public interface OnItemClickListener{
        void onItemClick(View v, int pos);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.itemClickListener = listener;
    }




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

   //     holder.itemView.setTag(position);
   //     holder.itemView.setOnClickListener(new View.OnClickListener(){
   //         @Override
   //         public void onClick(View v){
   //             Intent intent = new Intent(context, Exp_detail.class);

   //             context.startActivity(intent);
   //         }
   //     });
    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView tv_shopName;
        TextView tv_productName;
        TextView tv_expDay;
        TextView tv_dDay;
        View itemView;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_shopName = itemView.findViewById(R.id.tv_shopName);
            this.tv_productName = itemView.findViewById(R.id.tv_productName);
            this.tv_expDay = itemView.findViewById(R.id.tv_expDay);
            this.tv_dDay = itemView.findViewById(R.id.tv_dDay);

       itemView.setClickable(true);
       itemView.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               int pos = getAdapterPosition();
               Context context = v.getContext();
               Intent Exp_detail = new Intent(context, com.example.wonderv2.Exp.Exp_detail.class);
               if(pos != RecyclerView.NO_POSITION){
                   Intent intent = new Intent(context, Exp_detail.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   intent.putExtra("shop", String.valueOf(arrayList.get(pos).getShopName()));
                   intent.putExtra("product", String.valueOf(arrayList.get(pos).getProductName()));
                   intent.putExtra("exp", String.valueOf(arrayList.get(pos).getExpDay()));
                   intent.putExtra("dday", String.valueOf(arrayList.get(pos).getDDay()));
                   intent.putExtra("ingredient", String.valueOf(arrayList.get(pos).getProductIngredient()));
                   intent.putExtra("guide", String.valueOf(arrayList.get(pos).getProductGuide()));
                   intent.putExtra("detail", String.valueOf(arrayList.get(pos).getProductDetail()));

                   context.startActivity(intent);
               }
           }
       });

    //        itemView.setOnCreateContextMenuListener(this);
    //        implements View.OnCreateContextMenuListener

        }

  //      @Override
  //      public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
  //          MenuItem Delete = menu.add(Menu.NONE, 1001, 1, "삭제");
  //          Delete.setOnMenuItemClickListener(onEditMenu);
  //      }

   //     private final MenuItem.OnMenuItemClickListener onEditMenu = new MenuItem.OnMenuItemClickListener() {
   //         @Override
   //         public boolean onMenuItemClick(MenuItem item) {
   //             switch (item.getItemId()) {
   //                 case 1001:
   //                     arrayList.remove(getAdapterPosition());
   //                     notifyItemRemoved(getAdapterPosition());
   //                     notifyItemRangeChanged(getAdapterPosition(), arrayList.size());

   //                     break;
   //             }
   //             return true;
   //         }
   //     };
    }
}

