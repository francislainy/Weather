package com.example.android.weather;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView temperature;
    private TextView humidity;
    private TextView windSpeed;
    private TextView percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFields();

        WeatherTask task = new WeatherTask();
        task.execute();

    }

    private void loadFields() {
        temperature = (TextView) findViewById(R.id.temperature_value_text_view);
        humidity = (TextView) findViewById(R.id.humidity_value_text_view);
        windSpeed = (TextView) findViewById(R.id.wind_speed_value_text_view);
        percent = (TextView) findViewById(R.id.percent_text_view);
    }

    private class WeatherTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            percent.setText("0%");
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            int i = 0;
            while (i <= 100) {
                publishProgress(i++ + "");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


                return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            percent.setText(values[0]);
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            percent.setText("completed");
            super.onPostExecute(s);
        }
    }


}
