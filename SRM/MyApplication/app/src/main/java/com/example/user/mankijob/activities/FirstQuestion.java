package com.example.user.mankijob.activities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.user.mankijob.R;

public class FirstQuestion extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private Button previous;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });

        init();
    }

    private void init(){
        next = (Button) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent seeker = new Intent(FirstQuestion.this, Qualification.class);
                startActivity(seeker);
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Building/Construction");
        listDataHeader.add("Dairy");
        listDataHeader.add("farming");
        // listDataHeader.add("Dairy");
        listDataHeader.add("Medical");
        listDataHeader.add("Manufacturing");
        listDataHeader.add("Transportation");
        listDataHeader.add("Education");
        listDataHeader.add("Office");
        listDataHeader.add("Security");
        listDataHeader.add("Vendors");
        listDataHeader.add("Entertainment");
        listDataHeader.add("Sports");
        listDataHeader.add("Servants");


        // Adding child data
        List<String> Building_Construction = new ArrayList<String>();
        Building_Construction.add("Carpenter");
        Building_Construction.add("Electrician");
        Building_Construction.add("Heavy Equipment Operator ");
        Building_Construction.add("Iron Worker");
        Building_Construction.add("Labour");
        Building_Construction.add("Mason");
        Building_Construction.add("Plasterer");
        Building_Construction.add("Plumber");
        Building_Construction.add("PipeFitter");
        Building_Construction.add("Sheeth metal Worker");
        Building_Construction.add("Rod Buster");
        Building_Construction.add("Welder");
        Building_Construction.add("Contractor");
        List<String> Dairy = new ArrayList<String>();
        Dairy.add("Milking");
        Dairy.add("Feeding");
        Dairy.add("Mucking Out");
        Dairy.add("Caring for Sick");
        Dairy.add("Newborn livestock");
        Dairy.add("Contractor");

        List<String>Medical = new ArrayList<String>();
        Medical.add("Physician");
        Medical.add("Nurse");
        Medical.add("Technician");
        Medical.add("Therapist");
        Medical.add("Medical Assistants");
        Medical.add("Medical Lab Technologist");
        List<String>Manufacturing = new ArrayList<String>();
        Manufacturing.add("Quality Tester");
        Manufacturing.add("Assembler");
        Manufacturing.add("Fabrication");
        Manufacturing.add("Super Visor");
        Manufacturing.add("Vendor");
        Manufacturing.add("Labour Contractor");
        Manufacturing.add("Carpenter");
        Manufacturing.add("Painter");
        List<String>Transportation = new ArrayList<String>();
        Transportation.add("Truck Driver");
        Transportation.add("Conductor/Helper");
        Transportation.add("Helper");
        Transportation.add("Route Driver");
        Transportation.add("Route Supervisor");
        Transportation.add("Taxi Driver");
        Transportation.add("Van Driver/Car Driver");
        List<String>Education = new ArrayList<String>();
        Education.add("Primary and Secondary teacher");
        Education.add("Head and Assistant Head Teacher");
        Education.add("Admin and Account manager");
        Education.add("Nursery Nurses");
        Education.add("Peon");
        Education.add("Technical Staff");

        List<String>Office = new ArrayList<String>();
        Office.add("Peon");
        Office.add("Receptionist");
        Office.add("Electronic Machine(Operator)");
        Office.add("Technician");
        Office.add("Accountant");
        List<String>Security = new ArrayList<String>();
        Security.add("Gun Man");
        Security.add("Guards");
        Security.add("Supervisor");
        Security.add("Survillence");
        Security.add("Security Incharge");

        List<String>Entertainment = new ArrayList<String>();
        Entertainment.add("Music");
        Entertainment.add("Acting");
        Entertainment.add("Singing");


        List<String>Servants = new ArrayList<String>();
        Servants.add("Maid");
        Servants.add("Home Cook");
        Servants.add("House Keeper");
        Servants.add("Baby Sitter");
        Servants.add("Shop Boy");

        List<String>Sports = new ArrayList<String>();
        Sports.add("Atheletics");
        Sports.add("Nationals");
        Sports.add("Regions");
        Sports.add("Cluster");
        Sports.add("PGT");
        List<String>Vendors = new ArrayList<String>();
        Vendors.add("Salesman");
        Vendors.add("Retail Sellar");
        Vendors.add("Cart-puller");
        List<String>Farming = new ArrayList<String>();
        Farming.add("Ploghing Fields");
        Farming.add("Sowing Seeds");
        Farming.add("Spreading Fertilizer");
        Farming.add("Crop Spraying");
        Farming.add("Harvesting");
        Farming.add("Farm Machinery Operator");

        listDataChild.put(listDataHeader.get(0),Building_Construction ); // Header, Child data
        listDataChild.put(listDataHeader.get(1), Dairy);
        listDataChild.put(listDataHeader.get(2), Farming);
        listDataChild.put(listDataHeader.get(3), Medical);
        listDataChild.put(listDataHeader.get(4), Manufacturing);
        listDataChild.put(listDataHeader.get(5), Transportation);
        listDataChild.put(listDataHeader.get(6), Education);
        listDataChild.put(listDataHeader.get(7), Office);
        listDataChild.put(listDataHeader.get(8), Security);
        listDataChild.put(listDataHeader.get(9), Vendors);
        listDataChild.put(listDataHeader.get(10), Entertainment);
        listDataChild.put(listDataHeader.get(11), Sports);
        listDataChild.put(listDataHeader.get(12), Servants);



    }
}
