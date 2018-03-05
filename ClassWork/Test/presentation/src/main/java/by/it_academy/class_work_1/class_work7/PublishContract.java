package by.it_academy.class_work_1.class_work7;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by kasarevich on 02.03.2018.
 */

public interface PublishContract {
    PublishSubject<Integer> getPublishSubject();
}
