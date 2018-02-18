package by.it_academy.homework.homeWork3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import by.it_academy.homework.BuildConfig;
import by.it_academy.homework.R;

public class HomeWork3Activity extends AppCompatActivity {

    private EditText mEditText;
    private Button mButton;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work3);

        mButton = findViewById(R.id.download_button_HW3);
        mButton.setText(BuildConfig.BUTTON_HW3);
        mEditText = findViewById(R.id.editText_HW3);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageView = findViewById(R.id.image_view_HW3);
                String url = mEditText.getText().toString();
                if(!url.equals(null)){
                    Picasso.with(HomeWork3Activity.this)
                            .load(url)
                            .placeholder(R.drawable.ic_arrow_downward_black_24dp)
                            .error(R.drawable.ic_error_outline_black_24dp)
                            .transform(new RoundTransformation(250))
                            .into(mImageView);
                }
            }
        });
    }
}
