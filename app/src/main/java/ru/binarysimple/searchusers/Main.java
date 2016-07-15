package ru.binarysimple.searchusers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;



public class Main extends AppCompatActivity {
    public final String TAG = "retro";
    private RVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btnSearch = (Button) findViewById(R.id.button);
        final EditText etUserName = (EditText) findViewById(R.id.editText);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        assert rv != null;
        rv.setLayoutManager(llm);

        adapter = new RVAdapter();
        rv.setAdapter(adapter);

        assert btnSearch != null;
        assert etUserName !=null;

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etUserName.getText().toString().equals("")) {
                    adapter.clear();
                    searchUsers(etUserName.getText().toString());
                }
            }
        });
    }

    private void searchUsers(String userName){
        GitHubClient client = ServiceGenerator.createRetrofitService(GitHubClient.class);
        client.getUsers(userName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UserList>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError");
                    }

                    @Override
                    public void onNext(UserList userList) {
                        System.out.println("onNext total_count = "+ userList.getTotal_count());
                        for (User user : userList.items) {
                            adapter.addData(user);
                            System.out.println(user.getLogin());
                        }
                    }
                });
    }
}

