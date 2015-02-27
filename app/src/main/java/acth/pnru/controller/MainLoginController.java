package acth.pnru.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import acth.pnru.worktracking.MainLoginActivity;
import acth.pnru.worktracking.NavigationMain;
import acth.pnru.worktracking.R;
import acth.pnru.worktracking.RegisterActivity;

/**
 * Created by Kittiphon on 26/2/2558.
 */
public class MainLoginController implements View.OnClickListener {
    private Context mContext;
    private MainLoginActivity mMainLoginActivity;

    public MainLoginController(MainLoginActivity mainLoginActivity) {
        this.mContext = mainLoginActivity.getApplicationContext();
        this.mMainLoginActivity = mainLoginActivity;
        setController();
    }

    private void setController() {
        mMainLoginActivity.getTv_register().setOnClickListener(this);
        mMainLoginActivity.getBtn_login().setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.TV_REGISTER:
                mMainLoginActivity.getApplicationContext().startActivity
                        (new Intent(mMainLoginActivity.getApplicationContext(), RegisterActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                break;
            case R.id.BTN_LOGIN:
                mMainLoginActivity.getApplicationContext().startActivity
                        (new Intent(mMainLoginActivity.getApplicationContext(),NavigationMain.class)
                                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                break;
        }

    }
}
