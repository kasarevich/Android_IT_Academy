package by.it_academy.homework.homeWork7;


import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by kasarevich on 05.03.2018.
 */

public interface PublishObserverContract {
    public Observable<Integer> getObservable();
}
