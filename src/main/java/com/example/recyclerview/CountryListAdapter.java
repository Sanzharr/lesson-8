package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.MyTViewHolder> {
    private Context context;
    private List<Country> countryList;

    public class MyTViewHolder extends RecyclerView.ViewHolder{
        public ImageView photo;
        public TextView title, code;

        public MyTViewHolder(View view){
            super(view);

            photo = view.findViewById(R.id.photo);
            title = view.findViewById(R.id.title);
            code = view.findViewById(R.id.code);

        }
    }

    public CountryListAdapter(Context context, List<Country> countryList){
        this.context = context;
        this.countryList = countryList;
    }

    @Override
    public MyTViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_countries, parent, false);

        return new MyTViewHolder(itemView);
    }

    @Override
    public void  onBindViewHolder(final MyTViewHolder sborka, int position){

        Country item = countryList.get(position);

        sborka.photo.setImageResource(item.getPhoto());
        sborka.title.setText(item.getTitle());
        sborka.code.setText(""+item.getCode());

    }

    @Override
    public int getItemCount(){
        return countryList.size();
    }
}
