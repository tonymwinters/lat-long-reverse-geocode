package com.tw.services;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.LocationType;
import com.tw.models.LatLongRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ExecutionException;

/**
 * Created by tonywinters on 2/24/17.
 */

@Service
public class GoogleApiService {

    private static String API_KEY = System.getProperty("GOOGLE_API_KEY");

    private static GeoApiContext G_CONTEXT = new GeoApiContext().setApiKey(API_KEY);


    private static Cache<String, LatLongRequest> cache = CacheBuilder.newBuilder()
            .maximumSize(10)
            .recordStats()
            .build();

    public LatLongRequest getAddress(LatLng latLng) throws IOException, ExecutionException {
        return cache.get(latLng.toString(), () -> getFromGoogle(latLng));
    }

    public Collection<LatLongRequest> getCacheData(){
        return cache.asMap().values();
    }

    private static LatLongRequest getFromGoogle(LatLng latLong){
        GeocodingApiRequest request = GeocodingApi.reverseGeocode(G_CONTEXT, latLong);
        request.locationType(LocationType.ROOFTOP);
        GeocodingResult[] results = new GeocodingResult[1];
        try {
            results = request.await();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        if(results.length > 0){
            return new LatLongRequest(latLong.lat, latLong.lng, results[0].formattedAddress, new Date());
        } else {
            return new LatLongRequest(latLong.lat, latLong.lng, "ADDRESS NOT FOUND", new Date());
        }
    }


}
