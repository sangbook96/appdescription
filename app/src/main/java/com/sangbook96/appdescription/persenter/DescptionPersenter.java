package com.sangbook96.appdescription.persenter;

import com.sangbook96.appdescription.model.Homes;

import java.util.ArrayList;

public interface DescptionPersenter {
    void getListDescptionSucess(ArrayList<Homes>listDescption);

    void getListDescptionError(String errorMessage);

}
