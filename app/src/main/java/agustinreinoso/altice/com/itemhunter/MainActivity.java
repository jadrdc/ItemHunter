package agustinreinoso.altice.com.itemhunter;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import agustinreinoso.altice.com.itemhunter.adapters.ViewPagerFragmentAdapter;
import agustinreinoso.altice.com.itemhunter.dao.ProductFireBaseRepository;
import agustinreinoso.altice.com.itemhunter.model.Product;
import agustinreinoso.altice.com.itemhunter.viewmodels.ProductViewModel;
import agustinreinoso.altice.com.itemhunter.views.ProductCreationFragment;
import agustinreinoso.altice.com.itemhunter.views.ProductListFragment;
import agustinreinoso.altice.com.itemhunter.views.UserProfileFragment;

public class MainActivity extends AppCompatActivity {

    private ProductViewModel productViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout = findViewById(R.id.tabs);
        ViewPager pager = findViewById(R.id.view_pager);
        ViewPagerFragmentAdapter adapter = new ViewPagerFragmentAdapter(getSupportFragmentManager());

        adapter.addFragment(new ProductListFragment());
        adapter.addFragment(new ProductCreationFragment());
        adapter.addFragment(new UserProfileFragment());
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);

        tabLayout.getTabAt(0).setIcon(R.drawable.list_not);
        tabLayout.getTabAt(1).setIcon(R.drawable.add);
        tabLayout.getTabAt(2).setIcon(R.drawable.profile);

        productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
    }


}
