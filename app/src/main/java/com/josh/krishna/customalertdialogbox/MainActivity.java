package com.josh.krishna.customalertdialogbox;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);


        Button btn_showdialog =(Button)findViewById(R.id.btn_showdialog);
        btn_showdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomAlertBox dialog = CustomAlertBox.newInstance(false);
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                dialog.show(ft, "FULL SCREEN DIALOG");
            }
        });
    }
}
