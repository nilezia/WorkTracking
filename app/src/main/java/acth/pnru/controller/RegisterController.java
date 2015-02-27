package acth.pnru.controller;

import android.content.Context;

import acth.pnru.worktracking.RegisterActivity;

/**
 * Created by Kittiphon on 26/2/2558.
 */
public class RegisterController {
    private Context mContext;
    private RegisterActivity mRegisterActivity;
    public RegisterController (RegisterActivity registerActivity){
        this.mContext = registerActivity.getApplicationContext();
        this.mRegisterActivity = registerActivity;
    }
}
