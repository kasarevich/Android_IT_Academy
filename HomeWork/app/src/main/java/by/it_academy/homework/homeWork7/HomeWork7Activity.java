package by.it_academy.homework.homeWork7;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import by.it_academy.homework.R;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class HomeWork7Activity extends AppCompatActivity implements  PublishObserverContract{

    private PublishSubject<Integer> mPublishSubject;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework7);

        final View clickView = findViewById(R.id.click_view);

        mPublishSubject = PublishSubject.create();
        clickView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                mPublishSubject.onNext(counter);
            }
        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,FirstFragment.getInstance());
        transaction.commit();


    }


    @Override
    public Observable<Integer> getObservable() {
        return mPublishSubject;
    }
}

