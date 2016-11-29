package com.example.alex.fragmentsexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements MainFragment.OnFragmentInteractionListener {

    private Button button;

    private MainFragment mainFragment;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btn1);

        // add fragment to activity
        mainFragment = MainFragment.newInstance("some text we could use in fragment");
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fl_container, mainFragment, MainFragment.class.getSimpleName())
                .commit();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;

                if (count % 2 == 0) {
                    // call some fragment's method from activity
                    mainFragment.method("some text...");
                } else {
                    // or
                    MainFragment mainFragment1 = (MainFragment) getSupportFragmentManager().findFragmentByTag(MainFragment.class.getSimpleName());
                    mainFragment1.method("some text... 123...");
                }
            }
        });
    }

    @Override
    public void onFragmentInteraction(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}