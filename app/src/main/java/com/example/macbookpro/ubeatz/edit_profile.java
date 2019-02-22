package com.example.macbookpro.ubeatz;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.macbookpro.ubeatz.util.MyApplication;
import com.example.macbookpro.ubeatz.util.ServerResponse;
import com.example.macbookpro.ubeatz.util.SharedPrefManager;
import com.example.macbookpro.ubeatz.util.api.BaseApiService;
import com.example.macbookpro.ubeatz.util.api.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class edit_profile extends AppCompatActivity {

    private ImageView imgView,imageView14,imageView18;
    private Button btnChangephoto;
    private EditText sessionID,etEmail,etFullname,etUsername,etBio,etBirthday,etPhoneNumber,etGender;
    Boolean result;
    Intent intent;
    Uri fileUri;
    File file;
    Context mContext;
    Bitmap bitmap, decoded, compressedImage;
    public final int REQUEST_CAMERA = 0;
    public final int REQUEST_CODE_ASK_PERMISSIONS = 0;
    public final int SELECT_FILE = 1;
    public String selectedImagePath = "";
    int bitmap_size = 40; // image quality 1 - 100;
    int max_resolution_image = 800;
    SharedPrefManager sharedPrefManager;
    BaseApiService mApiService;
    private boolean isPermissionGranted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        getSupportActionBar().hide();

        btnChangephoto = (Button) findViewById(R.id.button7);
        TextView textEmail = (TextView) findViewById(R.id.textEmail);
        TextView textFullname = (TextView) findViewById(R.id.textFullname);
        TextView textBirthday = (TextView) findViewById(R.id.textBirthday);
        TextView textUsername = (TextView) findViewById(R.id.textUsername);
        TextView textBio = (TextView) findViewById(R.id.textBio);
        TextView textPhoneNumber = (TextView) findViewById(R.id.textPhoneNumber);
        TextView textGender = (TextView) findViewById(R.id.textGender);
        TextView textEditProfile = (TextView) findViewById(R.id.textView21);
        sessionID = (EditText) findViewById(R.id.sessionID);
        sessionID.setVisibility(View.INVISIBLE);
        etEmail = (EditText) findViewById(R.id.txt_email);
        etFullname = (EditText) findViewById(R.id.txt_fullname);
        etUsername = (EditText) findViewById(R.id.txt_username);
        etBio = (EditText) findViewById(R.id.txt_bio);
        etBirthday = (EditText) findViewById(R.id.txt_birthday);
        etPhoneNumber = (EditText) findViewById(R.id.txt_phonenumber);
        etGender = (EditText) findViewById(R.id.txt_gender);
        imageView14 = (ImageView) findViewById(R.id.imageView14);
        imageView18 = (ImageView) findViewById(R.id.imageView18);
        Typeface typeface = ResourcesCompat.getFont(this, R.font.petitabold);
        Typeface typeface2 = ResourcesCompat.getFont(this, R.font.petitamedium);
        btnChangephoto.setTypeface(typeface);
        textEmail.setTypeface(typeface2);
        textFullname.setTypeface(typeface2);
        textBirthday.setTypeface(typeface2);
        textUsername.setTypeface(typeface2);
        textBio.setTypeface(typeface2);
        textPhoneNumber.setTypeface(typeface2);
        textGender.setTypeface(typeface2);
        textEditProfile.setTypeface(typeface2);
        etEmail.setTypeface(typeface2);
        etFullname.setTypeface(typeface2);
        etBirthday.setTypeface(typeface2);
        etUsername.setTypeface(typeface2);
        etBio.setTypeface(typeface2);
        etPhoneNumber.setTypeface(typeface2);
        etGender.setTypeface(typeface2);

        if (!isPermissionGranted) {
            checkPermission();
        }

        //Menampilkan data session
        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper
        sharedPrefManager = new SharedPrefManager(this);
//        etFullname.setText(sharedPrefManager.getSpFullname());
//        etUsername.setText(sharedPrefManager.getSpUsername());
        sessionID.setText(sharedPrefManager.getSpId());
        getProfile();

        imgView = (ImageView) findViewById(R.id.imageView13);
        imgView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                finish();
            }
        });

        btnChangephoto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                selectImage();
            }
        });

        imageView18.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                updateData();
            }
        });

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

    }

    /////////////////////////////////////////////Get Profile\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    private void getProfile() {
        mApiService.getMyProfileRequest(sessionID.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                result = jsonRESULTS.getBoolean("return");
                                if (result == true){
                                    // Jika login berhasil maka data nama yang ada di response API
                                    // akan diparsing ke activity selanjutnya.

                                    String username = jsonRESULTS.getJSONArray("result").getJSONObject(0).getString("username");
                                    String fullname = jsonRESULTS.getJSONArray("result").getJSONObject(0).getString("fullname");
                                    String bio = jsonRESULTS.getJSONArray("result").getJSONObject(0).getString("bio");
                                    String email = jsonRESULTS.getJSONArray("result").getJSONObject(0).getString("email");
                                    String birthday = jsonRESULTS.getJSONArray("result").getJSONObject(0).getString("birthday");
                                    String phone = jsonRESULTS.getJSONArray("result").getJSONObject(0).getString("phone");
                                    String gender = jsonRESULTS.getJSONArray("result").getJSONObject(0).getString("gender");

                                    etUsername.setText(username);
                                    etFullname.setText(fullname);
                                    etBio.setText(bio);
                                    etEmail.setText(email);
                                    etBirthday.setText(birthday);
                                    etPhoneNumber.setText(phone);
                                    etGender.setText(gender);
//                                    Toast.makeText(mContext, "Berhasil Update", Toast.LENGTH_SHORT).show();
//                                    finish();
                                } else {
                                    String error_message = jsonRESULTS.getString("status");
//                                    DialogForm(error_message);
                                    Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
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

    /////////////////////////////////////////////Ganti Foto\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    private void selectImage() {
        //imageView.setImageResource(0);
        final CharSequence[] items = {"Ambil Foto","Choose from Library",
                "Cancel"};

        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(edit_profile.this);
        builder.setTitle("Masukkan Foto!");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Ambil Foto")) {
                    if (ContextCompat.checkSelfPermission(mContext, android.Manifest.permission.CAMERA)
                            == PackageManager.PERMISSION_DENIED){
                        ActivityCompat.requestPermissions(edit_profile.this, new String[] {Manifest.permission.CAMERA}, REQUEST_CAMERA);
                    }else{
                        intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                        fileUri = getOutputMediaFileUri();
                        intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, fileUri);
                        startActivityForResult(intent, REQUEST_CAMERA);
                    }
                } else if (items[item].equals("Choose from Library")) {
                      intent = new Intent();
                      intent.setType("image/*");
                      intent.setAction(Intent.ACTION_GET_CONTENT);
                      startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_FILE);
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                } else{

                }
            }
        });
        builder.show();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("onActivityResult", "requestCode " + requestCode + ", resultCode " + resultCode);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CAMERA) {
                try {
                    Log.e("CAMERA", fileUri.getPath());

                    bitmap = BitmapFactory.decodeFile(fileUri.getPath());
                    setToImageView(getResizedBitmap(bitmap, max_resolution_image));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (requestCode == SELECT_FILE && data != null && data.getData() != null) {
                try {
                    // mengambil gambar dari Gallery
                    fileUri = data.getData();
                    bitmap = MediaStore.Images.Media.getBitmap(edit_profile.this.getContentResolver(), data.getData());
                    setToImageView(getResizedBitmap(bitmap, max_resolution_image));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyApplication.activityResumed();// On Resume notify the Application
    }

    @Override
    public void onPause() {
        super.onPause();
        MyApplication.activityPaused();// On Pause notify the Application
    }

    // Untuk menampilkan bitmap pada ImageView
    private void setToImageView(Bitmap bmp) {
        //compress image
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, bitmap_size, bytes);
        decoded = BitmapFactory.decodeStream(new ByteArrayInputStream(bytes.toByteArray()));


        //menampilkan gambar yang dipilih dari camera/gallery ke ImageView
        imageView14.setImageBitmap(decoded);
    }

    // Untuk resize bitmap
    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float) width / (float) height;
        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }

    public String getStringImage(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, bitmap_size, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    public Uri getOutputMediaFileUri() {
        return Uri.fromFile(getOutputMediaFile());
    }

    private static File getOutputMediaFile() {

        // External sdcard location
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "DeKa");

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.e("Monitoring", "Oops! Failed create Monitoring directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        File mediaFile;
        mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG_Ubeatz_" + timeStamp + ".jpg");

        return mediaFile;
    }

    private void checkPermission() {
        int hasPermission = ContextCompat.checkSelfPermission(edit_profile.this, Manifest.permission.CAMERA);
        int hasWritePermission = ContextCompat.checkSelfPermission(edit_profile.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (hasPermission != PackageManager.PERMISSION_GRANTED && hasWritePermission != PackageManager.PERMISSION_GRANTED) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(edit_profile.this, Manifest.permission.CAMERA) && !ActivityCompat.shouldShowRequestPermissionRationale(edit_profile.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                showMessage(getString(R.string.allow_access_to_camera_external_storage),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions(edit_profile.this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                        REQUEST_CODE_ASK_PERMISSIONS);
                            }
                        });
                return;
            }
            ActivityCompat.requestPermissions(edit_profile.this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_CODE_ASK_PERMISSIONS);
            return;
        } else {
            isPermissionGranted = true;
        }
    }

    private void showMessage(String message, DialogInterface.OnClickListener       listener) {
        new AlertDialog.Builder(edit_profile.this)
                .setMessage(message)
                .setPositiveButton(R.string.ok, listener)
                .setNegativeButton(R.string.cancel, null)
                .create()
                .show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    isPermissionGranted = true;

                } else {
                    isPermissionGranted = false;
                    Toast.makeText(edit_profile.this, R.string.permission_denied, Toast.LENGTH_SHORT)
                            .show();
                }
                break;

            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    //////////////////////////////////////////////////Update Start\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    private void updateData() {

        HashMap<String, RequestBody> map = new HashMap<>();
        map.put("id", createPartFromString(sessionID.getText().toString()));
        map.put("fullname", createPartFromString(etFullname.getText().toString()));
        map.put("username", createPartFromString(etUsername.getText().toString()));
        map.put("bio", createPartFromString(etBio.getText().toString()));
        map.put("email", createPartFromString(etEmail.getText().toString()));
        map.put("birthday", createPartFromString(etBirthday.getText().toString()));
        map.put("phone", createPartFromString(etPhoneNumber.getText().toString()));
        map.put("gender", createPartFromString(etGender.getText().toString()));

        // Parsing any Media type file
//        RequestBody id = RequestBody.create(MultipartBody.FORM, sessionID.getText().toString());
//        RequestBody fullname = RequestBody.create(MultipartBody.FORM, etFullname.getText().toString());
//        RequestBody username = RequestBody.create(MultipartBody.FORM, etUsername.getText().toString());
//        RequestBody bio = RequestBody.create(MultipartBody.FORM, etBio.getText().toString());
//        RequestBody email = RequestBody.create(MultipartBody.FORM, etEmail.getText().toString());
//        RequestBody birthday = RequestBody.create(MultipartBody.FORM, etBirthday.getText().toString());
//        RequestBody phone = RequestBody.create(MultipartBody.FORM, etPhoneNumber.getText().toString());
//        RequestBody gender = RequestBody.create(MultipartBody.FORM, etGender.getText().toString());

        selectedImagePath  = fileUri.getPath();
        File file = new File(selectedImagePath);

        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);

        MultipartBody.Part photo = MultipartBody.Part.createFormData("photo", file.getName(), requestFile);
//        Finally, execute
//            Call<ServerResponse> call = mApiService.uploadAttendance(fileToUpload,userid,lat,lang,start);
//        Call<ResponseBody> call = mApiService.updateprofileRequest(id,fullname,username,bio,email,birthday,phone,gender,photo);
        Call<ResponseBody> call = mApiService.updateprofileRequest(photo,map);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonRESULTS = new JSONObject(response.body().string());
                        result = jsonRESULTS.getBoolean(SharedPrefManager.SP_RETURN);
                        if (result == true){
                            Toast.makeText(mContext, "Success Edit Profile", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(mContext, "Gagal Edit Profile", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(mContext, "Gagal Edit Profile", Toast.LENGTH_SHORT).show();
                }
//                ServerResponse resource = response.body();
//                if (response.isSuccessful()){
////                    progressBar.setVisibility(View.INVISIBLE);
////                    updateHistory();
//                    Toast.makeText(mContext, "Berhasil update data profile", Toast.LENGTH_SHORT).show();
//                    sharedPrefManager.saveSPInt(SharedPrefManager.SP_CHECK, resource.success);
//                    finish();
//                } else {
////                    progressBar.setVisibility(View.INVISIBLE);
//                    Toast.makeText(mContext, "Gagal update data profile", Toast.LENGTH_SHORT).show();
//                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(mContext, "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @NonNull
    private RequestBody createPartFromString(String descriptionString) {
        return RequestBody.create(
                okhttp3.MultipartBody.FORM, descriptionString);
    }

}
