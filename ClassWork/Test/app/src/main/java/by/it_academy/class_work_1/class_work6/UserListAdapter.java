package by.it_academy.class_work_1.class_work6;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import by.it_academy.myapplication.R;



public class UserListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private List<User> itemList =new ArrayList<>();
    private OnUserClickListener listener;


    public void setItem(List<User> itemList){
        this.itemList.clear();
        this.itemList.addAll(itemList);
        //Fixme обновляет(заново создает on bind, on create)
        notifyDataSetChanged();
    }

    // Для того, чтобы RecyclerView щнал, сколько раз вызывать onBindViewHolder
    @Override
    public int getItemCount() {
        return itemList.size();
    }

    //выполняется только для первых и иногда для нестандартных вью
    //сздает холдер, который содержит лайаут. он кэшируется

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    //Fixme  Можно подставлять другие лайауты в зав-ти от пользователя(например выделенное объявление, любимый контакт)
        // Fixme Если несколько дизайнов, для каждого свой класс холдер создается
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new Holder(view);
    }

    //выполняется для каждой вью
    // используется для заполнения данных item - один элемент
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        Holder myHolder = (Holder)holder;
        final User user = itemList.get(position);

        //Image - дома // FIXME implement Glide(picasso)
        myHolder.mName.setText(user.getName());
        myHolder.mSurname.setText(user.getSurname());

        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null) listener.onClick(user, position);
            }
        });
    }

    public void setListener(OnUserClickListener listener){
        this.listener = listener;
    }


    //"технический" класс для хранения item
    //ViewHolder "хэширует данные", чтобы не парсить xml каждый раз и не делать findViewById
    // Все по аналогии с заполнением активити, только вместо R findViewById вызывается у itemView
    static class Holder extends RecyclerView.ViewHolder{
        ImageView mImageView;
        TextView mName;
        TextView mSurname;
        public Holder(View itemView) {
            super(itemView);
            Log.e("Adapter", "Holder");
            mImageView = itemView.findViewById(R.id.image_item);
            mName = itemView.findViewById(R.id.text_name);
            mSurname = itemView.findViewById(R.id.text_surname);

        }
    }

    interface OnUserClickListener{
        void onClick (User user, int position);
    }
}




