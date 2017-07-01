package cs496.project1;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /*
    public void contacts(View view) {
        // Create a new Fragment to be placed in the activity layout
        ContactsFragment firstFragment = new ContactsFragment();

        // Add the fragment to the 'fragment_container' FrameLayout
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).commit();
    }
    */
}