package apps.mani.com.arch.activity;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import apps.mani.com.arch.R;
import apps.mani.com.arch.databinding.ActivityMainBinding;
import apps.mani.com.arch.db.Fruits;
import apps.mani.com.arch.db.MyDatabase;
import apps.mani.com.arch.viewmodels.MyViewModel;


/**
 * Created by GAMING RIG on 11-03-2018.
 */

public class MyActivity extends AppCompatActivity {

    private MyViewModel myViewModel;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        recyclerView = activityMainBinding.recyclerView;
        swipeRefreshLayout = activityMainBinding.swipeRefresh;

        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);

        myViewModel.getFruits().observe(this, (List<Fruits> fruits) -> {
                populateList(fruits);
            swipeRefreshLayout.setRefreshing(false);
        });


        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(getResources().getDrawable(R.drawable.divider));
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(itemDecoration);

        swipeRefreshLayout.setOnRefreshListener(() -> {
            myViewModel.initDB();
            //TODO: Have to add it in service call back
            swipeRefreshLayout.setRefreshing(false);
        });
    }

    private void populateList(List<Fruits> fruits) {
        recyclerView.setAdapter(new MyRecyclerViewAdapter(fruits));
    }

    @Override
    protected void onDestroy() {
        MyDatabase.removeMyDb();
        super.onDestroy();
    }
}
