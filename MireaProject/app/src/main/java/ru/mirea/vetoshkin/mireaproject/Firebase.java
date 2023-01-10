package ru.mirea.vetoshkin.mireaproject;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Firebase extends Fragment {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView mStatusTextView;
    private TextView mDetailTextView;
    private EditText mEmailField;
    private EditText mPasswordField;
    private FirebaseAuth mAuth;
    private View inflaterView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflaterView = inflater.inflate(R.layout.fragment_firebase, container, false);
        // Views
        mStatusTextView = inflaterView.findViewById(R.id.status);
        mDetailTextView = inflaterView.findViewById(R.id.detail);
        mEmailField = inflaterView.findViewById(R.id.editTextEmail);
        mPasswordField = inflaterView.findViewById(R.id.editTextPass);
        // Buttons
        Button buttonSignIn = inflaterView.findViewById(R.id.button_signIn);
        buttonSignIn.setOnClickListener(v -> signIn(mEmailField.getText().toString(), mPasswordField.getText().toString()));
        Button buttonCrAccount = inflaterView.findViewById(R.id.button_crAccount);
        buttonCrAccount.setOnClickListener(v -> createAccount(mEmailField.getText().toString(), mPasswordField.getText().toString()));
        Button buttonSignOut = inflaterView.findViewById(R.id.button_signOut);
        buttonSignOut.setOnClickListener(v -> signOut());
        Button buttonVerifyEmail = inflaterView.findViewById(R.id.button_verifyEmail);
        buttonVerifyEmail.setOnClickListener(v -> { });

        mAuth = FirebaseAuth.getInstance();
        return inflaterView;
    }
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }
    private void updateUI(FirebaseUser user) {
        if (user != null) {
            mStatusTextView.setText(getString(R.string.emailpassword_status_fmt,
                    user.getEmail(), user.isEmailVerified()));
            mDetailTextView.setText(getString(R.string.firebase_status_fmt, user.getUid()));
            inflaterView.findViewById(R.id.button_crAccount).setVisibility(View.GONE);
            inflaterView.findViewById(R.id.editTextPass).setVisibility(View.GONE);
            inflaterView.findViewById(R.id.button_signIn).setVisibility(View.GONE);
            inflaterView.findViewById(R.id.button_verifyEmail).setEnabled(!user.isEmailVerified());
            inflaterView.findViewById(R.id.button_signOut).setVisibility(View.VISIBLE);
        } else {
            mStatusTextView.setText(R.string.signed_out);
            mDetailTextView.setText(null);
            inflaterView.findViewById(R.id.button_crAccount).setVisibility(View.VISIBLE);
            inflaterView.findViewById(R.id.editTextPass).setVisibility(View.VISIBLE);
            inflaterView.findViewById(R.id.button_signIn).setVisibility(View.VISIBLE);
            inflaterView.findViewById(R.id.button_signOut).setVisibility(View.GONE);
        }
    }
    private boolean validateForm() {
        boolean valid = true;
        String email = mEmailField.getText().toString();
        if (TextUtils.isEmpty(email)) {
            mEmailField.setError("Required.");
            valid = false;
        } else {
            mEmailField.setError(null);
        }
        String password = mPasswordField.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mPasswordField.setError("Required.");
            valid = false;
        } else {
            mPasswordField.setError(null);
        }
        return valid;
    }
    private void createAccount(String email, String password) {
        Log.d(TAG, "createAccount:" + email);
        if (!validateForm()) {
            return;
        }
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getActivity(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }
    private void signIn(String email, String password) {
        Log.d(TAG, "signIn:" + email);
        if (!validateForm()) {
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(getActivity(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                        if (!task.isSuccessful()) {
                            mStatusTextView.setText(R.string.auth_failed);
                        }
                    }
                });
    }
    private void signOut() {
        mAuth.signOut();
        updateUI(null);
    }
}