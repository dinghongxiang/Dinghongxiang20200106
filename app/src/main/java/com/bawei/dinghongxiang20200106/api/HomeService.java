package com.bawei.dinghongxiang20200106.api;

import com.bawei.dinghongxiang20200106.entity.LeftEntity;
import com.bawei.dinghongxiang20200106.entity.RightEntity;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface HomeService {


    @GET("baweiapi/category")
    Observable<LeftEntity> getLeft();


    @GET("baweiapi/shopByCategory")
    Observable<RightEntity> getRight(@QueryMap HashMap<String,String> params);

}
