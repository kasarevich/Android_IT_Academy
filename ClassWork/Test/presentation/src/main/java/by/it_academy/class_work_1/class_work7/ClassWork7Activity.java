package by.it_academy.class_work_1.class_work7;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import by.it_academy.myapplication.R;

public class ClassWork7Activity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private final String TAG = "CW7";
    boolean mIsOneVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_work7);

        findViewById(R.id.title_bar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment();
            }

        });
        //Fixme проверка.(если фрагмент уже есть в памяти, то без проверки откроются 2 версии: старая и новая)
        if(savedInstanceState == null){
            showFragment(OneFragment.getInstance(fragmentManager, 5),false);
        }
    }

    private void changeFragment(){
        if(mIsOneVisible){
            showFragment(TwoFragment.getInstance(fragmentManager, 6),true);
            mIsOneVisible = false;
        }else {
            showFragment(OneFragment.getInstance(fragmentManager, 5),true);
            mIsOneVisible = true;
        }
    }

    private void showFragment(Fragment fragment, boolean addToBackStack){

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.container_fragment, fragment, fragment.getClass().getSimpleName());

        if(addToBackStack)fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName()); //Для возврата по нажатию back

        fragmentTransaction.commit();



    }


}
