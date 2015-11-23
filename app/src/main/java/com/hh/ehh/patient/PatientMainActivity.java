package com.hh.ehh.patient;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.hh.ehh.R;
import com.hh.ehh.ui.customdialogs.CustomDialogs;
import com.hh.ehh.utils.FragmentStackManager;

public class PatientMainActivity extends AppCompatActivity {

    private FragmentStackManager fragmentStackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patient_home_fragment);
        Fragment patientHome = new PatientHomeFragment();
        fragmentStackManager = FragmentStackManager.getInstance(this);
        fragmentStackManager.loadFragment(patientHome, R.id.home_frame_container);
    }

    @Override
    public void onBackPressed() {
        if (fragmentStackManager.popBackStatFragment()) {
        } else {
            CustomDialogs.closeDialog(PatientMainActivity.this, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    finish();
                }
            }, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).show();
        }
    }
}
