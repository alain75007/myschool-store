package com.myschool.store;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // http://developer.android.com/training/basics/data-storage/shared-preferences.html
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        //int defaultValue = getResources().getInteger(R.string.saved_high_score_default);
        String  emailString = sharedPref.getString("user_email", "");
        Toast.makeText(this, emailString, Toast.LENGTH_SHORT).show();
        Log.d("LoginActivity", "Email=" + emailString);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

    public void onSubmitClick(View view) {
        View emailView = findViewById(R.id.act_main_input_email);
        View passwordView = findViewById(R.id.act_login_input_password);
        String emailString = ((EditText) emailView).getText().toString();
        String passwordString = ((EditText) passwordView).getText().toString();
        if (emailString.equals("")) {
            Toast.makeText(this, "Renseignez l'email S.V.P.", Toast.LENGTH_SHORT).show();
        }
        else if (passwordString.equals("")) {
            Toast.makeText(this, "Renseignez le mot-de-passe S.V.P.", Toast.LENGTH_SHORT).show();
        }
        else {
            // See http://developer.android.com/training/basics/data-storage/shared-preferences.html
            SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("user_email", emailString);
            editor.putString("user_password", passwordString);
            editor.commit();
        }


    }
}
