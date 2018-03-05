package by.it_academy.class_work_1.class_work6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import by.it_academy.myapplication.R;

public class ClassWork6Activity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private UserListAdapter mUserListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_work6);

        List<User> users = new ArrayList<>();

        users.add(new User ("", "User1", "Surname1"));
        users.add(new User ("", "User2", "Surname2"));
        users.add(new User ("", "User3", "Surname3"));
        users.add(new User ("", "User4", "Surname4"));
        users.add(new User ("", "User5", "Surname5"));

        mUserListAdapter = new UserListAdapter();
        mUserListAdapter.setItem(users); // неважно в каком месте эта строка, он обновится

        mUserListAdapter.setListener(new UserListAdapter.OnUserClickListener(){
            @Override
            public void onClick(User user, int position){
                Toast.makeText(ClassWork6Activity.this, user.getName() + position, Toast.LENGTH_LONG).show();
            }

        });

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setAdapter(mUserListAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true); //если каждый элемент имеет одинаковую высоту, этот метод оптимиз работу

       //Fixme для добавления отступов    mRecyclerView.addItemDecoration();


    }
}
