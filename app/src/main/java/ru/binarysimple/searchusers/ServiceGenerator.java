package ru.binarysimple.searchusers;


import retrofit.RestAdapter;

public class ServiceGenerator {

    public static final String API_BASE_URL = "https://api.github.com";

    public static <T> T createRetrofitService(final Class<T> service) {
        final RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_BASE_URL)
                .build();

        return restAdapter.create(service);
    }

}
