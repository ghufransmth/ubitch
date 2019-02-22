package com.example.macbookpro.ubeatz;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.macbookpro.ubeatz.util.SharedPrefManager;
import com.example.macbookpro.ubeatz.util.api.BaseApiService;
import com.example.macbookpro.ubeatz.util.api.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class register extends AppCompatActivity {

    EditText editText11;
    private Button buttonregister,btnDate,buttonselectdate,btnTry;
    private int mYear, mMonth, mDay;
    private Boolean result;
    private Spinner spinner,spinner2,spinner3;
    private TextView textEmail,textFullname,textBirthday,textUsername,textPassword,textLogin,textForgot,textExtra,textExtra2,textDate,txtView3,txtView4,textView19;
    @BindView(R.id.txt_username) EditText etUsername;
    @BindView(R.id.txt_password) EditText etPassword;
    @BindView(R.id.txt_email) EditText etEmail;
    @BindView(R.id.txt_fullname) EditText etFullname;
    private static final String[] paths = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    private static final String[] paths2 = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
    private static final String[] paths3 = {"1984","1985","1986","1987","1988","1989","1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000"};
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;
    Context mContext;
    BaseApiService mApiService;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.black)));
        getSupportActionBar().setTitle("");

        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper
        sharedPrefManager = new SharedPrefManager(this);

        etEmail = (EditText) findViewById(R.id.txt_email);
        etFullname = (EditText) findViewById(R.id.txt_fullname);
        etUsername = (EditText) findViewById(R.id.txt_username);
        etPassword = (EditText) findViewById(R.id.txt_password);

        textEmail = (TextView) findViewById(R.id.textEmail);
        textFullname = (TextView) findViewById(R.id.textFullname);
        textBirthday = (TextView) findViewById(R.id.textBirthday);
        textUsername = (TextView) findViewById(R.id.textUsername);
        textPassword = (TextView) findViewById(R.id.textPassword);
        textLogin = (TextView) findViewById(R.id.textLogin);
//        textForgot = (TextView) findViewById(R.id.textForgot);
        textExtra = (TextView) findViewById(R.id.textExtra);
        textExtra2 = (TextView) findViewById(R.id.textExtra2);
        textDate = (TextView) findViewById(R.id.textView20);

        buttonregister = (Button) findViewById(R.id.button2);
        buttonselectdate = (Button) findViewById(R.id.selectdate);

        Typeface typeface = ResourcesCompat.getFont(this, R.font.petitabold);
        Typeface typeface2 = ResourcesCompat.getFont(this, R.font.petitamedium);
        textEmail.setTypeface(typeface);
        textFullname.setTypeface(typeface);
        textBirthday.setTypeface(typeface);
        textUsername.setTypeface(typeface);
        textPassword.setTypeface(typeface);
        textLogin.setTypeface(typeface2);
//        textForgot.setTypeface(typeface2);
        textExtra.setTypeface(typeface2);
        textExtra2.setTypeface(typeface2);
        textDate.setTypeface(typeface2);
        buttonregister.setTypeface(typeface);
        buttonselectdate.setTypeface(typeface);
        etEmail.setTypeface(typeface2);
        etFullname.setTypeface(typeface2);
        etUsername.setTypeface(typeface2);
        etPassword.setTypeface(typeface2);

        etPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (etPassword.getText().toString().trim().length() < 6) {
                        Toast.makeText(getApplicationContext() ,"Password minimum 6 character", Toast.LENGTH_LONG).show();
                    } else {
                        // your code here
                        etPassword.setError(null);
                    }
                } else {
                    if (etPassword.getText().toString().trim().length() < 6) {
                        Toast.makeText(getApplicationContext() ,"Password minimum 6 character", Toast.LENGTH_LONG).show();
                    } else {
                        // your code here
                        etPassword.setError(null);
                    }
                }

            }
        });


//        spinner = (Spinner)findViewById(R.id.spinner);
//        ArrayAdapter<String>adapter = new ArrayAdapter<String>(register.this,
//                android.R.layout.simple_spinner_dropdown_item,paths);
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        spinner2 = (Spinner)findViewById(R.id.spinner2);
//        ArrayAdapter<String>adapter2 = new ArrayAdapter<String>(register.this,
//                android.R.layout.simple_spinner_dropdown_item,paths2);
//        spinner2.setAdapter(adapter2);
//        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        spinner3 = (Spinner)findViewById(R.id.spinner3);
//        ArrayAdapter<String>adapter3 = new ArrayAdapter<String>(register.this,
//                android.R.layout.simple_spinner_dropdown_item,paths3);
//        spinner3.setAdapter(adapter3);
//        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        textLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(register.this,
                        login.class);
                startActivity(intent);
            }
        });

        buttonregister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                    if (etPassword.getText().toString().trim().length() < 6 ) {
                        final AlertDialog dialog = new AlertDialog.Builder(mContext).create();
                        inflater = getLayoutInflater();
                        dialogView = inflater.inflate(R.layout.dialog_required, null);
                        Typeface typeface = ResourcesCompat.getFont(mContext, R.font.petitabold);
                        Typeface typeface2 = ResourcesCompat.getFont(mContext, R.font.petitamedium);
                        txtView3    = (TextView) dialogView.findViewById(R.id.textView3);
                        txtView4    = (TextView) dialogView.findViewById(R.id.textView4);
                        textView19    = (TextView) dialogView.findViewById(R.id.textView19);
                        btnTry = (Button) dialogView.findViewById(R.id.btnTry);
                        txtView3.setTypeface(typeface);
                        txtView4.setTypeface(typeface2);
                        btnTry.setTypeface(typeface);

                        txtView3.setText("Password field must be more than 6 character");
                        textView19.setText("Incorrect Password");

                        btnTry.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });

                        dialog.setView(dialogView);
                        dialog.setCancelable(true);
                        dialog.show();
                    }else{
                        requestRegister();
                    }

            }
        });

        buttonselectdate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(mContext,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                StringBuilder date = new StringBuilder();
                                date.delete(0, date.length());
                                date.append(year)
                                        .append("-")
                                        .append((monthOfYear + 1) < 10 ? "0" : "")
                                        .append((monthOfYear + 1))
                                        .append("-")
                                        .append((dayOfMonth < 10 ? "0" : ""))
                                        .append(dayOfMonth);

                                textDate.setText(date.toString());
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

//        btnDate.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//
//                // Get Current Date
//                final Calendar c = Calendar.getInstance();
//                mYear = c.get(Calendar.YEAR);
//                mMonth = c.get(Calendar.MONTH);
//                mDay = c.get(Calendar.DAY_OF_MONTH);
//
//
//                DatePickerDialog datePickerDialog = new DatePickerDialog(register.this,
//                        new DatePickerDialog.OnDateSetListener() {
//
//                            @Override
//                            public void onDateSet(DatePicker view, int year,
//                                                  int monthOfYear, int dayOfMonth) {
//
//                                StringBuilder date = new StringBuilder();
//                                date.delete(0, date.length());
//                                date.append(year)
//                                        .append("-")
//                                        .append((monthOfYear + 1) < 10 ? "0" : "")
//                                        .append((monthOfYear + 1))
//                                        .append("-")
//                                        .append((dayOfMonth < 10 ? "0" : ""))
//                                        .append(dayOfMonth);
//
//
//                                editText11.setText(date.toString());
//                            }
//                        }, mYear, mMonth, mDay);
//                datePickerDialog.show();
//            }
//        });
    }

    private void requestRegister(){
        mApiService.registerRequest(etUsername.getText().toString(),etPassword.getText().toString(),etFullname.getText().toString(),etEmail.getText().toString(),null,null,null,null,null)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                result = jsonRESULTS.getBoolean(SharedPrefManager.SP_RESULT);
                                if (result == true){
                                    // Jika login berhasil maka data nama yang ada di response API
                                    // akan diparsing ke activity selanjutnya.
                                    Toast.makeText(mContext, "Berhasil register", Toast.LENGTH_SHORT).show();
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_EMAIL, etEmail.getText().toString());
                                    startActivity(new Intent(mContext, verify.class)
                                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                                    finish();
                                } else {
                                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(register.this);
                                    View mView = getLayoutInflater().inflate(R.layout.dialog_incorrect, null);
                                    mBuilder.setView(mView);
                                    final AlertDialog dialog = mBuilder.create();
                                    dialog.show();
//                                    String error_message = jsonRESULTS.getString("status");
//                                    Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Toast.makeText(mContext, "Gagal register", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
                    }
                });
    }
}
