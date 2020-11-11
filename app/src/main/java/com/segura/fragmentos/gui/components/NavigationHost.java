package com.segura.fragmentos.gui.components;

import androidx.fragment.app.Fragment;

import com.segura.fragmentos.gui.AddFragment;
import com.segura.fragmentos.gui.TopJuegos;

public interface NavigationHost {
    void navigateTo(Fragment fragment, boolean addToBackStack);
}
