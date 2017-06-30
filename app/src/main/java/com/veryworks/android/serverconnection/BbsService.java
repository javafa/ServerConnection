package com.veryworks.android.serverconnection;

import com.veryworks.android.serverconnection.domain.Bbs;
import com.veryworks.android.serverconnection.domain.Result;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by pc on 6/30/2017.
 */

public interface BbsService {
    @POST("bbs")
    Call<Result> createBbs(@Body Bbs bbs);
}
