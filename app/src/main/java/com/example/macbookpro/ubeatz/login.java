package com.example.macbookpro.ubeatz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.macbookpro.ubeatz.util.SharedPrefManager;
import com.example.macbookpro.ubeatz.util.api.BaseApiService;
import com.example.macbookpro.ubeatz.util.api.UtilsApi;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.Callable;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {

    private TextView textview_signup,textview_forgot,txtView3,txtView4,textView19;
    private Button buttonlogin,btnTry;
    private ImageView imageBack;
    private Boolean result;
    private EditText edittext;
    private String ids;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;
    @BindView(R.id.txt_username) EditText etUsername;
    @BindView(R.id.txt_password) EditText etPassword;
    Context mContext;
    BaseApiService mApiService;
    SharedPrefManager sharedPrefManager;
    CallbackManager mFacebookCallbackManager;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.black)));
        getSupportActionBar().setTitle("");

        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper
        sharedPrefManager = new SharedPrefManager(this);

        ids = sharedPrefManager.getSpId();
        if(ids.isEmpty()){

        }else{
            Intent intent = new Intent(login.this,
                    main.class);
            startActivity(intent);
        }

        textview_signup    = (TextView) findViewById(R.id.textView2);
        textview_forgot    = (TextView) findViewById(R.id.textView);

        etUsername = (EditText) findViewById(R.id.txt_username);
        etPassword = (EditText) findViewById(R.id.txt_password);

        buttonlogin = (Button) findViewById(R.id.loginbutton);

        Typeface typeface = ResourcesCompat.getFont(this, R.font.petitabold);
        Typeface typeface2 = ResourcesCompat.getFont(this, R.font.petitamedium);
        etUsername.setTypeface(typeface);
        etPassword.setTypeface(typeface);
        buttonlogin.setTypeface(typeface);
        textview_signup.setTypeface(typeface2);
        textview_forgot.setTypeface(typeface2);

        textview_signup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /*
                 * Intent is just like glue which helps to navigate one activity
                 * to another.
                 */
                Intent intent = new Intent(login.this,
                        register.class);
                startActivity(intent); // startActivity allow you to move

            }
        });

        textview_forgot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                final AlertDialog dialog = new AlertDialog.Builder(mContext).create();
                inflater = getLayoutInflater();
                dialogView = inflater.inflate(R.layout.dialog_forgot, null);
                Button btnSend = (Button) dialogView.findViewById(R.id.btnSend);
                Typeface typeface = ResourcesCompat.getFont(mContext, R.font.petitabold);
                Typeface typeface2 = ResourcesCompat.getFont(mContext, R.font.petitamedium);
                imageBack    = (ImageView) dialogView.findViewById(R.id.imageView16);
                edittext    = (EditText) dialogView.findViewById(R.id.editText);
                txtView3    = (TextView) dialogView.findViewById(R.id.textView3);
                txtView4    = (TextView) dialogView.findViewById(R.id.textView4);
                txtView3.setTypeface(typeface);
                txtView4.setTypeface(typeface2);
                edittext.setTypeface(typeface2);
                btnSend.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        finish();

                    }
                });
                imageBack.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        dialog.dismiss();

                    }
                });

                dialog.setView(dialogView);
                dialog.setCancelable(true);
//                                    dialog.setIcon(R.mipmap.ic_launcher);
//                dialog.setTitle("Forgot Password?");
                dialog.show();

            }
        });

        buttonlogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (etUsername.getText().toString().trim().length() > 0 ) {
                    if(etPassword.getText().toString().trim().length() > 0){
//                        Intent intent = new Intent(login.this,
//                                main.class);
//                        startActivity(intent);
                        requestLogin();
                    }else{
                        final AlertDialog dialog = new AlertDialog.Builder(mContext).create();
                        inflater = getLayoutInflater();
                        dialogView = inflater.inflate(R.layout.dialog_required, null);
                        Typeface typeface = ResourcesCompat.getFont(mContext, R.font.petitabold);
                        Typeface typeface2 = ResourcesCompat.getFont(mContext, R.font.petitamedium);
                        txtView3    = (TextView) dialogView.findViewById(R.id.textView3);
                        txtView4    = (TextView) dialogView.findViewById(R.id.textView4);
                        btnTry = (Button) dialogView.findViewById(R.id.btnTry);
                        txtView3.setTypeface(typeface);
                        txtView4.setTypeface(typeface2);
                        btnTry.setTypeface(typeface);

                        txtView3.setText("Password field is required");

                        btnTry.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });

                        dialog.setView(dialogView);
                        dialog.setCancelable(true);
                        dialog.show();
                        // Prompt user to enter credentials
//                        Toast.makeText(getApplicationContext() ,"Password field is required", Toast.LENGTH_LONG).show();
                    }
                }else{
                    final AlertDialog dialog = new AlertDialog.Builder(mContext).create();
                    inflater = getLayoutInflater();
                    dialogView = inflater.inflate(R.layout.dialog_required, null);
                    Typeface typeface = ResourcesCompat.getFont(mContext, R.font.petitabold);
                    Typeface typeface2 = ResourcesCompat.getFont(mContext, R.font.petitamedium);
                    txtView3    = (TextView) dialogView.findViewById(R.id.textView3);
                    txtView4    = (TextView) dialogView.findViewById(R.id.textView4);
                    btnTry = (Button) dialogView.findViewById(R.id.btnTry);
                    txtView3.setTypeface(typeface);
                    txtView4.setTypeface(typeface2);
                    btnTry.setTypeface(typeface);

                    txtView3.setText("Username field is required");

                    btnTry.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialog.setView(dialogView);
                    dialog.setCancelable(true);
                    dialog.show();
                    // Prompt user to enter credentials
//                    Toast.makeText(getApplicationContext() ,"Username field is required", Toast.LENGTH_LONG).show();
                }

            }
        });

        //Facebook Login
        FacebookSdk.sdkInitialize(getApplicationContext());
        mFacebookCallbackManager = CallbackManager.Factory.create();

        AccessTokenTracker accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {

            }
        };
        ProfileTracker profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {

            }
        };

        LoginButton mFacebookSignInButton = (LoginButton)findViewById(R.id.login_button);
        mFacebookSignInButton.setReadPermissions(Arrays.asList("email","public_profile"));
        mFacebookSignInButton.registerCallback(mFacebookCallbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(final LoginResult loginResult) {
                        //TODO: Use the Profile class to get information about the current user.
                        AccessToken accessToken = loginResult.getAccessToken();
                        Profile profile = Profile.getCurrentProfile();
                        GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(),
                                new GraphRequest.GraphJSONObjectCallback() {
                                    @Override
                                    public void onCompleted(JSONObject object, GraphResponse response) {
                                        Log.e("aa", ""+response.toString());
                                        try {
                                            Toast.makeText(getApplicationContext(), "Hi, " + object.getString("name"), Toast.LENGTH_LONG).show();
                                        } catch(JSONException ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                                });
                        Bundle parameters = new Bundle();
                        parameters.putString("fields", "id,name");
                        request.setParameters(parameters);
                        request.executeAsync();
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(getApplication(), "Login Gagal", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(FacebookException error) {
                        Log.d(login.class.getCanonicalName(), error.getMessage());
                        Toast.makeText(getApplication(), "Login Error", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        //Instagram Login
//        Button mInstagramSignInButton = (Button)findViewById(R.id.instagram_sign_in_button);
//        mInstagramSignInButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                signInWithInstagram();
//            }
//        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // (...)

        mFacebookCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void signInWithInstagram() {
        final Uri.Builder uriBuilder = new Uri.Builder();
        uriBuilder.scheme("https")
                .authority("api.instagram.com")
                .appendPath("oauth")
                .appendPath("authorize")
                .appendQueryParameter("client_id", "d002aab6224a484abf93e53d88909442")
                .appendQueryParameter("redirect_uri", "sociallogin://redirect")
                .appendQueryParameter("response_type", "token");
        final Intent browser = new Intent(Intent.ACTION_VIEW, uriBuilder.build());
        startActivity(browser);
    }

    private void checkForInstagramData() {
        final Uri data = this.getIntent().getData();
        if(data != null && data.getScheme().equals("sociallogin") && data.getFragment() != null) {
            final String accessToken = data.getFragment().replaceFirst("access_token=", "");
            if (accessToken != null) {
                // handleSignInResult(...);
            } else {
                // handleSignInResult(...);
            }
        }
    }


    // untuk menampilkan dialog incorrect password
    private void DialogForm(String error) {
        final AlertDialog dialog = new AlertDialog.Builder(this).create();
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_incorrect, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
//        dialog.setTitle("Incorrect Username / Password");
        dialog.show();
        btnTry = (Button) dialogView.findViewById(R.id.btnTry);

        Typeface typeface = ResourcesCompat.getFont(mContext, R.font.petitabold);
        Typeface typeface2 = ResourcesCompat.getFont(mContext, R.font.petitamedium);
        textView19    = (TextView) dialogView.findViewById(R.id.textView19);
        txtView3    = (TextView) dialogView.findViewById(R.id.textView3);
        txtView4    = (TextView) dialogView.findViewById(R.id.textView4);
        txtView3.setTypeface(typeface);
        txtView4.setTypeface(typeface2);
        textView19.setTypeface(typeface);
        btnTry.setTypeface(typeface);

        btnTry.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }


    private void requestLogin(){
        mApiService.loginRequest(etUsername.getText().toString(),etPassword.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                result = jsonRESULTS.getBoolean(SharedPrefManager.SP_RETURN);
                                if (result == true){
                                    // Jika login berhasil maka data nama yang ada di response API
                                    // akan diparsing ke activity selanjutnya.
                                    Toast.makeText(mContext, "Berhasil Login", Toast.LENGTH_SHORT).show();
                                    String id = jsonRESULTS.getJSONArray("data").getJSONObject(0).getString("id");
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_ID, id);
                                    String username = jsonRESULTS.getJSONArray("data").getJSONObject(0).getString("username");
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_USERNAME, username);
                                    String fullname = jsonRESULTS.getJSONArray("data").getJSONObject(0).getString("fullname");
                                    sharedPrefManager.saveSPString(SharedPrefManager.SP_FULLNAME, fullname);
                                    // Shared Pref ini berfungsi untuk menjadi trigger session login
                                    sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, true);
//                                    sharedPrefManager = new SharedPrefManager(mContext);
                                    startActivity(new Intent(mContext, main.class)
                                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                                    finish();
                                } else {
                                    String error_message = jsonRESULTS.getString("status");
                                    DialogForm(error_message);
//                                    DialogForm(error_message);
//                                    Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Toast.makeText(mContext, "Gagal login", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
                    }
                });
    }
}
