package com.example.chat_room_withfirebase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog dialog=new AlertDialog.Builder(this).create();
        final EditText editText= new EditText(this);
        dialog.setTitle("enter your name");
        dialog.setView(editText);
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String name=editText.getText().toString();
                if(!TextUtils.isEmpty(name)){
                    Intent intent=new Intent(MainActivity.this,ChatRoom.class);
                    intent.putExtra("Name",name);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "Enter your name: ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog.show();
    }
}