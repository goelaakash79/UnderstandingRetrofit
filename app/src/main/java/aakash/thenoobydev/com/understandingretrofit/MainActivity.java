package aakash.thenoobydev.com.understandingretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView) findViewById(R.id.list_view);

        //creating a retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Interface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Interface api_interface = retrofit.create(Interface.class);

        Call<List<Hero>> call = api_interface.getHeroes();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                List<Hero> heroes = response.body();

                for(Hero hero: heroes) {
                    Log.e("Name", hero.getHeroname());
                    Log.e("Real Name", hero.getHeroname());
                    Log.e("Team", hero.getTeam());
                }

                String[] heroNames = new String[heroes.size()];

                for(int i = 0; i < heroes.size(); i++){
                    heroNames[i] = heroes.get(i).getHeroname();
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, heroNames);

                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
