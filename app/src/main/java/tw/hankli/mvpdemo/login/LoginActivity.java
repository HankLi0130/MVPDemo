package tw.hankli.mvpdemo.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import tw.hankli.mvpdemo.R;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private LoginContract.Presenter presenter;

    private TextView txtUsername;
    private TextView txtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO 可使用 DI Library 注入
        presenter = new LoginPresenter(this);

        txtUsername = findViewById(R.id.txt_username);
        txtPassword = findViewById(R.id.txt_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(view -> {

            String username = txtUsername.getText().toString();
            String password = txtPassword.getText().toString();

            // 通知Presenter做登入邏輯
            presenter.login(username, password);
        });
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Login Success", Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginFail() {
        Toast.makeText(this, "Login Fail", Toast.LENGTH_LONG).show();
    }
}
