package com.example.device;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Anand on 07/02/2017.
 */

public class CpuFragment extends Fragment {

    @BindView(R.id.cpu_info)
    TextView cpuInfo;

    public static final String TITLE = "CPU";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cpu, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        StringBuffer buffer = new StringBuffer();
        String line;

        if (new File("/proc/cpuinfo").exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(new File("/proc/cpuinfo")));

                while ((line = reader.readLine()) != null) {
                    buffer.append(line).append("\n");
                }

                reader.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            cpuInfo.setText(buffer);
        }
        else {
            cpuInfo.setText(R.string.error_message);
        }
    }
}
