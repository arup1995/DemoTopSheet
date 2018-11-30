package com.example.pc43.demotopsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private ImageView mFilterIcon;
    ImageView dCloseIcon;
    RelativeLayout dDone;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeView();
        OnClickListener();
    }

    private void OnClickListener() {
        mFilterIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTopSheetDialog();
            }
        });
    }

    private void initializeView() {
        mFilterIcon = findViewById(R.id.filterIcon);

    }

    public void showTopSheetDialog() {
        View view = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
        initializeDialogView(view);
        DialogOnClickListener();
        dialog = new Dialog(MainActivity.this, R.style.MyDialog);
        Window window = dialog.getWindow();
        if (window != null) {
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
            window.setGravity(Gravity.TOP);
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setLayout(width, height);
            dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

    private void DialogOnClickListener() {
        dCloseIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    private void initializeDialogView(View view) {
        dCloseIcon = view.findViewById(R.id.closeDialog);
        dDone = view.findViewById(R.id.done);
    }
}
