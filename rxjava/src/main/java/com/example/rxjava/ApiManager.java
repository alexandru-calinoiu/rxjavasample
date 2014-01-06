package com.example.rxjava;

import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.concurrency.Schedulers;
import rx.subscriptions.Subscriptions;

public class ApiManager {
  public interface ApiManagerService {
    @GET("/weather")
    WeatherData getWeather(@Query("q") String place, @Query("units") String units);
  }

  private static final RestAdapter restAdapter = new RestAdapter.Builder().setServer("http://api.openweathermap.org/data/2.5").build();

  private static final ApiManagerService apiManagerService = restAdapter.create(ApiManagerService.class);

  public static Observable<WeatherData> getWeatherData(final String city) {
    return Observable.create(new Observable.OnSubscribeFunc<WeatherData>() {
      @Override
      public Subscription onSubscribe(Observer<? super WeatherData> observer) {
        observer.onNext(apiManagerService.getWeather(city, "metric"));
        observer.onCompleted();

        return Subscriptions.empty();
      }
    }).subscribeOn(Schedulers.threadPoolForIO());
  }
}
