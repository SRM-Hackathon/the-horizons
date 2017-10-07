package com.example.user.mankijob.activities;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.example.user.mankijob.R;

public class SecondQuestion extends Activity {
    //DatabaseHelper myDb;
    Button btnInsert;
    Button btnShow;
    ArrayList<String> selectedContry = new ArrayList<String>();
    private Button next;
    private Button previous;
    private void init(){
        next = (Button) findViewById(R.id.next);
        previous=(Button) findViewById(R.id.previous1);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(SecondQuestion.this, Earnings.class);
                startActivity(next);
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent seeker = new Intent(SecondQuestion.this, Qualification.class);
                startActivity(seeker);
            }
        });
    }


    MyCustomAdapter dataAdapter = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);

        //Generate list View from ArrayList
        displayListView();

        checkButtonClick();
        init();
        //myDb = new DatabaseHelper(this);
        //btnInsert = (Button) findViewById(R.id.button);
       // btnShow = (Button) findViewById(R.id.button2);
       // AddData();
       // viewAll();

    }

    private void displayListView() {

        //Array list of countries
        ArrayList<JobFields> jobList = new ArrayList<JobFields>();
       JobFields jobFields = new JobFields("Carpenter",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Electrician",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Heavy equuipment operator",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Iron worker",false);
        jobList.add(jobFields);
        jobFields = new JobFields("labour",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Mason",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Plasterer",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Plumber",false);
        jobList.add(jobFields);
        jobFields = new JobFields("PipeFitter",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Sheeth metal Worker",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Rod Buster",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Welder",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Contractor",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Milking",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Heavy equuipment operator",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Iron worker",false);
        jobList.add(jobFields);
        jobFields = new JobFields("labour",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Mason",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Plasterer",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Plumber",false);
        jobList.add(jobFields);
        jobFields = new JobFields("PipeFitter",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Sheeth metal Worker",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Rod Buster",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Welder",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Contractor",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Physician",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Nurse",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Technician",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Therapist",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Medical Assistant",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Medical Lab Technologist",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Quality Tester",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Assembler",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Fabrication",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Super Visor",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Vendor",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Labour Contractor",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Carpenter",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Painter",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Truck Driver",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Conductor/Helper",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Route Driver",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Route Supervisor",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Taxi Driver",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Van Driver/Car Driver",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Primary and Secondary Teacher",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Head and Assistant Head Teacher",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Admin and account Manager",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Nursery Nurses",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Peon",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Technical Staff",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Receptionist",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Electronic Machine Operator",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Technician",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Accountant",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Gun Man",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Guards",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Supervisor",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Surveillance",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Security In-charge",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Salesman",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Retail Seller",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Cart-puller",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Music",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Acting",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Singing",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Athletics",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Nationals",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Regions",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Clusters",false);
        jobList.add(jobFields);
        jobFields = new JobFields("PGT",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Maid",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Maid",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Home Cook",false);
        jobList.add(jobFields);
        jobFields = new JobFields("House Keeper",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Baby Sitter",false);
        jobList.add(jobFields);
        jobFields = new JobFields("Shop Boy",false);
        jobList.add(jobFields);

        //create an ArrayAdaptar from the String Array
        dataAdapter = new MyCustomAdapter(this,
                R.layout.country_info, jobList);
        ListView listView = (ListView) findViewById(R.id.listView1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);


        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                JobFields jobfield = (JobFields) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                        "Clicked on Row: " + jobfield.getName(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    private class MyCustomAdapter extends ArrayAdapter<JobFields> {

        private ArrayList<JobFields> jobList;

        public MyCustomAdapter(Context context, int textViewResourceId,
                               ArrayList<JobFields> jobList) {
            super(context,textViewResourceId, jobList);
            this.jobList = new ArrayList<JobFields>();
            this.jobList.addAll(jobList);
        }

        private class ViewHolder {
            //TextView code;
            CheckBox name;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.country_info, null);

                holder = new ViewHolder();
                //holder.code = (TextView) convertView.findViewById(R.id.code);
                holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
                convertView.setTag(holder);

                holder.name.setOnClickListener( new View.OnClickListener() {
                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v ;
                        JobFields jobfield = (JobFields) cb.getTag();
                        Toast.makeText(getApplicationContext(),
                                "Clicked on Checkbox: " + cb.getText() +
                                        " is " + cb.isChecked(),
                                Toast.LENGTH_LONG).show();
                        jobfield.setSelected(cb.isChecked());
                    }
                });
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }

            JobFields jobfield = jobList.get(position);
            //holder.code.setText(" (" +  country.getCode() + ")");
            holder.name.setText(jobfield.getName());
            holder.name.setChecked(jobfield.isSelected());
            holder.name.setTag(jobfield);

            return convertView;

        }

    }

    private void checkButtonClick() {


        Button myButton = (Button) findViewById(R.id.findSelected);
        myButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {


                StringBuffer responseText = new StringBuffer();
                responseText.append("The following were selected...\n");

                ArrayList<String> selectedCL = new ArrayList<String>();
                ArrayList<JobFields> jobList = dataAdapter.jobList;
                for(int i=0;i<jobList.size();i++){
                    JobFields jobfield = jobList.get(i);
                    if(jobfield.isSelected()){
                        selectedCL.add(jobfield.getName());
                        responseText.append("\n" + jobfield.getName());
                    }
                }
                selectedContry=selectedCL;

                Iterator itr =selectedContry.listIterator();
                while(itr.hasNext()){
                    System.out.println(itr.next());
                }
                Toast.makeText(getApplicationContext(),
                        responseText, Toast.LENGTH_LONG).show();

            }
        });

    }

   // public void AddData() {
        //btnInsert.setOnClickListener(
                //new View.OnClickListener() {
                   // @Override
                   // public void onClick(View view) {

                        /*
                        for (int i = 0; i <= selectedCL.size(); i++) {
                            boolean isInserted = myDb.insertData(selectedCL.get(i).toString());
                           */

                        /*Iterator itr =selectedContry.listIterator();
                        while(itr.hasNext()){
                            System.out.println(itr.next());
                             myDb.insertData(itr.next().toString());
                            System.out.println(itr.next());
                        }*/

                        /*for(int i=0;i<selectedContry.size();i++)
                        {
                            System.out.println(selectedContry.get(i));
                            myDb.insertData(selectedContry.get(i));
                        }*/

                        //boolean isInserted = myDb.insertData(editName.getText().toString());
                           /* if (isInserted1 == true)
                                Toast.makeText(Main.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(Main.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
                            */
                    //}

//}
        //);
   // }


    /*public void viewAll()
    {
        btnShow.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();

                        if(res.getCount()==0)
                        {
                            showMessage("Error","Nothing Found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext())
                        {
                            buffer.append("Country:"+res.getString(0)+"\n");
                        }

                        showMessage("Data",buffer.toString());

                    }
                }
        );
    }*/

    public void showMessage(String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }

}
