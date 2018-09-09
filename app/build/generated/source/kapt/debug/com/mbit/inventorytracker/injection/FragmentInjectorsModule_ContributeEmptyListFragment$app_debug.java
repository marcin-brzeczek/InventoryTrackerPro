package com.mbit.inventorytracker.injection;

import android.app.Fragment;
import com.mbit.inventorytracker.fragments.positions_list.empty_list.EmptyListFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      FragmentInjectorsModule_ContributeEmptyListFragment$app_debug.EmptyListFragmentSubcomponent
          .class
)
public abstract class FragmentInjectorsModule_ContributeEmptyListFragment$app_debug {
  private FragmentInjectorsModule_ContributeEmptyListFragment$app_debug() {}

  @Binds
  @IntoMap
  @FragmentKey(EmptyListFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      EmptyListFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface EmptyListFragmentSubcomponent extends AndroidInjector<EmptyListFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<EmptyListFragment> {}
  }
}
