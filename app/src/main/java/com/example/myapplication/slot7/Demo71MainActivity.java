package com.example.myapplication.slot7;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.myapplication.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo71MainActivity extends AppCompatActivity {
    Context context = this;
    EditText txt1;
    TextView tvResult;
    Button btnRead, btnSave;
    //------
    EditText txtU, txtP;
    Button btnLogin, btnCancel;
    CheckBox chkSave;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo71_login_layout);
        txtU = findViewById(R.id.demo71LoginTxtU);
        txtP = findViewById(R.id.demo71LoginTxtP);
        btnLogin = findViewById(R.id.demo71LoginBtnLog);
        btnCancel = findViewById(R.id.demo71LoginBtnCancel);
        chkSave = findViewById(R.id.demo71LoginChkCheck);
        restorePass();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        /* txt1=findViewById(R.id.demo71TxtInput); tvResult=findViewById(R.id.demo71TvResult); btnRead=findViewById(R.id.demo71BtnRead); btnSave=findViewById(R.id.demo71BtnSave); requestPermission(); btnSave.setOnClickListener(new View.OnClickListener() { @Override public void onClick(View v) { saveData(txt1.getText().toString(),context); } }); btnRead.setOnClickListener(new View.OnClickListener() { @Override public void onClick(View v) { String data=readData(context); tvResult.setText(data); } }); */
    }

    //login
    String strU, strP;

    public void login() {
        strU = txtU.getText().toString();
        strP = txtP.getText().toString();
        if (strU.isEmpty() || strP.isEmpty()) {
            Toast.makeText(getApplicationContext(), "U,P is not empty", Toast.LENGTH_LONG).show();
            return;
        }
        if (strU.equalsIgnoreCase("admin") && strP.equalsIgnoreCase("admin")) {
            saveUPToPreference(strU, strP, chkSave.isChecked());
            Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_LONG).show();
        }
    }

    //save data to file
    public void saveDataToFile(String data) {
//B1- get path
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/data1.txt";
//B2- create a stream for saving
        try {
            OutputStreamWriter o = new OutputStreamWriter(new FileOutputStream(path));
//B3- write data o.write(data);
            o.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean requestPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.MANAGE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                ActivityCompat.requestPermissions(Demo71MainActivity.this, new String[]{
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.MANAGE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        } else {
            return true;
        }
    }

    public String saveData(String data, Context context) {
//B1- get path
        String path = "";
        ContextWrapper cw = new ContextWrapper(context);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD_MR1) {
            path = cw.getExternalFilesDir(Environment.DIRECTORY_DCIM) + "/data1.txt";
        } else {
            path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/data1.txt";
        }
//B2- create a stream for saving
        try {
            OutputStreamWriter o = new OutputStreamWriter(new FileOutputStream(path));
//B3- write data
            o.write(data);
            o.close();
            return "Save data successful";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    //android API 32
    public String readData(Context context) {
        String result = "";
        String path = "";
        ContextWrapper cw = new ContextWrapper(context);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD_MR1) {
            path = cw.getExternalFilesDir(Environment.DIRECTORY_DCIM) + "/data1.txt";
        } else {
            path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/data1.txt";
        }
        try {
            Scanner s = new Scanner(new File(path));
            while (s.hasNext()) {
                result = s.nextLine() + "\n";
            }
            s.close();
        } catch (
                FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public String readDataFromFile() {
        String data = "";
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/data1.txt";
        try {
            Scanner s = new Scanner(new File(path));
            while (s.hasNext()) {
                data = s.nextLine() + "\n";
            }
            s.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public void saveUPToPreference(String u, String p, boolean status) {
//b1-create file for saving
        SharedPreferences sharedPreferences = getSharedPreferences("H_FILE", MODE_PRIVATE);
//b2-Enable editor mode:
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (!status)//if exist password {
            editor.clear();//clear old password }
        else {
//save new data editor.putString("USERNAME",u);
            editor.putString("PASSWORD", p);
            editor.putBoolean("REMEMBER", status);
        }
//commit data to file editor.commit();
    }

    public List<Object> restorePass() {
        List<Object> list = new ArrayList<>();
//B1- open file
        SharedPreferences sharedPreferences = getSharedPreferences("H_FILE", MODE_PRIVATE);
//b2- check request
        boolean check = sharedPreferences.getBoolean("REMEMBER", false);
        if (check) {
            String u = sharedPreferences.getString("USERNAME", "");
            txtU.setText(u);
            String p = sharedPreferences.getString("PASSWORD", "");
            txtP.setText(p);
            list.add(u);
            list.add(p);
            list.add(check);
        }
        chkSave.setChecked(check);
        return list;
    }
}