package com.example.xz2dai.myapplication1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {

    private Button torich;
	private TextView richnum;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		torich = (Button)findViewById(R.id.torich);
		richnum = (TextView)findViewById(R.id.richnum);
		torich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                richnum.setText("测试文本2");
            }
        });
    }
}
