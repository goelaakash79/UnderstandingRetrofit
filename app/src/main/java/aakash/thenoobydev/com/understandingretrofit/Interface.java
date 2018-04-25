package aakash.thenoobydev.com.understandingretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by thenoobydev on 25/4/18.
 */

public interface Interface {

//    api = root_url + api_name

    String BASE_URL ="https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Hero>> getHeroes();

}
