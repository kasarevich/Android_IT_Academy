package by.it_academy.class_work_1.class_work7;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class OneFragment extends Fragment {
    private static String KEY_VALUE = "One fragment";

    public PublishContract mPublishContract;

    public static OneFragment getInstance(FragmentManager fragmentManager, int value){
        OneFragment oneFragment = (OneFragment) fragmentManager.findFragmentByTag(OneFragment.class.getSimpleName());
        if (oneFragment == null){
            oneFragment = new OneFragment();
        }

        Bundle bundle = new Bundle();
        bundle.putInt(KEY_VALUE, value);

        oneFragment.setArguments(bundle);


        return oneFragment;
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
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    // от onCreateView отличается тем, что на этом этапе Вью уже гарантированно создано,
    // поэтому вся инициализация UI B onViewCreated
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // onClick, все данные, присваивания (все, что у активити в onCreate)

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        if(activity!=null){
            mPublishContract = (PublishContract) activity;
        }
    }
}
