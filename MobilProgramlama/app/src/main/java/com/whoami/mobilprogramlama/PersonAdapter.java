package com.whoami.mobilprogramlama;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by tchzafer on 21/03/2018.
 */

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.MyViewHolder> {

    ArrayList<Person> mProductList;
    LayoutInflater inflater;
    Switch personSwitch;

    public PersonAdapter(Context context, ArrayList<Person> products) {
        inflater = LayoutInflater.from(context);
        this.mProductList = products;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.person_cardview, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Person selectedProduct = mProductList.get(position);
        holder.setData(selectedProduct, position);

    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView productName, productDescription;
        ImageView productImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            productName = (TextView) itemView.findViewById(R.id.personID);
            productDescription = (TextView) itemView.findViewById(R.id.personPassword);
            productImage = (ImageView) itemView.findViewById(R.id.personImg);
            personSwitch = itemView.findViewById(R.id.PersonSwitch);
            personSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        productDescription.setText(productName.getText());
                    }
                    else{
                        productDescription.setText("********");
                    }
                }
            });

        }

        public void setData(Person selectedProduct, int position) {

            this.productName.setText(selectedProduct.getID());
            this.productDescription.setText("*********");
            this.productImage.setImageResource(selectedProduct.getImgID());


        }


        @Override
        public void onClick(View v) {


        }


    }
}