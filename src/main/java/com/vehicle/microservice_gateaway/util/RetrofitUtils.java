package com.vehicle.microservice_gateaway.util;

import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class RetrofitUtils {

    public static <T> T executeInBlock(Call<T> request)
    {
        try
        {
            Response<T> response = request.execute();

            return response.body();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e.getCause());
        }
    }
}
