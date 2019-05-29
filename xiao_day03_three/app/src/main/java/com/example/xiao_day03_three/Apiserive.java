package com.example.xiao_day03_three;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by 只想暴富 on 2019/5/29.
 */

public interface Apiserive {
    public String fuli="http://gank.io/";
    @GET("api/data/%E7%A6%8F%E5%88%A9/20/1")
    Observable<User> fuli();
}
