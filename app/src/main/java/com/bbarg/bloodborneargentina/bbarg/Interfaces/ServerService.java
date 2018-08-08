package com.bbarg.bloodborneargentina.bbarg.Interfaces;

import com.bbarg.bloodborneargentina.bbarg.Models.LoreModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServerService {
    @GET("getLores")
    Call<List<LoreModel>> getLores();
}
