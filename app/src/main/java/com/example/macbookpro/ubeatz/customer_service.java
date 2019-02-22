package com.example.macbookpro.ubeatz;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.macbookpro.ubeatz.util.SharedPrefManager;
import com.example.macbookpro.ubeatz.util.api.BaseApiService;
import com.example.macbookpro.ubeatz.util.api.UtilsApi;

import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class customer_service extends AppCompatActivity {

    TextView textView58,textView59,textView60,txtView3,textView19;
    EditText editText5,editText6,editText11;
    Button button15,btnTry;
    ImageView imgView;
    BaseApiService mApiService;
    Context mContext;
    SharedPrefManager sharedPrefManager;
    LayoutInflater inflater;
    View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_service);
        getSupportActionBar().hide();

        imgView = (ImageView) findViewById(R.id.imageView13);
        imgView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                finish();
            }
        });

        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService();
        sharedPrefManager = new SharedPrefManager(this);

        textView58 = (TextView) findViewById(R.id.textView58);
        textView59 = (TextView) findViewById(R.id.textView59);
        textView60 = (TextView) findViewById(R.id.textView60);
//        editText5 = (EditText) findViewById(R.id.editText5);
//        editText6 = (EditText) findViewById(R.id.editText6);
        editText11 = (EditText) findViewById(R.id.editText11);
        button15 = (Button) findViewById(R.id.button15);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.petitabold);
        Typeface typeface2 = ResourcesCompat.getFont(this, R.font.petitamedium);
        textView58.setTypeface(typeface2);
        textView59.setTypeface(typeface2);
//        editText5.setTypeface(typeface2);
//        editText6.setTypeface(typeface2);
        editText11.setTypeface(typeface2);
        textView60.setTypeface(typeface2);
        button15.setTypeface(typeface2);

        button15.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sendFeedback(sharedPrefManager.getSpId(),editText11.getText().toString());
                editText11.setText("");

                final AlertDialog dialog = new AlertDialog.Builder(mContext).create();
                inflater = getLayoutInflater();
                dialogView = inflater.inflate(R.layout.dialog_feedback, null);
                Typeface typeface = ResourcesCompat.getFont(mContext, R.font.petitabold);
                Typeface typeface2 = ResourcesCompat.getFont(mContext, R.font.petitamedium);
                txtView3    = (TextView) dialogView.findViewById(R.id.textView3);
                textView19  = (TextView) dialogView.findViewById(R.id.textView19);
                btnTry = (Button) dialogView.findViewById(R.id.btnTry);
                txtView3.setTypeface(typeface);
                textView19.setTypeface(typeface2);
                btnTry.setTypeface(typeface);

                btnTry.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.setView(dialogView);
                dialog.setCancelable(true);
                dialog.show();
            }
        });
    }

    private void sendFeedback(String id_user, String feedback){
        mApiService.getInsertFeedbackRequest(id_user, feedback).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                if (response.isSuccessful()){
//                    try {
//                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
//                        result = jsonRESULTS.getBoolean(SharedPrefManager.SP_RETURN);
//                        if (result == true){
//                            Toast.makeText(mContext, "sukses", Toast.LENGTH_SHORT).show();
//                        } else {
////                            String error_message = jsonRESULTS.getString("status");
////                            DialogForm(error_message);
//////                                    DialogForm(error_message);
//                            Toast.makeText(mContext, "Tidak dapat menampilkan", Toast.LENGTH_SHORT).show();
//                        }
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                } else {
//                    Toast.makeText(mContext, "Gagal login", Toast.LENGTH_SHORT).show();
//                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
