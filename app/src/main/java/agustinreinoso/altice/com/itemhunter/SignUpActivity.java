package agustinreinoso.altice.com.itemhunter;

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

import org.w3c.dom.Text;

import agustinreinoso.altice.com.itemhunter.model.User;
import agustinreinoso.altice.com.itemhunter.utils.FireBaseAuthHelper;
import agustinreinoso.altice.com.itemhunter.viewmodels.UserViewModel;
import agustinreinoso.altice.com.itemhunter.views.LoginActivity;
import agustinreinoso.altice.com.itemhunter.views.MainActivity;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener, FireBaseAuthHelper.FireBaseUserCreation {

    private UserViewModel muserViewModel;
    private TextView mtxtEmail;
    private TextView mtxtPassword;
    private Button mbtnSignup;
    private ProgressBar mprogressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        muserViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        mtxtEmail = findViewById(R.id.txtEmail);
        mtxtPassword = findViewById(R.id.txtPassword);
        mbtnSignup = findViewById(R.id.btn_signup);
        mbtnSignup.setOnClickListener(this);
        mprogressbar = findViewById(R.id.progress_bar);
        muserViewModel.setCreationListener(this);
    }


    @Override
    public void onClick(View v) {
        String email = mtxtEmail.getText().toString();
        String password = mtxtPassword.getText().toString();
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "No se pueden dejar datos vacios ", Toast.LENGTH_LONG).show();
        } else {
            mprogressbar.setVisibility(View.VISIBLE);
            muserViewModel.signUpUser(email, password);

        }

    }

    @Override
    public void onSuccess() {
        Toast.makeText(getApplicationContext(), "Usuario Creado correctamente ", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onCompleted() {

        mprogressbar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onError() {
        Toast.makeText(getApplicationContext(), "Error creando Usuario ", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }
}

