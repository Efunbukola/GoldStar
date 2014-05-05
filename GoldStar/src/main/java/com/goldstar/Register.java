package com.goldstar;

import android.app.AlertDialog;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.widget.ViewSwitcher;

public class Register extends ActionBarActivity {
    ViewFlipper flip;
    Button next;
    TextView signin, rptext, regTitle, subText;
    Animation slide_in_left, slide_out_right;
    ProgressBar regbar;
    int viewcounter;
    CheckBox atoa;
    boolean accepted;
    UserAccount user;
    AlertDialog.Builder dialogBuilder;

    public void termsDialog ()
    {
        dialogBuilder = new AlertDialog.Builder(this);
        TextView alert = new TextView(this);
        alert.setText("THE LEGAL AGREEMENTS SET OUT BELOW GOVERN YOUR USE OF THE ITUNES STORE, MAC APP STORE, APP STORE, AND IBOOKS STORE SERVICES (\"SERVICES\"). TO AGREE TO THESE TERMS, CLICK \"AGREE.\" IF YOU DO NOT AGREE TO THESE TERMS, DO NOT CLICK \"AGREE,\" AND DO NOT USE THE SERVICES.\n" +
                "\n" +
                "A. ITUNES STORE, MAC APP STORE, APP STORE, AND IBOOKS STORE TERMS OF SALE\n" +
                "\n" +
                "PAYMENTS, TAXES, AND REFUND POLICY\n" +
                "\n" +
                "You agree that you will pay for all products you purchase through the Services, and that Apple may charge your payment method for any products purchased and for any additional amounts (including any taxes and late fees, as applicable) that may be accrued by or in connection with your Account. YOU ARE RESPONSIBLE FOR THE TIMELY PAYMENT OF ALL FEES AND FOR PROVIDING APPLE WITH A VALID PAYMENT METHOD FOR PAYMENT OF ALL FEES. For details of how purchases are billed please visit support.apple.com/kb/HT5582.");
        dialogBuilder.setTitle("Terms of Agreement");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
//*******************************************************************
        regTitle = (TextView) findViewById(R.id.regTitle);
        regTitle.setText("Whats your name?");
        subText = (TextView) findViewById(R.id.subTitle);
        subText.setText("Use your real name, as this will be displayed to parents and teachers");
        atoa = (CheckBox) findViewById(R.id.atoa);
        accepted = false;

        viewcounter = 1;
        rptext = (TextView) findViewById(R.id.rptext);
        rptext.setText("Step " + viewcounter + "/5");
        flip = (ViewFlipper) findViewById(R.id.viewFlipper);
        next = (Button) findViewById(R.id.next);
        regbar = (ProgressBar) findViewById(R.id.regBar);
        regbar.setProgress(0);

        slide_in_left = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_in_left);
        slide_out_right = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_out_right);

        flip.setInAnimation(slide_in_left);
        flip.setOutAnimation(slide_out_right);








        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Toast.makeText(getApplicationContext(), "Saving...", Toast.LENGTH_SHORT).show();
                regbar.setProgress(regbar.getProgress() + 25);

                if(viewcounter < 5)
                {
                viewcounter += 1;
                }


                if(viewcounter == 2)
                {
                    regTitle.setText("Enter Your Email");
                    subText.setText("Choose the primary you would like to be contacted at");
                }

                if(viewcounter == 5)
                {
                    regTitle.setText("School?");
                    subText.setText("At what institution will our be used?");
                }
                if(viewcounter == 3)
                {
                    regTitle.setText("Create a Password ");
                    subText.setText("Choose a secure yet easy to remember password");
                }


                rptext.setText("Step " + viewcounter + "/5");//update step 1/5

                if(viewcounter == 5)//when we reach the last view change button to finish
                {
                    next.setText("Complete registration");
                }

                if(viewcounter < 6)//go to next one
                {
                    flip.showNext();
                }
                if(viewcounter > 5)
                {
                    Toast.makeText(getApplicationContext(), "Registration complete", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.register, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_register, container, false);
            return rootView;
        }
    }

}
