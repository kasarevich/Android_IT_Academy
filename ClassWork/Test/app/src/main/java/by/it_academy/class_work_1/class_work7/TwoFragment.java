package by.it_academy.class_work_1.class_work7;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.it_academy.myapplication.R;


public class TwoFragment extends Fragment {

    public static String KEY_VALUE = "KEY_TWO";

    public static TwoFragment getInstance(FragmentManager fragmentManager, int value){
        TwoFragment twoFragment = (TwoFragment) fragmentManager.findFragmentByTag(TwoFragment.class.getSimpleName());
        if (twoFragment == null){
            twoFragment = new TwoFragment();
        }

        Bundle bundle = new Bundle();
        bundle.putInt(KEY_VALUE, value);

        twoFragment.setArguments(bundle);


        return twoFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if(bundle != null){
            int value = bundle.getInt(KEY_VALUE);
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return getLayoutInflater().inflate(R.layout.fragment_two, container, false);
    }


    // от onCreateView отличается тем, что на этом этапе Вью уже гарантированно создано,
    // поэтому вся инициализация UI B onViewCreated
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // onClick, все данные, присваивания (все, что у активити в onCreate)
    }

}
