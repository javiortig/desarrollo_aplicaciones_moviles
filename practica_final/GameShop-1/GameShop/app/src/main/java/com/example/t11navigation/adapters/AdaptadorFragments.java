package com.example.t11navigation.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.t11navigation.fragments.FragmentCarrito;
import com.example.t11navigation.fragments.FragmentCompras;
import com.example.t11navigation.fragments.FragmentWelcome;
import com.example.t11navigation.fragments.FragmentOfertas;

import java.util.ArrayList;

public class AdaptadorFragments extends FragmentPagerAdapter {

    private String[] title = {"Welcome","Compras","Ofertas","Carrito"};

    private ArrayList<Fragment> listaFragments;

    public AdaptadorFragments(@NonNull FragmentManager fm) {
        super(fm);
        listaFragments = new ArrayList<>();
        listaFragments.add(new FragmentWelcome());
        listaFragments.add(new FragmentCompras());
        listaFragments.add(new FragmentOfertas());
        listaFragments.add(new FragmentCarrito());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listaFragments.get(position);
    }

    @Override
    public int getCount() {
        return listaFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }


}
