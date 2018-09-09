package com.mbit.inventorytracker.injection;

import android.app.Fragment;
import com.mbit.inventorytracker.fragments.new_position.NewItemFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      FragmentInjectorsModule_ContributeNewItemFragment$app_debug.NewItemFragmentSubcomponent.class
)
public abstract class FragmentInjectorsModule_ContributeNewItemFragment$app_debug {
  private FragmentInjectorsModule_ContributeNewItemFragment$app_debug() {}

  @Binds
  @IntoMap
  @FragmentKey(NewItemFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      NewItemFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface NewItemFragmentSubcomponent extends AndroidInjector<NewItemFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<NewItemFragment> {}
  }
}
