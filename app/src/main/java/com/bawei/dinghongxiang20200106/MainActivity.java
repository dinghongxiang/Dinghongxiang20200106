package com.bawei.dinghongxiang20200106;



import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.dinghongxiang20200106.adapter.LeftAdapter;
import com.bawei.dinghongxiang20200106.adapter.RightAdapter;
import com.bawei.dinghongxiang20200106.base.BaseActivity;
import com.bawei.dinghongxiang20200106.contract.HomeContract;
import com.bawei.dinghongxiang20200106.entity.LeftEntity;
import com.bawei.dinghongxiang20200106.entity.RightEntity;
import com.bawei.dinghongxiang20200106.presenter.HomePresenter;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Collections;
import java.util.HashMap;


import butterknife.BindView;


public class MainActivity extends BaseActivity<HomePresenter> implements HomeContract.IView {


    @BindView(R.id.rv_left)
    RecyclerView rvLeft;
    @BindView(R.id.rv_right)
    RecyclerView rvRight;

    @Override
    protected void initData() {
        presenter.getLeft();
    }

    @Override
    protected void initView() {

        EventBus.getDefault().register(this);
        rvLeft.setLayoutManager(new LinearLayoutManager(this));
        rvRight.setLayoutManager(new GridLayoutManager(this,2));
    }

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void success(Object data) {
        if (data instanceof LeftEntity) {

            LeftEntity leftEntity= (LeftEntity) data;


            final LeftAdapter leftAdapter = new LeftAdapter(this,Collections.singletonList(leftEntity));

            rvLeft.setAdapter(leftAdapter);

            leftAdapter.setRevonClick(new LeftAdapter.RevonClick() {
                @Override
                public void onClick(String name) {
                    EventBus.getDefault().post(name);
                }
            });

        }else if (data instanceof RightEntity){

            RightEntity rightEntity= (RightEntity) data;

            final RightAdapter rightAdapter = new RightAdapter(this, rightEntity.getData());

            rvRight.setAdapter(rightAdapter);
        }
    }

    @Override
    public void failure(Throwable throwable) {

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void  getName(String name) {

        HashMap<String, String> params = new HashMap<>();

        params.put("category", name);

        presenter.getRight(params);
    }
}
