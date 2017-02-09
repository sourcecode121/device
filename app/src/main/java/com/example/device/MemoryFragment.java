package com.example.device;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.device.Utility.getFileInfo;

/**
 * Created by Anand on 08/02/2017.
 */

public class MemoryFragment extends Fragment {

    @BindView(R.id.memory_info)
    TextView memoryInfo;

    public static final String TITLE = "Memory";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_memory, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        StringBuffer info = getFileInfo("/proc/meminfo");

        if (info != null) {
            memoryInfo.setText(info);
        }
        else {
            memoryInfo.setText(R.string.error_message);
        }
    }
}
