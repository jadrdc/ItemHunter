package agustinreinoso.altice.com.itemhunter.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import agustinreinoso.altice.com.itemhunter.R;

public class ViewPagerFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public ViewPagerFragmentAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    public void addFragment(Fragment fragment) {
        mFragmentList.add(fragment);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }

}
