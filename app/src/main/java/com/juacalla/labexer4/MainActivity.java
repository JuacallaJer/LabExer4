package com.juacalla.labexer4;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_paragraph;
    TextView tvdisplay;
    Button SaveButton;
    Button DisplayButton;
    Button ClearButton;
    SharedPreferences sharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_paragraph = (EditText) findViewById(R.id.et_paragraph);
        SaveButton = (Button) findViewById(R.id.btn_save);
        DisplayButton = (Button) findViewById(R.id.btn_display);
        ClearButton = (Button) findViewById(R.id.btn_clear);

        tvdisplay = (TextView) findViewById(R.id.tv_display);
        sharedpref = getPreferences(Context.MODE_PRIVATE);
    }

    public void saveInfo(View View) {
        SharedPreferences.Editor editor = sharedpref.edit();
        editor.putString("message", et_paragraph.getText().toString());
        editor.commit();
        Toast.makeText(this, "The message was saved!", Toast.LENGTH_SHORT).show();
    }

    public void clearInfo(View View) {
        tvdisplay.setText("");
    }

    public void displayInfo(View view){
        String message = sharedpref.getString("message", "");
        tvdisplay.setText(message);
    }
}

