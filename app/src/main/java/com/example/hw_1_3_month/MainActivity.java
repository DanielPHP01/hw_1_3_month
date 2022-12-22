package com.example.hw_1_3_month;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText1;
    EditText email;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisView();
        setClickListener();
    }

    private void setClickListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startVibration();
                startIntent();
            }
        });
    }

    private void startVibration() {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            v.vibrate(100000);
        }
    }

    private void startIntent() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});
        intent.putExtra(Intent.EXTRA_SUBJECT, editText.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT, editText1.getText().toString());
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "dfsdfsdfw"));
    }

    private void inisView() {
        email = findViewById(R.id.editTextTextEmailAddress);
        editText1 = findViewById(R.id.edit_text_two);
        editText = findViewById(R.id.edit_text_one);
        button = findViewById(R.id.button);
    }
}