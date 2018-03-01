package tw.hankli.mvpdemo.login;

import android.util.Log;

import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import tw.hankli.mvpdemo.model.LoginRepository;

/**
 * Created by hank on 12/02/2018.
 * 邏輯組裝區
 */

public class LoginPresenter implements LoginContract.Presenter {

    private static final String TAG = "LoginPresenter";

    private LoginContract.View view;
    private LoginRepository loginRepository;

    public LoginPresenter(LoginContract.View view) {

        this.view = view;

        // TODO 可使用 DI Library 注入
        loginRepository = new LoginRepository();
    }

    @Override
    public void login(String username, String password) {

        view.showDialog();

        loginRepository.loginByApi(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> {
                    view.hideDialog();
                })
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        // 通知View登入成功
                        view.loginSuccess();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "Error: " + e);

                        // 通知View登入失敗
                        view.loginFail();
                    }
                });
    }
}
