package com.mbit.inventorytracker.injection;

import android.app.Fragment;
import com.mbit.inventorytracker.fragments.scan_positions.ScanPositionsFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      FragmentInjectorsModule_ContributeScanPositionsFragment$app_debug
          .ScanPositionsFragmentSubcomponent.class
)
public abstract class FragmentInjectorsModule_ContributeScanPositionsFragment$app_debug {
  private FragmentInjectorsModule_ContributeScanPositionsFragment$app_debug() {}

  @Binds
  @IntoMap
  @FragmentKey(ScanPositionsFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      ScanPositionsFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface ScanPositionsFragmentSubcomponent
      extends AndroidInjector<ScanPositionsFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ScanPositionsFragment> {}
  }
}
