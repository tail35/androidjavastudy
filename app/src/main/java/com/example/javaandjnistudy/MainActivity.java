package com.example.javaandjnistudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.javaandjnistudy.databinding.ActivityMainBinding;
import com.example.mymodule.*;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'javaandjnistudy' library on application startup.
    static {
        System.loadLibrary("javaandjnistudy");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());
        mymain lmymain = new mymain();
        lmymain.myPrint();
    }

    /**
     * A native method that is implemented by the 'javaandjnistudy' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}