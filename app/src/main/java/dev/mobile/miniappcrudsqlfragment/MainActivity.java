package dev.mobile.miniappcrudsqlfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import dev.mobile.miniappcrudsqlfragment.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnFragAjout.setOnClickListener(this);
        binding.btnFragLister.setOnClickListener(this);
        binding.btnFragModif.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if(view.equals(binding.btnFragAjout))
        {
            loadFragment(new AjoutFragment());
        }

        if(view.equals(binding.btnFragLister))
        {
            loadFragment(new ListerFragment());
        }

        if(view.equals(binding.btnFragModif))
        {
            loadFragment(new Modifier());
        }

    }

    private void loadFragment(Fragment fragment)
    {
        Bundle bundle = new Bundle();
        ContactBDD db = new ContactBDD(MainActivity.this);
        bundle.putSerializable("Clé", db);
        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_placeholder, fragment).commit();
    }
}