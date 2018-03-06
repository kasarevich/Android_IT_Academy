package by.it_academy.homework.homework6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import by.it_academy.homework.R;
import by.it_academy.homework.homework6.entity.Customer;
import by.it_academy.homework.homework6.entity.Station;

public class HomeWork6Activity extends AppCompatActivity {

    private final String NAMEJSON = "customers.json";
    public static String PARSINGISDONE = "DONE";
    private EditText mEditText;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private Manager mManager;
    private LocalBroadcastManager mLocalBroadcastManager;
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            (( CustomerAdapter) mAdapter).setCustomers(mManager.getFinded());
            mAdapter.notifyDataSetChanged();
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework6);

        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
        mLocalBroadcastManager.registerReceiver(mBroadcastReceiver, new IntentFilter(PARSINGISDONE));

        mManager = Manager.getInstance(LocalBroadcastManager.getInstance(this));
        mManager.setNameOfFile(getFilesDir().toString() + "/" + NAMEJSON);
        mManager.getData();
        mEditText = findViewById(R.id.edit_hw6);
        mRecyclerView = findViewById(R.id.recycler_hw6);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new CustomerAdapter(mManager.getFinded());
        mRecyclerView.setAdapter(mAdapter);

        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mManager.searchCustomerByName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }




    class CustomerAdapter extends RecyclerView.Adapter<CustomerViewHolder> {
        ArrayList<Customer> customers;

        public CustomerAdapter(ArrayList<Customer> customers) {
            this.customers = customers;
        }

        @Override
        public CustomerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new CustomerViewHolder(getLayoutInflater().inflate(R.layout.item_customer, parent, false));
        }

        @Override
        public void onBindViewHolder(CustomerViewHolder holder, int position) {
            holder.bind(customers.get(position));
        }

        @Override
        public int getItemCount() {
            return customers.size();
        }
        public void setCustomers(ArrayList<Customer> customers){
            this.customers = customers;
        }
    }




    private class CustomerViewHolder extends RecyclerView.ViewHolder {

        private TextView id = itemView.findViewById(R.id.id_hw6);
        private TextView name = itemView.findViewById(R.id.name_hw6);
        private TextView lastOrder = itemView.findViewById(R.id.last_order_hw6);
        private TextView dateOfBirth = itemView.findViewById(R.id.date_of_birth_hw6);
        private TextView discount = itemView.findViewById(R.id.discount_hw6);
        private TextView cars = itemView.findViewById(R.id.cars_hw6);

        public CustomerViewHolder(View itemView) {
            super(itemView);
        }

        public void bind(Customer customer) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (customer != null) {
                id.setText("id:" + String.valueOf(customer.getId()));
                name.setText("name:" + customer.getName());
                dateOfBirth.setText("date of Birth:" + sdf.format(customer.getDateOfBirth()));
                lastOrder.setText("last order:" + sdf.format(customer.getLastOrder()));
                if (customer.isDiscount()) {
                    discount.setText("Discount: + ");
                } else if (!customer.isDiscount()) {
                    discount.setText("Discount: - ");
                } else {
                    discount.setText("Discount: unknown");
                }

                StringBuilder builder = new StringBuilder();
                for (String car : customer.getCars()) {
                    builder.append(car + "\n");
                }
                cars.setText(builder.toString().trim());
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocalBroadcastManager.unregisterReceiver(mBroadcastReceiver);
    }
}
