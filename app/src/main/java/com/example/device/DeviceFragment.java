package com.example.device;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Anand on 07/02/2017.
 */

public class DeviceFragment extends Fragment {

    @BindView(R.id.manufacturer) TextView manufacturer;
    @BindView(R.id.product) TextView product;
    @BindView(R.id.model) TextView model;
    @BindView(R.id.device) TextView device;
    @BindView(R.id.board) TextView board;
    @BindView(R.id.bootloader) TextView bootloader;
    @BindView(R.id.brand) TextView brand;
    @BindView(R.id.hardware) TextView hardware;
    @BindView(R.id.serial) TextView serial;
    @BindView(R.id.base_os) TextView baseOs;
    @BindView(R.id.release) TextView release;
    @BindView(R.id.sdk_int) TextView sdkInt;

    public static final String TITLE = "Device";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_device, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        manufacturer.append(Build.MANUFACTURER);
        product.append(Build.PRODUCT);
        model.append(Build.MODEL);
        device.append(Build.DEVICE);
        board.append(Build.BOARD);
        bootloader.append(Build.BOOTLOADER);
        brand.append(Build.BRAND);
        hardware.append(Build.HARDWARE);
        serial.append(Build.SERIAL);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            baseOs.append(Build.VERSION.BASE_OS);
        }
        else {
            baseOs.setVisibility(View.GONE);
        }
        release.append(Build.VERSION.RELEASE);
        sdkInt.append(String.valueOf(Build.VERSION.SDK_INT));
    }
}
