package com.bawei.dinghongxiang20200106.contract;

import com.bawei.dinghongxiang20200106.mvp.IBaseModel;
import com.bawei.dinghongxiang20200106.mvp.IBaseView;

import java.util.HashMap;

public interface HomeContract {

    interface IModel extends IBaseModel{
        void getLeft(IModelCallBack iModelCallBack);
        void getRight(HashMap<String,String> params,IModelCallBack iModelCallBack);
        interface IModelCallBack{
            void success(Object data);
            void failure(Throwable throwable);
        }
    }

    interface IView extends IBaseView {
        void success(Object data);
        void failure(Throwable throwable);
    }


    interface IPresenter{
        void getLeft();
        void getRight(HashMap<String,String> params);
    }
}
