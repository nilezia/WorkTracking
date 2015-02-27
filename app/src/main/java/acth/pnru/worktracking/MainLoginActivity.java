package acth.pnru.worktracking;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import acth.pnru.controller.MainLoginController;

/**
 * Created by Kittiphon on 25/2/2558.
 */
public class MainLoginActivity extends ActionBarActivity {
    private EditText edt_mail;
    private EditText edt_password;
    private Button btn_login;
    private TextView tv_register;
    private MainLoginController mMainLoginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        InitWidget();
    }

    private void InitWidget() {
        edt_mail = (EditText) findViewById(R.id.EDT_MAILE);
        edt_password = (EditText) findViewById(R.id.EDT_PASSWORD);
        btn_login = (Button) findViewById(R.id.BTN_LOGIN);
        tv_register = (TextView) findViewById(R.id.TV_REGISTER);
        mMainLoginController = new MainLoginController(this);

    }

    public TextView getTv_register() {
        return tv_register;
    }

    public EditText getEdt_mail() {
        return edt_mail;
    }

    public EditText getEdt_password() {
        return edt_password;
    }

    public Button getBtn_login() {
        return btn_login;
    }
}
