package com.example.recyclerviewexperiments;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface; //gives access to onItemClick method

    private ArrayList<User> usersList;

    public RecyclerAdapter (ArrayList<User> usersList, RecyclerViewInterface recyclerViewInterface){

        this.usersList = usersList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nameText;

        public MyViewHolder(final View view, RecyclerViewInterface recyclerViewInterface){
            super(view);

            nameText = view.findViewById(R.id.username);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface != null){      // this will give an error if the MyViewHolder is static, to go around that
                                                            // pass the RecyclerViewInterface in MyViewHolder (next to final View view)

                        int pos = getAdapterPosition();     //Gets the current position of the adapter

                        if(pos != RecyclerView.NO_POSITION){            // as long as there is something in the recyclerView
                            recyclerViewInterface.onItemClick(pos);
                           Log.d ("klick","klickklick");
                        }
                    }
                }
            });
        }
    }



    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // this is were you inflate the layor (Giveing a look to ower rows)

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);

        return new MyViewHolder(itemView, recyclerViewInterface);                       /// when the recyclerViewInterface with onItemClick is added don't forget to add it here!!
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {

        //assigning values to the views we create in the "row layout" xml-file
        //based on the position of the recycler view
        String name = usersList.get(position).getUserName();
        holder.nameText.setText(name);
    }

    @Override
    public int getItemCount() {
        // the recycler view wants to know the number of items you want to display
        return usersList.size();
    }


}
