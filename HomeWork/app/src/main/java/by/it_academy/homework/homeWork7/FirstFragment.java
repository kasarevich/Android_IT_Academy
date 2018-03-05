package by.it_academy.homework.homeWork7;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

import by.it_academy.homework.R;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {
    private TextView mReceiverText;
   private PublishObserverContract mPublishObserverContract;
   private Disposable mDisposable;

    public static FirstFragment getInstance() {
       return new FirstFragment();
    }

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        if(activity!=null){
            mPublishObserverContract = (PublishObserverContract) activity;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPublishObserverContract = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_first, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mReceiverText = (TextView) view.findViewById(R.id.receiver_text_view);
        subscribe();
    }

    public void subscribe() {
        mDisposable = mPublishObserverContract.getObservable()
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return String.valueOf(integer);
                    }
                })


                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        mReceiverText.setText(s);
                    }
                });


            /*    , new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                //сюда прилетают ошибки
            }*/



    }
}
