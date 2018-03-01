package tw.hankli.mvpdemo.login;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tw.hankli.mvpdemo.R;

/**
 * 將Activity、Fragment當成View
 */

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private LoginContract.Presenter presenter;

    private ProgressDialog dialog;

    @BindView(R.id.txt_username)
    TextView txtUsername;

    @BindView(R.id.txt_password)
    TextView txtPassword;

    @OnClick(R.id.btn_login)
    void login() {

        String username = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();

        // 通知Presenter做登入邏輯
        presenter.login(username, password);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        // TODO 可使用 DI Library 注入
        presenter = new LoginPresenter(this);
        dialog = new ProgressDialog(this);
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Login Success", Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginFail() {
        Toast.makeText(this, "Login Fail", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showDialog() {
        dialog.show();
    }

    @Override
    public void hideDialog() {
        dialog.dismiss();
    }
}
