package com.tw.controllers;

import com.google.gson.Gson;
import com.google.maps.model.LatLng;
import com.tw.models.LatLongRequest;
import com.tw.services.GoogleApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tonywinters on 2/24/17.
 */

@Validated
@RestController
@RequestMapping("/api")
public class LatLongController {

    private Gson gson = new Gson();

    @Autowired
    private GoogleApiService googleApiService;

    @RequestMapping(value = "/getAddress", method = RequestMethod.GET)
    public String getAddress(@RequestParam String latitude, @RequestParam String longitude) throws Exception{
        LatLng latLng = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));
        LatLongRequest address = googleApiService.getAddress(latLng);
        return gson.toJson(address);
    }


    @RequestMapping(value = "/getCache")
    public String gets(){
        return gson.toJson(googleApiService.getCacheData());
    }
}
