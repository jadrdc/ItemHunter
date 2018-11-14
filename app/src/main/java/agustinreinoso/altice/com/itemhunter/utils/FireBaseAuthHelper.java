package agustinreinoso.altice.com.itemhunter.utils;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FireBaseAuthHelper {
    private FirebaseAuth mAuth;

    public void setMcreationResponse(FireBaseUserCreation mcreationResponse) {
        this.mcreationResponse = mcreationResponse;
    }

    private FireBaseUserCreation mcreationResponse;

    public void setLoginResponse(FireBaseLogin loginResponse) {
        this.loginResponse = loginResponse;
    }

    private FireBaseLogin loginResponse;


    public GoogleSignInClient getmClient() {
        return mClient;
    }

    private GoogleSignInClient mClient;


    public FireBaseAuthHelper() {
        mAuth = FirebaseAuth.getInstance();

    }


    public void signUp(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                mcreationResponse.onSuccess();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                mcreationResponse.onError();
            }
        });
    }

    public void configureGoogleSignIn(Context context) {

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail().requestIdToken("1041959045598-68qvljrs9hudfg3g4gh2gms4gvma0ck2.apps.googleusercontent.com \t")
                .build();
        mClient = GoogleSignIn.getClient(context, gso);


    }

    public void createUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                mcreationResponse.onSuccess();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                mcreationResponse.onError();
            }
        }).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                mcreationResponse.onCompleted();
            }
        });
    }

    public void loginEmail(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                loginResponse.onError();
            }
        }).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                loginResponse.onSuccess();
            }
        }).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                loginResponse.onCompleted();
            }
        });


    }

    public void logOut()

    {
        mAuth.signOut();

    }

    public interface FireBaseLogin {
        void onSuccess();

        void onCompleted();

        void onError();

    }

    public interface FireBaseUserCreation {
        void onSuccess();

        void onCompleted();

        void onError();
    }

}
