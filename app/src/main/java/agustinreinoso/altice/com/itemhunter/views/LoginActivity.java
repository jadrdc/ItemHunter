package agustinreinoso.altice.com.itemhunter.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.Task;

import agustinreinoso.altice.com.itemhunter.SignUpActivity;
import agustinreinoso.altice.com.itemhunter.utils.FireBaseAuthHelper;
import agustinreinoso.altice.com.itemhunter.R;
import agustinreinoso.altice.com.itemhunter.viewmodels.UserViewModel;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, FireBaseAuthHelper.FireBaseLogin {

    private SignInButton mSignInButton;
    private GoogleApiClient mGoogleApiClient;
    private UserViewModel mUserViewModel;
    private TextView mtxtUser;
    private TextView mtxtPassword;
    private int AUTH_API = 12345;
    private Button mbtnLogin;
    private ProgressBar mProgressbar;
    private Button mbtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mSignInButton = findViewById(R.id.sign_in_button);
        mSignInButton.setOnClickListener(this);
        mbtnLogin = findViewById(R.id.btn_login);
        mbtnLogin.setOnClickListener(this);
        mbtnRegister = findViewById(R.id.btn_register);
        mbtnRegister.setOnClickListener(this);

        mUserViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        mUserViewModel.getMauthHelper().getValue().configureGoogleSignIn(getApplicationContext());
        mUserViewModel.setLoginResponse(this);
        mtxtPassword = findViewById(R.id.txtPassword);
        mtxtUser = findViewById(R.id.txtEmail);
        mProgressbar = findViewById(R.id.progress_bar);
    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.sign_in_button) {
            mProgressbar.setVisibility(View.VISIBLE);
            Intent signIntent = mUserViewModel.getMauthHelper().getValue().getmClient().getSignInIntent();
            startActivityForResult(signIntent, AUTH_API);
        }
        if (R.id.btn_login == v.getId()) {
            String email = mtxtUser.getText().toString();
            String password = mtxtPassword.getText().toString();
            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(getApplicationContext(), "No se pueden dejar datos vacios ", Toast.LENGTH_LONG).show();

            } else {
                mProgressbar.setVisibility(View.VISIBLE);
               mUserViewModel.login(email, password);
            }
        }
        if (R.id.btn_register == v.getId()) {
            Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == AUTH_API) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            mProgressbar.setVisibility(View.INVISIBLE);

            login();
        }
    }

    @Override
    public void onSuccess() {
        login();
    }

    @Override
    public void onCompleted() {
        mProgressbar.setVisibility(View.INVISIBLE);


    }

    @Override
    public void onError() {
        Toast.makeText(getApplicationContext(), "Login Incorrecto", Toast.LENGTH_LONG).show();
    }


    public void login() {
        Intent app = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(app);

    }
}
