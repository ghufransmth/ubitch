package com.example.macbookpro.ubeatz;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.macbookpro.ubeatz.util.SharedPrefManager;
import com.example.macbookpro.ubeatz.util.api.BaseApiService;
import com.example.macbookpro.ubeatz.util.api.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class verify extends AppCompatActivity {

    private Button button;
    private EditText kode1, kode2, kode3, kode4;
    private TextView textView10,textView11,textView12,textView13,textView14,textView15;
    private Boolean result;
    Context mContext;
    BaseApiService mApiService;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.black)));
        getSupportActionBar().setTitle("");

        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper
        sharedPrefManager = new SharedPrefManager(this);

        button = (Button) findViewById(R.id.button5);
        kode1    = (EditText) findViewById(R.id.editText7);
        kode2    = (EditText) findViewById(R.id.editText8);
        kode3    = (EditText) findViewById(R.id.editText9);
        kode4    = (EditText) findViewById(R.id.editText10);
        textView10    = (TextView) findViewById(R.id.textView10);
        textView11    = (TextView) findViewById(R.id.textView11);
        textView12    = (TextView) findViewById(R.id.textView12);
        textView13    = (TextView) findViewById(R.id.textView13);
        textView14    = (TextView) findViewById(R.id.textView14);
        textView15    = (TextView) findViewById(R.id.textView15);
        textView13.setText(sharedPrefManager.getSpEmail());

        Typeface typeface = ResourcesCompat.getFont(this, R.font.petitabold);
        Typeface typeface2 = ResourcesCompat.getFont(this, R.font.petitamedium);
        textView10.setTypeface(typeface2);
        textView11.setTypeface(typeface2);
        textView12.setTypeface(typeface2);
        textView13.setTypeface(typeface2);
        textView14.setTypeface(typeface2);
        textView15.setTypeface(typeface2);
        button.setTypeface(typeface);

        kode1.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(kode1.getText().toString().length()==1)     //size as per your requirement
                {
                    kode2.requestFocus();
                }
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

        });

        kode2.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(kode2.getText().toString().length()==1)     //size as per your requirement
                {
                    kode3.requestFocus();
                }
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

        });

        kode3.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(kode3.getText().toString().length()==1)     //size as per your requirement
                {
                    kode4.requestFocus();
                }
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

        });

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /*
                 * Intent is just like glue which helps to navigate one activity
                 * to another.
                 */
//                Intent intent = new Intent(verify.this,
//                        main.class);
//                startActivity(intent); // startActivity allow you to move
                requestVerify();

            }
        });
    }

    private void requestVerify(){
        mApiService.verifyRequest(textView13.getText().toString(),kode1.getText().toString()+kode2.getText().toString()+kode3.getText().toString()+kode4.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(mContext, "Berhasil Verifikasi", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(mContext, main.class)
                                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                            finish();
//                            try {
//                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
//                                result = jsonRESULTS.getBoolean(SharedPrefManager.SP_RETURN);
//                                if (result == true){
//                                    // Jika login berhasil maka data nama yang ada di response API
//                                    // akan diparsing ke activity selanjutnya.
//                                    Toast.makeText(mContext, "Berhasil Verifikasi", Toast.LENGTH_SHORT).show();
//                                    String id = jsonRESULTS.getJSONObject("result").getString("id");
//                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_ID, id);
//                                    Toast.makeText(mContext, "Your ID: "+id, Toast.LENGTH_SHORT).show();
//                                    startActivity(new Intent(mContext, main.class)
//                                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
//                                    finish();
//                                } else {
//                                    String error_message = jsonRESULTS.getString("status");
//                                    Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
//                                }
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
                        } else {
                            Toast.makeText(mContext, "Gagal verifikasi", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
                    }
                });
    }
}
