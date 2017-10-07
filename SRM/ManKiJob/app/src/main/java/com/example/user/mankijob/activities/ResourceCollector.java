package com.example.user.mankijob.activities;

import java.util.ArrayList;

import com.example.user.mankijob.R;
import com.example.user.mankijob.activities.Product.SubCategory;
import com.example.user.mankijob.activities.Product.SubCategory.ItemList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 *
 * @author manish
 *
 */
public class ResourceCollector extends Activity {

    private ArrayList<Product>pProductArrayList;
    private ArrayList<SubCategory>pSubItemArrayList;
    private ArrayList<SubCategory>pSubItemArrayList2;
    private LinearLayout mLinearListView;
    boolean isFirstViewClick=false;
    boolean isSecondViewClick=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_collector);
        mLinearListView = (LinearLayout) findViewById(R.id.linear_listview);

        /**
         *
         */

        ArrayList<ItemList> mItemListArray=new ArrayList<ItemList>();
        mItemListArray.add(new ItemList("Carpenter"));
        mItemListArray.add(new ItemList("Electrician"));
        mItemListArray.add(new ItemList("heavy equipment operator"));
        mItemListArray.add(new ItemList("Iron worker"));
        mItemListArray.add(new ItemList("labour"));
        mItemListArray.add(new ItemList("Mason"));
        mItemListArray.add(new ItemList("Plasterer"));
        mItemListArray.add(new ItemList("Plumber"));
        mItemListArray.add(new ItemList("PipeFitter"));
        mItemListArray.add(new ItemList("Sheeth metal Worker"));
        mItemListArray.add(new ItemList("Rod Buster"));
        mItemListArray.add(new ItemList("Welder"));
        mItemListArray.add(new ItemList("Contractor"));

        ArrayList<ItemList> mItemListArray2=new ArrayList<ItemList>();
        mItemListArray2.add(new ItemList("Pant"));
        mItemListArray2.add(new ItemList("Shirt"));
        mItemListArray2.add(new ItemList("Pant"));
        mItemListArray2.add(new ItemList("Shirt"));
        mItemListArray2.add(new ItemList("Pant"));
        mItemListArray2.add(new ItemList("Shirt"));

        ArrayList<ItemList> Dairy=new ArrayList<ItemList>();
        Dairy.add(new ItemList("Milking"));
        Dairy.add(new ItemList("Feeding"));
        Dairy.add(new ItemList("Mucking Out"));
        Dairy.add(new ItemList("Caring for Sick"));
        Dairy.add(new ItemList("Newborn liveStock"));
        Dairy.add(new ItemList("Contractor"));


        ArrayList<ItemList> Farming=new ArrayList<ItemList>();
        Farming.add(new ItemList("Ploghing Fields"));
        Farming.add(new ItemList("Sowing Seeds"));
        Farming.add(new ItemList("Spreading Fertilizer"));
        Farming.add(new ItemList("Crop Spraying"));
        Farming.add(new ItemList("Harvesting"));
        Farming.add(new ItemList("Farm Machinery Operator"));
        Farming.add(new ItemList("Contractor"));


        ArrayList<ItemList> Medical=new ArrayList<ItemList>();
        Medical.add(new ItemList("Physician"));
        Medical.add(new ItemList("Nurse"));
        Medical.add(new ItemList("Technician"));
        Medical.add(new ItemList("Therapist"));
        Medical.add(new ItemList("Medical Assistants"));
        Medical.add(new ItemList("Madical Lab Technologist"));


        ArrayList<ItemList> Manufacturing=new ArrayList<ItemList>();
        Manufacturing.add(new ItemList("Quality Tester"));
        Manufacturing.add(new ItemList("Assembler"));
        Manufacturing.add(new ItemList("Fabrication"));
        Manufacturing.add(new ItemList("Super Visor"));
        Manufacturing.add(new ItemList("Vendor"));
        Manufacturing.add(new ItemList("Labour Contractor"));
        Manufacturing.add(new ItemList("Carpenter"));
        Manufacturing.add(new ItemList("Painter"));



        ArrayList<ItemList> Transportation=new ArrayList<ItemList>();
        Transportation.add(new ItemList("Truck Driver"));
        Transportation.add(new ItemList("Conductor/Helper"));
        Transportation.add(new ItemList("Helper"));
        Transportation.add(new ItemList("Route Driver"));
        Transportation.add(new ItemList("Route Supervisor"));
        Transportation.add(new ItemList("Taxi Driver"));
        Transportation.add(new ItemList("Van Driver/Car Driver"));


        ArrayList<ItemList> Education=new ArrayList<ItemList>();
        Education.add(new ItemList("Primary and Secondary teacher"));
        Education.add(new ItemList("Head and Assistant Head Teacher"));
        Education.add(new ItemList("Admin and Account manager"));
        Education.add(new ItemList("Nursery Nurses"));
        Education.add(new ItemList("Peon"));
        Education.add(new ItemList("Technical Staff"));


        ArrayList<ItemList> Office=new ArrayList<ItemList>();
        Office.add(new ItemList("Peon"));
        Office.add(new ItemList("Receptionist"));
        Office.add(new ItemList("Electronic Machine(Operator)"));
        Office.add(new ItemList("Technician"));
        Office.add(new ItemList("Accountant"));


        ArrayList<ItemList> Security=new ArrayList<ItemList>();
        Security.add(new ItemList("Gun Man"));
        Security.add(new ItemList("Guards"));
        Security.add(new ItemList("Supervisor"));
        Security.add(new ItemList("Survillence"));
        Security.add(new ItemList("Security Incharge"));


        ArrayList<ItemList> Vendors=new ArrayList<ItemList>();
        Vendors.add(new ItemList("Salesman"));
        Vendors.add(new ItemList("Retail Sellar"));
        Vendors.add(new ItemList("Cart-puller"));



        ArrayList<ItemList> Entertainment=new ArrayList<ItemList>();
        Entertainment.add(new ItemList("Music"));
        Entertainment.add(new ItemList("Acting"));
        Entertainment.add(new ItemList("Singing"));


        ArrayList<ItemList> Sports=new ArrayList<ItemList>();
        Sports.add(new ItemList("Atheletics"));
        Sports.add(new ItemList("Nationals"));
        Sports.add(new ItemList("Regions"));
        Sports.add(new ItemList("Cluster"));
        Sports.add(new ItemList("PGT"));

        ArrayList<ItemList> Servants=new ArrayList<ItemList>();
        Servants.add(new ItemList("Maid"));
        Servants.add(new ItemList("Home Cook"));
        Servants.add(new ItemList("House Keeper"));
        Servants.add(new ItemList("Baby Sitter"));
        Servants.add(new ItemList("Shop Boy"));




        /**
         *
         */
        pSubItemArrayList=new ArrayList<SubCategory>();
        pSubItemArrayList2=new ArrayList<SubCategory>();
        pSubItemArrayList.add(new SubCategory("Building/Construction", mItemListArray));
        pSubItemArrayList2.add(new SubCategory("Cloths", mItemListArray2));
        pSubItemArrayList.add(new SubCategory("Dairy", Dairy));
        pSubItemArrayList.add(new SubCategory("Farming", Farming));
        pSubItemArrayList.add(new SubCategory("Medical", Medical));
        pSubItemArrayList.add(new SubCategory("Manufacturing", Manufacturing));
        pSubItemArrayList.add(new SubCategory("Transportation", Transportation));
        pSubItemArrayList.add(new SubCategory("Education",Education));
        pSubItemArrayList.add(new SubCategory("Office",Office ));
        pSubItemArrayList.add(new SubCategory("Security", Security));
        pSubItemArrayList.add(new SubCategory("Vendors", Vendors));
        pSubItemArrayList.add(new SubCategory("Entertainment", Entertainment));
        pSubItemArrayList.add(new SubCategory("Sports",Sports));
        pSubItemArrayList.add(new SubCategory("Servants",Servants));
        pSubItemArrayList2.add(new SubCategory("Cloths", mItemListArray2));
        /**
         *
         */

        pProductArrayList=new ArrayList<Product>();
        pProductArrayList.add(new Product("What do you do for your living", pSubItemArrayList));
        pProductArrayList.add(new Product("Your Intrest in job", pSubItemArrayList2));


        /***
         * adding item into listview
         */
        for (int i = 0; i < pProductArrayList.size(); i++) {

            LayoutInflater inflater = null;
            inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View mLinearView = inflater.inflate(R.layout.row_first, null);

            final TextView mProductName = (TextView) mLinearView.findViewById(R.id.textViewName);
            final RelativeLayout mLinearFirstArrow=(RelativeLayout)mLinearView.findViewById(R.id.linearFirst);
            final ImageView mImageArrowFirst=(ImageView)mLinearView.findViewById(R.id.imageFirstArrow);
            final LinearLayout mLinearScrollSecond=(LinearLayout)mLinearView.findViewById(R.id.linear_scroll);

            if(isFirstViewClick==false){
                mLinearScrollSecond.setVisibility(View.GONE);
                mImageArrowFirst.setBackgroundResource(R.drawable.arw_lt);
            }
            else{
                mLinearScrollSecond.setVisibility(View.VISIBLE);
                mImageArrowFirst.setBackgroundResource(R.drawable.arw_down);
            }

            mLinearFirstArrow.setOnTouchListener(new OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    if(isFirstViewClick==false){
                        isFirstViewClick=true;
                        mImageArrowFirst.setBackgroundResource(R.drawable.arw_down);
                        mLinearScrollSecond.setVisibility(View.VISIBLE);

                    }else{
                        isFirstViewClick=false;
                        mImageArrowFirst.setBackgroundResource(R.drawable.arw_lt);
                        mLinearScrollSecond.setVisibility(View.GONE);
                    }
                    return false;
                }
            });


            final String name = pProductArrayList.get(i).getpName();
            mProductName.setText(name);

            /**
             *
             */
            for (int j = 0; j < pProductArrayList.get(i).getmSubCategoryList().size(); j++) {

                LayoutInflater inflater2 = null;
                inflater2 = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View mLinearView2 = inflater2.inflate(R.layout.row_second, null);

                TextView mSubItemName = (TextView) mLinearView2.findViewById(R.id.textViewTitle);
                final RelativeLayout mLinearSecondArrow=(RelativeLayout)mLinearView2.findViewById(R.id.linearSecond);
                final ImageView mImageArrowSecond=(ImageView)mLinearView2.findViewById(R.id.imageSecondArrow);
                final LinearLayout mLinearScrollThird=(LinearLayout)mLinearView2.findViewById(R.id.linear_scroll_third);

                if(isSecondViewClick==false){
                    mLinearScrollThird.setVisibility(View.GONE);
                    mImageArrowSecond.setBackgroundResource(R.drawable.arw_lt);
                }
                else{
                    mLinearScrollThird.setVisibility(View.VISIBLE);
                    mImageArrowSecond.setBackgroundResource(R.drawable.arw_down);
                }

                mLinearSecondArrow.setOnTouchListener(new OnTouchListener() {

                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        if(isSecondViewClick==false){
                            isSecondViewClick=true;
                            mImageArrowSecond.setBackgroundResource(R.drawable.arw_down);
                            mLinearScrollThird.setVisibility(View.VISIBLE);

                        }else{
                            isSecondViewClick=false;
                            mImageArrowSecond.setBackgroundResource(R.drawable.arw_lt);
                            mLinearScrollThird.setVisibility(View.GONE);
                        }
                        return false;
                    }
                });


                final String catName = pProductArrayList.get(i).getmSubCategoryList().get(j).getpSubCatName();
                mSubItemName.setText(catName);
                /**
                 *
                 */
                for (int k = 0; k < pProductArrayList.get(i).getmSubCategoryList().get(j).getmItemListArray().size(); k++) {

                    LayoutInflater inflater3 = null;
                    inflater3 = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View mLinearView3 = inflater3.inflate(R.layout.row_third, null);

                    TextView mItemName = (TextView) mLinearView3.findViewById(R.id.textViewItemName);

                    final String itemName = pProductArrayList.get(i).getmSubCategoryList().get(j).getmItemListArray().get(k).getItemName();

                    mItemName.setText(itemName);

                    mLinearScrollThird.addView(mLinearView3);

                    /**
                     * set click
                     */

                    mLinearView3.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub

                            Toast.makeText(ResourceCollector.this, "clicked item:"+itemName, Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                mLinearScrollSecond.addView(mLinearView2);

            }

            mLinearListView.addView(mLinearView);
        }
    }

}
