package gumedpoczta.glembinmateusz.com.gumedpoczta;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainViewActivity extends Activity {
    private static final String TAG = "MainViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "OnCreate");

        setContentView(R.layout.main_view_activity);
    }

    public void MenuSettingsOnClick(View view) {
        // szukanie zaawansowane
        // pokaz zarchiwizowane wiadomosci
        // opcje -> ilosc zapamietanych email'i, domyslnie wyswietlaj grafik
        //      -> wyloguj sie, czestosc odswiezania [1min, 5min, 15min]
        //      -> usun cache (usuwa zapisane haslo i emaile z pamieci telefonu)
        //      -> (motyw), pokaz logo | wybierz obraz tla
    }

    public void MenuNewMailOnClick(View view) {
        // otwiera okno nowego maila z pusty docelowym adresem email
        Intent intent = new Intent(this, NewMailActivity.class);
        startActivity(intent);
    }

    public void MenuSearchOnClick(View view) {
        // usuwa tv_gumed_poczta i tv_mail_address
        // w ich miejsce wstawia pasek wyszukiwania
    }

    public void TitleOnClick(View view) {
        // rysuje menu z wyborem folderu i kontaktami
    }
}
