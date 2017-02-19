package com.example.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
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
 * Created by Anand on 14/02/2017.
 */

public class BatteryFragment extends Fragment {

    @BindView(R.id.battery_status)
    TextView status;
    @BindView(R.id.battery_plugged)
    TextView plug;
    @BindView(R.id.battery_percentage)
    TextView percentage;

    public static final String TITLE = "Battery";
    private Context context;
    private BroadcastReceiver batteryReceiver;
    private IntentFilter intentFilter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        batteryReceiver = new BatteryReceiver();

        intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_battery, container, false);
        ButterKnife.bind(this, v);
        context.registerReceiver(batteryReceiver, intentFilter);
        return v;
    }

    @Override
    public void onDestroyView() {
        context.unregisterReceiver(batteryReceiver);
        super.onDestroyView();
    }

    private class BatteryReceiver extends BroadcastReceiver {

        private String batteryStatus;
        private String batteryPlug;
        private String batteryPercentage;

        @Override
        public void onReceive(Context context, Intent intent) {
            int chargeStatus = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            switch (chargeStatus) {
                case BatteryManager.BATTERY_STATUS_CHARGING:
                    batteryStatus = getString(R.string.charging);
                    break;
                case BatteryManager.BATTERY_STATUS_FULL:
                    batteryStatus = getString(R.string.full);
                    break;
                case BatteryManager.BATTERY_STATUS_UNKNOWN:
                    batteryStatus = getString(R.string.unknown);
                    break;
                default:
                    batteryStatus = getString(R.string.discharging);
                    break;
            }

            int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
            switch (chargePlug) {
                case BatteryManager.BATTERY_PLUGGED_USB:
                    batteryPlug = getString(R.string.usb);
                    break;
                case BatteryManager.BATTERY_PLUGGED_AC:
                    batteryPlug = getString(R.string.ac);
                    break;
                case BatteryManager.BATTERY_PLUGGED_WIRELESS:
                    batteryPlug = getString(R.string.wireless);
                    break;
                default:
                    batteryPlug = getString(R.string.no);
                    break;
            }

            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

            if (level != -1 && scale != -1) {
                int batteryPct = (int) ((level / (float)scale) * 100f);
                batteryPercentage = batteryPct + " %";
            }
            else {
                batteryPercentage = getString(R.string.unknown);
            }

            status.setText(getString(R.string.status, batteryStatus));
            plug.setText(getString(R.string.plugged, batteryPlug));
            percentage.setText(getString(R.string.percentage, batteryPercentage));
        }
    }
}
