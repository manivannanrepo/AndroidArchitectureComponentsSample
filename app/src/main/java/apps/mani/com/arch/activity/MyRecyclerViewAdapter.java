package apps.mani.com.arch.activity;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import apps.mani.com.arch.R;

import apps.mani.com.arch.databinding.RecyclerviewItemBinding;
import apps.mani.com.arch.db.Fruits;

/**
 * Created by GAMING RIG on 11-03-2018.
 */


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private List<Fruits> fruits;
    private LayoutInflater layoutInflater;

    MyRecyclerViewAdapter(List<Fruits> fruits) {
        this.fruits = fruits;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        RecyclerviewItemBinding recyclerviewItemBinding = DataBindingUtil.inflate(layoutInflater,R.layout.recyclerview_item, parent, false);
        return new MyViewHolder(recyclerviewItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.recyclerviewItemBinding.setFruit(fruits.get(position));
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private RecyclerviewItemBinding recyclerviewItemBinding;

        MyViewHolder(RecyclerviewItemBinding recyclerviewItemBinding) {
            super(recyclerviewItemBinding.getRoot());
            this.recyclerviewItemBinding = recyclerviewItemBinding;
        }
    }
}
