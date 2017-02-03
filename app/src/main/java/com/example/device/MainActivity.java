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
    @BindView(R.id.board)
    TextView board;
    @BindView(R.id.bootloader)
    TextView bootloader;
    @BindView(R.id.brand)
    TextView brand;
    @BindView(R.id.hardware)
    TextView hardware;
    @BindView(R.id.serial)
    TextView serial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        manufacturer.append(Build.MANUFACTURER);
        product.append(Build.PRODUCT);
        model.append(Build.MODEL);
        device.append(Build.DEVICE);
        board.append(Build.BOARD);
        bootloader.append(Build.BOOTLOADER);
        brand.append(Build.BRAND);
        hardware.append(Build.HARDWARE);
        serial.append(Build.SERIAL);
    }
}
