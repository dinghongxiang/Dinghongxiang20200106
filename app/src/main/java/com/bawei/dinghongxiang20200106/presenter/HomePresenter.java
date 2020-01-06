package com.bawei.dinghongxiang20200106.presenter;

import com.bawei.dinghongxiang20200106.contract.HomeContract;
import com.bawei.dinghongxiang20200106.model.HomeModel;
import com.bawei.dinghongxiang20200106.mvp.BasePresenter;

import java.util.HashMap;

public class HomePresenter extends BasePresenter<HomeModel, HomeContract.IView> implements HomeContract.IPresenter {
    @Override
    public void getLeft() {

        model.getLeft(new HomeContract.IModel.IModelCallBack() {
            @Override
            public void success(Object data) {
                getView().success(data);
            }

            @Override
            public void failure(Throwable throwable) {

                getView().failure(throwable);
            }
        });
    }

    @Override
    public void getRight(HashMap<String, String> params) {

        model.getRight(params, new HomeContract.IModel.IModelCallBack() {
            @Override
            public void success(Object data) {
                getView().success(data);
            }

            @Override
            public void failure(Throwable throwable) {

                getView().failure(throwable);
            }
        });
    }

    @Override
    protected HomeModel initModel() {
        return new HomeModel();
    }
}
