package com.zyl.alhotfixdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTest = (TextView) findViewById(R.id.m_test);
        mTest.setText("test hotfix patch is active---------------------!!!");
    }

    public void mButtonClicked(View view) {
        Toast.makeText(this, "test hotfix patch is active-----------1----------!!!", Toast.LENGTH_LONG).show();
    }

    public void mButtonClicked2(View view) {
        Toast.makeText(this, "test hotfix patch is active-----------2----------!!!", Toast.LENGTH_LONG).show();
    }
}
