package tw.hankli.mvpdemo.model;

/**
 * Created by hank on 12/02/2018.
 * 複合服務區
 */

public class LoginRepository {

    private LoginApi loginApi;

    public LoginRepository() {
        // TODO 可使用 DI Library 注入
        loginApi = new LoginApi();
    }

    public boolean loginByApi(String username, String password) {
        return loginApi.login(username, password);
    }
}
