package tw.hankli.mvpdemo.model;


import io.reactivex.Completable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by hank on 12/02/2018.
 * 複合服務區
 */

public class LoginRepository {

    private LoginApi loginApi;

    public LoginRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://35.229.148.150:8080")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        loginApi = retrofit.create(LoginApi.class);
    }

    public Completable loginByApi(String username, String password) {
        return loginApi.validate(username, password);
    }
}
