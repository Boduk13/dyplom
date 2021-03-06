package com.android.Duplom;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;
//import com.android.Duplom.mail.MailSenderActivity;

/**
 * Created by bodik on 26.03.14.
 */
public class ShowActivity  extends Activity {
    String status_mes;
    String description;
    String net_action;
    String on_site_action;

    TextView rezultat;
    TextView rezultat2;
    TextView rezultat3;
    TextView rezultat4;
    TextView rezultat5;
    TextView rezultat6;
    TextView rezultat7;
    TextView rezultat8;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        status_mes = getIntent().getStringExtra(String.valueOf(R.string.status_mes));
        description = getIntent().getStringExtra(String.valueOf(R.string.description));
        net_action = getIntent().getStringExtra(String.valueOf(R.string.net_action));
        on_site_action = getIntent().getStringExtra(String.valueOf(R.string.on_site_action));


        super.onCreate(savedInstanceState);



        setContentView(R.layout.show_description);


        Button btn = (Button)findViewById(R.id.button_back);


        rezultat = (TextView) findViewById(R.id.textView);
        rezultat2 = (TextView) findViewById(R.id.textView2);
        rezultat3 = (TextView) findViewById(R.id.textView3);
        rezultat4 = (TextView) findViewById(R.id.textView4);
        rezultat5 = (TextView) findViewById(R.id.textView5);
        rezultat6 = (TextView) findViewById(R.id.textView6);
        rezultat7 = (TextView) findViewById(R.id.textView7);
        rezultat8 = (TextView) findViewById(R.id.textView8);


        ///set color
        rezultat.setTextColor(Color.WHITE);
        rezultat3.setTextColor(Color.WHITE);
        rezultat5.setTextColor(Color.WHITE);
        rezultat7.setTextColor(Color.WHITE);

        rezultat2.setTextColor(Color.RED);
        rezultat4.setTextColor(Color.GREEN);
        rezultat6.setTextColor(Color.GREEN);
        rezultat8.setTextColor(Color.GREEN);

///////// Enable Test mode
/*
        status_mes="CI01230000";
        description="Consumer Timeout";
        net_action="Send a function command to exit the consumer " +
                "request state and continue or send another function command to operate the currency acceptor again";
        on_site_action="None";
        */
        //





        rezultat.setText("Status Message:");
        rezultat2.setText(status_mes + "\n");
        rezultat3.setText("Description:");
        rezultat4.setText(description + "\n");
        rezultat5.setText("Network Action:");
        rezultat6.setText(net_action + "\n");
        rezultat7.setText("On-site Action:");
        rezultat8.setText(on_site_action + "\n");





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button_back:


                        onBackPressed();
                        /*Intent intent = new Intent(ShowActivity.this, CopyDbActivity.class);
                        startActivity(intent);*/
                        break;
                    default:
                        break;
                }



            }
        });

    }
    //add menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub

        menu.add (Menu.FIRST, 1, 1, R.string.about).setIcon(R.drawable.ic_menu_start_conversation);
        menu.add (Menu.FIRST, 2, 2, R.string.exit).setIcon(R.drawable.ic_menu_logout);



        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub


        switch (item.getItemId()) {

            case 1:
                Toast.makeText(getApplicationContext(),
                        "You selected About", Toast.LENGTH_LONG).show();
                return true;
            case 2:

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ShowActivity.this);
                alertDialog.setTitle("Exit?");

                alertDialog.setMessage("Are you sure, exit?");

                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {

                        finish();



                    }
                });

                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                alertDialog.show();
                return true;


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        finish();
        super.onBackPressed();
    }
}
