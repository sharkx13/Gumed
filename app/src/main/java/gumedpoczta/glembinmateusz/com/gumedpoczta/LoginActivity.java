package gumedpoczta.glembinmateusz.com.gumedpoczta;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class LoginActivity extends Activity {
    private static final String TAG = "LoginActivity";
    private SharedPreferences preferences;
    public static final String PREFERENCES = "com.glembinmateusz.pocztagumed";
    public String log_login, log_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }

    /** wywolywane gdy okno dostalo fokus
     *  sprawdzamy czy sa dostepne dane logowania
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        /* sprawdzamy czy uzytkownik jest juz zapisany */
        SharedPreferences settings = getSharedPreferences(PREFERENCES, 0);
        String login = settings.getString("login", null);
        String password = settings.getString("password", null);
        Log.d(TAG, "pobrane wartosci - login: " + login + ", haslo: " + password);
        if (login != null && password != null) {
            log_login = login;
            log_password = password;
            DoLoginTask();
        }
        // w innym przypadku czekamy az uzytkownik wcisnie przycisk loguj
    }

    public void ButtonLoginOnClick(View view) {
        Log.d(TAG, "ButtonLogginOnClick");
        String login, password;
        EditText tv_login = (EditText) findViewById(R.id.tv_login_login_activity);
        login = tv_login.getText().toString();
        EditText tv_password = (EditText) findViewById(R.id.tv_password_login_activity);
        password = tv_password.getText().toString();
        Log.d(TAG, "login: " + login + ", haslo: " + password);
        if(login == null || password == null) {
            Toast.makeText(this, "Niewlasciwe dane logowania", Toast.LENGTH_SHORT).show();
        } else {
            log_login = login;
            log_password = password;
            DoLoginTask();
        }

    }

    private void DoLoginTask() {
        findViewById(R.id.pb_login).setVisibility(View.VISIBLE);
        Log.d(TAG, "DoLoginTask");
        LoginTask loginTask = new LoginTask();
        Log.d(TAG, "login: " + log_login + ", haslo: " + log_password);
        loginTask.execute();
    }

    public void ButtonFakeLogin(View view) {
        Intent intent = new Intent(this, MainViewActivity.class);
        startActivity(intent);
    }

    public class LoginTask extends AsyncTask<String, Integer, String> {
        // log_login, log_password;
        int port_pop3 = 995;
        int port_smtp = 465;
        String ip_address = "153.19.64.38";

        @Override
        protected String doInBackground(String... params) {
            Log.d(TAG, "doInBackground");

            Socket socket;

            try {
                socket = new Socket(ip_address, port_pop3);
            } catch (UnknownHostException e) {

            } catch (IOException e) {

            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            Log.d(TAG, "onPostExecute");
            super.onPostExecute(s);
            findViewById(R.id.pb_login).setVisibility(View.INVISIBLE);
        }
    }


}
