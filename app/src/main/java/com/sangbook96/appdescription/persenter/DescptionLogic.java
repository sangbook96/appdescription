package com.sangbook96.appdescription.persenter;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.sangbook96.appdescription.api.APIPath;
import com.sangbook96.appdescription.api.ApiUtils;
import com.sangbook96.appdescription.model.Homes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DescptionLogic implements DescptionListener {
    private APIPath apiPath;
    private DescptionPersenter descptionPersenter;
    private static final String TAG = DescptionLogic.class.getSimpleName();
    ArrayList<Homes>listHomes;
    public DescptionLogic(DescptionPersenter descptionPersenter) {
        this.descptionPersenter = descptionPersenter;
    }

    @Override
    public void requestDescption(String token) {
        apiPath = ApiUtils.APIService();
        Call<ResponseBody> callResponse = apiPath.dataHome(token);
        listHomes = new ArrayList<>();
        callResponse.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code()==200) {
                    try {
                        JSONObject jsonObjectHomes = new JSONObject(response.body().string());
                        JSONArray jsonArray = jsonObjectHomes.getJSONArray("homes");
                        Gson gson = new Gson();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject elementJsonObj = jsonArray.getJSONObject(i);
                            Homes homes = gson.fromJson(elementJsonObj.toString(), Homes.class);
                            listHomes.add(homes);
                        }
                        descptionPersenter.getListDescptionSucess(listHomes);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else {
                    descptionPersenter.getListDescptionError(response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                    descptionPersenter.getListDescptionError(t.getMessage());
            }
        });
    }
}
