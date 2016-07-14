package ru.binarysimple.searchusers;


import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

public interface GitHubClient {

    @GET("/search/users")
    Observable<UserList> getUsers (@Query("q") String userName);

}
