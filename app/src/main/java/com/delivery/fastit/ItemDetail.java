package com.delivery.fastit;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class ItemDetail extends AppCompatActivity {

    TextView item_name, item_price, item_description;
    ImageView item_image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnCart;
    ElegantNumberButton numberButton;

    String itemID="";

    FirebaseDatabase database;
    DatabaseReference Item;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        //Firebase
        database = FirebaseDatabase.getInstance();
        Item = database.getReference("Item");

        //Init View
        numberButton = (ElegantNumberButton)findViewById(R.id.number_button);
        btnCart = (FloatingActionButton)findViewById(R.id.btnCart);
        item_description = (TextView)findViewById(R.id.item_description);
        item_name = (TextView)findViewById(R.id.item_name);
        item_price = (TextView)findViewById(R.id.item_price);
        item_image = (ImageView)findViewById(R.id.item_image);
        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.CollapsedAppBar);

        //Get Item Id from intent
        if(getIntent() !=null);
        itemID = Objects.requireNonNull(getIntent()).getStringExtra("itemID");
        if (!itemID.isEmpty());
        {
            getDetailItem(itemID);
        }



    }

    private void getDetailItem(final String itemID) {
        Item.child(itemID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ItemDetail itemDetail = dataSnapshot.getValue(ItemDetail.class);

                //Set image
                Picasso.get().load(ItemDetail.getImage())
                    .into(item_image);

                collapsingToolbarLayout.setTitle((CharSequence) item_name);

                assert itemDetail != null;
                item_price.setText(itemDetail.getPrice());

                item_name.setText(ItemDetail.getName());

                item_description.setText(ItemDetail.getDescription());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private static int getDescription() {
    }

    private static int getName() {
    }

    private int getPrice() {
    }

    private static int getImage() {
    }
}
