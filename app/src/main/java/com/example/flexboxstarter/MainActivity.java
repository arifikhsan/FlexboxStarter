package com.example.flexboxstarter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.flexbox.FlexboxLayout;

public class MainActivity extends AppCompatActivity {

    public Button button;
    public EditText editText;
    public FlexboxLayout flexboxLayout, flexboxLayoutTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        flexboxLayout = findViewById(R.id.flexboxLayout);
        flexboxLayoutTop = findViewById(R.id.flexboxLayoutTop);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = Integer.parseInt(editText.getText().toString());
                if (number > 1) {
                    setTextViewInFlexbox(number);
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void setTextViewInFlexbox(Integer number) {
        flexboxLayoutTop.removeAllViews();
        flexboxLayout.removeAllViews();
        for (Integer i = 1; i <= number; i++) {
            TextView textView = new TextView(this);
            textView.setText(i.toString());
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16F);
            textView.setGravity(Gravity.CENTER);
            textView.setBackground(getResources().getDrawable(R.drawable.circle_text_flexbox));
            textView.setTextColor(getResources().getColor(android.R.color.white));

            FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(
                    FlexboxLayout.LayoutParams.WRAP_CONTENT,
                    FlexboxLayout.LayoutParams.WRAP_CONTENT
            );

            layoutParams.setMargins(10, 10, 10, 10);
            textView.setLayoutParams(layoutParams);
            flexboxLayout.addView(textView);
        }

        for (Integer i = 1; i <= number; i++) {
            TextView textView = new TextView(this);
            textView.setText(i.toString());
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16F);
            textView.setGravity(Gravity.CENTER);
            textView.setBackground(getResources().getDrawable(R.drawable.circle_text_flexbox));
            textView.setTextColor(getResources().getColor(android.R.color.white));

            FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(
                    FlexboxLayout.LayoutParams.WRAP_CONTENT,
                    FlexboxLayout.LayoutParams.WRAP_CONTENT
            );

            layoutParams.setMargins(10, 10, 10, 10);
            textView.setLayoutParams(layoutParams);
            flexboxLayoutTop.addView(textView);
        }
    }
}
