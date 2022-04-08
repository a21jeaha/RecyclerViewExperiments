package com.example.recyclerviewexperiments;

public interface RecyclerViewInterface {
    void onItemClick(int position);   // used to recognize clicks
    void onLongItemClick(int position); // used to recognize long taps
}
