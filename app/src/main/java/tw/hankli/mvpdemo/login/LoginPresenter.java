package tw.hankli.mvpdemo.login;

import tw.hankli.mvpdemo.model.LoginRepository;

/**
 * Created by hank on 12/02/2018.
 * 邏輯組裝區
 */

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private LoginRepository loginRepository;

    public LoginPresenter(LoginContract.View view) {

        this.view = view;

        // TODO 可使用 DI Library 注入
        loginRepository = new LoginRepository();
    }

    @Override
    public void start() {

    }

    @Override
    public void login(String username, String password) {

        // 利用Api判斷是否登入成功
        if (loginRepository.loginByApi(username, password)) {

            // 通知View登入成功
            view.loginSuccess();
        } else {

            // 通知View登入失敗
            view.loginFail();
        }
    }
}
