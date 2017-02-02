package com.example.device;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.manufacturer)
    TextView manufacturer;
    @BindView(R.id.product)
    TextView product;
    @BindView(R.id.model)
    TextView model;
    @BindView(R.id.device)
    TextView device;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        manufacturer.setText(Build.MANUFACTURER);
        product.setText(Build.PRODUCT);
        model.setText(Build.MODEL);
        device.setText(Build.DEVICE);
    }
}
