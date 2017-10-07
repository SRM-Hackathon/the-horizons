package com.example.nihal.profile_complete;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

//public class ProfileComplete extends Activity implements AdapterView.OnItemSelectedListener,View.OnClickListener {
public class ProfileComplete extends AppCompatActivity implements View.OnClickListener {

    /*DatabaseHelper myDb;
    EditText editName, editEmail, editPincode, editHouse;
    Spinner editDate, editMonth, editYear, editState, editCity;
    Button btnInsert;
    ArrayList<String> spinnerinsert = new ArrayList<String>();*/

    private static final int SELECT_PICTURE = 100;
    private static final String TAG = "ProfileComplete";

    RelativeLayout relativeLayout;
    // Button btnSelectImage;
    ImageButton imgView;
    //ImageButton imgView;


    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_complete);

        //   Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //  setSupportActionBar(toolbar);

        // Find the views...
        relativeLayout = (RelativeLayout) findViewById(R.id.relativelayout2);
        System.out.println(relativeLayout);
        // btnSelectImage = (Button) findViewById(R.id.button);
        // System.out.println(btnSelectImage);
        imgView = (ImageButton) findViewById(R.id.user_profile_photo);
        System.out.println(imgView);
        imgView.setOnClickListener(this);
        //imgBtn.setOnClickListener((View.OnClickListener) this);

        // Create the Database helper object
        dbHelper = new DBHelper(this);
        /*myDb = new DatabaseHelper(this);
        editName = (EditText) findViewById(R.id.editText3);
        editEmail = (EditText) findViewById(R.id.editText2);
        editDate = (Spinner) findViewById(R.id.spinner7);
        editMonth = (Spinner) findViewById(R.id.spinner11);
        editYear = (Spinner) findViewById(R.id.spinner12);
        editState = (Spinner) findViewById(R.id.spinner14);
        editCity = (Spinner) findViewById(R.id.spinner15);
        editPincode = (EditText) findViewById(R.id.editText5);
        editHouse = (EditText) findViewById(R.id.editText6);

      /*  btnInsert = (Button) findViewById(R.id.buttonsave);
        System.out.println(btnInsert);
        editDate.setOnItemSelectedListener(this);
        editMonth.setOnItemSelectedListener(this);
        editYear.setOnItemSelectedListener(this);
        editState.setOnItemSelectedListener(this);
        editCity.setOnItemSelectedListener(this);*/
        // Loading spinner data from database

      //  AddData();
    }

    // Show simple message using SnackBar
    void showMessage(String message) {
        Snackbar snackbar = Snackbar.make(relativeLayout, message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    // Choose an image from Gallery
    void openImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {

                Uri selectedImageUri = data.getData();

                if (null != selectedImageUri) {

                    // Saving to Database...
                    if (saveImageInDB(selectedImageUri)) {
                        showMessage("Image Saved in Database...");
                        imgView.setImageURI(selectedImageUri);
                    }

                    // Reading from Database after 3 seconds just to show the message
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (loadImageFromDB()) {
                                showMessage("Image Loaded from Database...");
                            }
                        }
                    }, 3000);
                }

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile_complete, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        openImageChooser();
    }

    // Save the
    Boolean saveImageInDB(Uri selectedImageUri) {

        try {
            dbHelper.open();
            InputStream iStream = getContentResolver().openInputStream(selectedImageUri);
            byte[] inputData = Utils.getBytes(iStream);
            dbHelper.insertImage(inputData);
            dbHelper.close();
            return true;
        } catch (IOException ioe) {
            Log.e(TAG, "<saveImageInDB> Error : " + ioe.getLocalizedMessage());
            dbHelper.close();
            return false;
        }

    }

    Boolean loadImageFromDB() {
        try {
            dbHelper.open();
            byte[] bytes = dbHelper.retreiveImageFromDB();
            dbHelper.close();
            // Show Image from DB in ImageView
            imgView.setImageBitmap(Utils.getImage(bytes));
            return true;
        } catch (Exception e) {
            Log.e(TAG, "<loadImageFromDB> Error : " + e.getLocalizedMessage());
            dbHelper.close();
            return false;
        }
    }
}
/*
    public void AddData() {
        btnInsert.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myDb.insertData(editName.getText().toString(), editEmail.getText().toString(),editPincode.getText().toString(),editHouse.getText().toString());
                        myDb.insertData1(spinnerinsert.get(1), spinnerinsert.get(2), spinnerinsert.get(3), spinnerinsert.get(4), spinnerinsert.get(5));
                        System.out.println(spinnerinsert);
                    }

                }
        );
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item

        String label = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "You selected: " + label,
                Toast.LENGTH_LONG).show();
        //System.out.println(label);
        // spinnerinsert.add(label);
        //System.out.println(spinnerinsert);

        //spinnerinsert.add(label);
        if(editDate.isPressed())
        {
            spinnerinsert.add(label);
            System.out.println(label);

        }

        if(editMonth.isSelected())
        {
            spinnerinsert.add(2,label);
            System.out.println(label);

        }
        if(editYear.isSelected())
        {
            spinnerinsert.add(3,label);
            System.out.println(label);

        }

        if(editState.isSelected())
        {
            System.out.println(label);
            spinnerinsert.add(4,label);

        }
        if(editCity.isSelected())
        {
            spinnerinsert.add(5,label);

        }
        System.out.println(spinnerinsert);

    }

        @Override
        public void onNothingSelected (AdapterView < ? > parent){

        }
    }*/


