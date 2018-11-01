package agustinreinoso.altice.com.itemhunter.views;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import agustinreinoso.altice.com.itemhunter.R;
import agustinreinoso.altice.com.itemhunter.viewmodels.ProductListViewModel;
import agustinreinoso.altice.com.itemhunter.viewmodels.UserViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserProfileFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {

    private UserViewModel mUserViewModel;
    private CheckBox mchkFood;
    private CheckBox mchkTech;
    private CheckBox mchkDrink;
    private CheckBox mchkCloth;

    public UserProfileFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        mchkCloth = view.findViewById(R.id.ropa_not);
        mchkFood = view.findViewById(R.id.comid_not);
        mchkDrink = view.findViewById(R.id.bebida_not);
        mchkTech = view.findViewById(R.id.tecnologia_not);


        SharedPreferences preferences = getActivity().getSharedPreferences("subscripcion", Context.MODE_PRIVATE);
        mchkTech.setChecked(preferences.getBoolean(mchkTech.getTag().toString(), false));
        mchkFood.setChecked(preferences.getBoolean(mchkFood.getTag().toString(), false));
        mchkDrink.setChecked(preferences.getBoolean(mchkDrink.getTag().toString(), false));
        mchkCloth.setChecked(preferences.getBoolean(mchkCloth.getTag().toString(), false));

        mchkCloth.setOnCheckedChangeListener(this);
        mchkTech.setOnCheckedChangeListener(this);
        mchkFood.setOnCheckedChangeListener(this);
        mchkDrink.setOnCheckedChangeListener(this);

        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        {
            inflater.inflate(R.menu.toolbar, menu);
            menu.removeItem(R.id.option_take_picture);

            super.onCreateOptionsMenu(menu, inflater);

        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        mUserViewModel.manageSubscriptionTopic(buttonView.getTag().toString(), isChecked);
        SharedPreferences preferences = getActivity().getSharedPreferences("subscripcion", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(buttonView.getTag().toString(), isChecked);
        editor.commit();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mUserViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
    }

}