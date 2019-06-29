package com.alimoncul.formula1report.FormulaApi;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface InterfaceRaceResult {

    String BASE_URL = "http://ergast.com/api/f1/current/last/";

    @Headers("Content-Type: application/json")
    @GET("{endpoint}")
    Call<Example> getResult(@Path("endpoint") String endpoint);
}
