package ru.binarysimple.searchusers;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface GitHubClient {

    @GET("/search/users")
    Observable<List<User>> getUsers (
            @Query("q") String userName
    );

 /*   Call<List<User>> contributors(
            @Path("owner") String owner,
            @Path("repo") String repo
    );*/
/*    Call <List<User>> contributors (
            @Query("q") String userName
    );*/


}
