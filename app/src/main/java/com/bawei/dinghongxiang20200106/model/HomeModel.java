package com.bawei.dinghongxiang20200106.model;

import com.bawei.dinghongxiang20200106.api.HomeService;
import com.bawei.dinghongxiang20200106.contract.HomeContract;
import com.bawei.dinghongxiang20200106.entity.LeftEntity;
import com.bawei.dinghongxiang20200106.entity.RightEntity;
import com.bawei.dinghongxiang20200106.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeModel implements HomeContract.IModel {
    @Override
    public void getLeft(IModelCallBack iModelCallBack) {

        RetrofitUtils.getInstance().createService(HomeService.class)
                .getLeft()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LeftEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LeftEntity leftEntity) {
                        iModelCallBack.success(leftEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.failure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getRight(HashMap<String, String> params, IModelCallBack iModelCallBack) {

        RetrofitUtils.getInstance().createService(HomeService.class)
                .getRight(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RightEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RightEntity rightEntity) {
                        iModelCallBack.success(rightEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.failure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
