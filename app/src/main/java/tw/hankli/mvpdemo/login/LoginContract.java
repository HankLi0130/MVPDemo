package tw.hankli.mvpdemo.login;

import tw.hankli.mvpdemo.BasePresenter;
import tw.hankli.mvpdemo.BaseView;

/**
 * Created by hank on 12/02/2018.
 * View 與 Presenter的溝通管道
 */

public interface LoginContract {

    interface View extends BaseView<Presenter> {

        // 登入成功
        void loginSuccess();

        // 登入失敗
        void loginFail();

        void showDialog();

        void hideDialog();
    }

    interface Presenter extends BasePresenter {

        // 登入邏輯
        void login(String username, String password);
    }
}
