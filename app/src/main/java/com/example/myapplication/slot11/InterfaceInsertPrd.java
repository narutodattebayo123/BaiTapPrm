package com.example.myapplication.slot11;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Field;

public interface InterfaceInsertPrd {
    @FormUrlEncoded
    @POST("create_product.php")
    Call<SvrResponePrd> insertPrd(
            @Field("name") String name,
            @Field("price") String price,
            @Field("description") String description);
}
