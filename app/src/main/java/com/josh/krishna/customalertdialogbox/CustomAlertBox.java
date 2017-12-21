package com.josh.krishna.customalertdialogbox;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by anujaj on 21/12/17.
 */

public class CustomAlertBox extends DialogFragment {

    private boolean status = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);
        status = getArguments().getBoolean("STATUS");

    }

    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.getWindow().setWindowAnimations(R.style.DialogAnimation);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle state) {
        super.onCreateView(inflater, parent, state);

        View view = getActivity().getLayoutInflater().inflate(R.layout.alert, parent, false);
        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        if(status){
            imageView.setImageResource(R.drawable.ic_success);
        }else {
            imageView.setImageResource(R.drawable.ic_error);
        }
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                dismiss();
            }
        }, 1000);


        return view;
    }

    public static CustomAlertBox newInstance(boolean num) {
        CustomAlertBox customAlertBox = new CustomAlertBox();
        Bundle args = new Bundle();
        args.putBoolean("STATUS", num);
        customAlertBox.setArguments(args);
        return customAlertBox;
    }


}
