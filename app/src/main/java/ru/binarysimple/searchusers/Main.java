package ru.binarysimple.searchusers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;

//http://randomdotnext.com/retrofit-rxjava/

public class Main extends AppCompatActivity {
    public final String TAG = "retro";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


// Create a very simple REST adapter which points the GitHub API endpoint.
        GitHubClient client = ServiceGenerator.createService(GitHubClient.class);

        // Fetch and print a list of the users to this library.
        Observable<List<User>> users =
                client.getUsers("mojombo");

      //  List<User> users = null;

 /*       call.enqueue(new Callback<List<User>>() {
                         @Override
                         public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                             if (response.isSuccessful()) {
                                 // response available
                                 Log.d(TAG,"enqueue success");
//                                 Toast.makeText(getBaseContext(), "enqueue success", Toast.LENGTH_SHORT).show();
*//*                                 for (User user:response.body()){
//                                     Log.d(TAG, user.login + " (" + user.id + ")");
                                     System.out.println(
                                             user.login + " (" + user.id + ")");
                                 }*//*

                             } else {
                                 // error response, no access to resource?
                                 //Toast.makeText(getBaseContext(), "enqueue error", Toast.LENGTH_SHORT).show();
                                 System.out.println("error que");
                                 Log.d(TAG,"enqueue error");
                             }
                         }

                         @Override
                         public void onFailure(Call<List<User>> call, Throwable t) {
                             // something went completely south (like no internet connection)
                             Log.d("Error", t.getMessage());
                             System.out.println("error onFailure");
                         }
                     }
        );*/

      /*  try {
            users = call.execute().body();
        } catch (IOException e) {
            // handle errors
        }*/

/*        assert users != null;
        for (User user : users) {
            Log.d(TAG, user.login + " (" + user.id + ")");
            *//*System.out.println(
                    user.login + " (" + user.id + ")");*//*
        }*/

    }
}
