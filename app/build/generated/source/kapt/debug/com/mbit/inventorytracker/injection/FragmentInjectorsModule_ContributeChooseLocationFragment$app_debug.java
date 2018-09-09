package com.mbit.inventorytracker.injection;

import android.app.Fragment;
import com.mbit.inventorytracker.fragments.choose_location.ChooseLocationFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      FragmentInjectorsModule_ContributeChooseLocationFragment$app_debug
          .ChooseLocationFragmentSubcomponent.class
)
public abstract class FragmentInjectorsModule_ContributeChooseLocationFragment$app_debug {
  private FragmentInjectorsModule_ContributeChooseLocationFragment$app_debug() {}

  @Binds
  @IntoMap
  @FragmentKey(ChooseLocationFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      ChooseLocationFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface ChooseLocationFragmentSubcomponent
      extends AndroidInjector<ChooseLocationFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ChooseLocationFragment> {}
  }
}
