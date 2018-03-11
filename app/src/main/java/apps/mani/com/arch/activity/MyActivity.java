package apps.mani.com.arch.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import apps.mani.com.arch.R;
import apps.mani.com.arch.db.Fruits;
import apps.mani.com.arch.viewmodels.MyViewModel;


/**
 * Created by GAMING RIG on 11-03-2018.
 */

public class MyActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyViewModel myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        myViewModel.getFruits().observe(this, new Observer<List<Fruits>>() {
            @Override
            public void onChanged(@Nullable List<Fruits> fruits) {
                populateList(fruits);
            }
        });

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(getResources().getDrawable(R.drawable.divider));
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(itemDecoration);

    }

    private void populateList(List<Fruits> fruits) {
        recyclerView.setAdapter(new MyRecyclerViewAdapter(fruits));
    }
}
