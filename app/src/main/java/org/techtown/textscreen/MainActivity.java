package org.techtown.textscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button sendButton, closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        sendButton = (Button) findViewById(R.id.sendButton);
        closeButton = (Button) findViewById(R.id.closeButton);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(80)});
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textView.setText(s.toString().getBytes().length + " / 80 byte");
            }

            @Override
            public void afterTextChanged(Editable s) {
                
            }
        });
    }

    public void sendButtonClicked(View v) {
        Toast.makeText(getApplicationContext(), editText.getText(), Toast.LENGTH_LONG).show();
    }

    public void closeButtonClicked(View v) {
        finish();
    }
}
