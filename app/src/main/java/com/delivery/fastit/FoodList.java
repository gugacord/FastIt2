package com.delivery.fastit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.delivery.fastit.Interface.ItemClickListener;
import com.delivery.fastit.ViewHolder.Item;
import com.delivery.fastit.ViewHolder.ItemViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class FoodList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference foodList;

    String categoryId="";

    FirebaseRecyclerAdapter<Item, ItemViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);

        //Firebase
        database = FirebaseDatabase.getInstance();
        foodList = database.getReference("Item");

        recyclerView = (RecyclerView)findViewById(R.id.recycler_food);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Get Intent Here
        if (getIntent() !=null)
            categoryId = getIntent().getStringExtra("CategoryId");
        if (!categoryId.isEmpty() && categoryId != null)
        {
            loadListFood(categoryId);
        }


    }

    private void loadListFood(String categoryId) {
        adapter = new FirebaseRecyclerAdapter<Item, ItemViewHolder>(Item.class,R.layout.menu_item,ItemViewHolder.class,foodList.orderByChild("MenuId").equalTo(categoryId))

        {
            @Override
            protected void populateViewHolder(ItemViewHolder viewHolder, Item model, int position) {
                viewHolder.item_name.setText(model.getName());
                Picasso.get().load(model.getImage())
                        .into(viewHolder.item_image);

                final Item local = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void OnClick(View view, int position, boolean isLongClick) {
                        Toast.makeText(FoodList.this,""+local.getName(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onClick(View view, int adapterPosition, boolean b) {

                    }
                });
            }
        };

        //set adapter
        Log.d("TAG",""+adapter.getItemCount());
        recyclerView.setAdapter(adapter);
    }
}
