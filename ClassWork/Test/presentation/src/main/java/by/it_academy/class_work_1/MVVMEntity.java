package by.it_academy.class_work_1;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

/**
 * Created by kasarevich on 05.03.2018.
 */

public class MVVMEntity {

    public ObservableField<String> text = new ObservableField<>("");
    public ObservableField<String> textButton = new ObservableField<>("");
     public ObservableBoolean buttonVisible = new ObservableBoolean(true);



    public MVVMEntity(String text, String textButton) {
        this.text.set(text);
        this.textButton.set(textButton);
    }


    public void buttonClick(View view){
        Log.e("AAA", "buttonClick");
        buttonVisible.set(false);
    }
}
