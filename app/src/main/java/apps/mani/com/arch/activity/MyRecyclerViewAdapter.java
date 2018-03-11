package apps.mani.com.arch.activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import apps.mani.com.arch.R;
import apps.mani.com.arch.db.Fruits;

/**
 * Created by GAMING RIG on 11-03-2018.
 */


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Fruits> fruits = new ArrayList<>();

    MyRecyclerViewAdapter(List<Fruits> fruits) {
        this.fruits = fruits;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclervew_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.textView.setText(String.format("%s", fruits.get(position).getFruitName()));
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        MyViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textview01);
        }
    }
}
