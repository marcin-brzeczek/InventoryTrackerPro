package com.mbit.inventorytracker.injection;

import android.app.Fragment;
import com.mbit.inventorytracker.fragments.positions_list.scanned_list.ScannedListFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      FragmentInjectorsModule_ContributeScannedListFragment$app_debug
          .ScannedListFragmentSubcomponent.class
)
public abstract class FragmentInjectorsModule_ContributeScannedListFragment$app_debug {
  private FragmentInjectorsModule_ContributeScannedListFragment$app_debug() {}

  @Binds
  @IntoMap
  @FragmentKey(ScannedListFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      ScannedListFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface ScannedListFragmentSubcomponent extends AndroidInjector<ScannedListFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ScannedListFragment> {}
  }
}
