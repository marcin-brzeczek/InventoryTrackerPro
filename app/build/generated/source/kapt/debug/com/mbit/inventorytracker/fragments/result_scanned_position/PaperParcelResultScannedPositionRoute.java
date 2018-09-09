// Generated by paperparcel.PaperParcelProcessor (https://github.com/grandstaish/paperparcel).
package com.mbit.inventorytracker.fragments.result_scanned_position;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.mbit.inventorytracker.backstack.BaseRoute;
import paperparcel.TypeAdapter;
import paperparcel.internal.ParcelableAdapter;
import paperparcel.internal.StaticAdapters;

final class PaperParcelResultScannedPositionRoute {
  static final TypeAdapter<BaseRoute> BASE_ROUTE_PARCELABLE_ADAPTER =
      new ParcelableAdapter<BaseRoute>(null);

  @NonNull
  static final Parcelable.Creator<ResultScannedPositionRoute> CREATOR =
      new Parcelable.Creator<ResultScannedPositionRoute>() {
        @Override
        public ResultScannedPositionRoute createFromParcel(Parcel in) {
          String locationName = StaticAdapters.STRING_ADAPTER.readFromParcel(in);
          String tag = StaticAdapters.STRING_ADAPTER.readFromParcel(in);
          BaseRoute returnRoute =
              PaperParcelResultScannedPositionRoute.BASE_ROUTE_PARCELABLE_ADAPTER.readFromParcel(
                  in);
          boolean isReturning = in.readInt() == 1;
          ResultScannedPositionRoute data = new ResultScannedPositionRoute(locationName, tag);
          data.setReturnRoute(returnRoute);
          data.setReturning(isReturning);
          return data;
        }

        @Override
        public ResultScannedPositionRoute[] newArray(int size) {
          return new ResultScannedPositionRoute[size];
        }
      };

  private PaperParcelResultScannedPositionRoute() {}

  static void writeToParcel(
      @NonNull ResultScannedPositionRoute data, @NonNull Parcel dest, int flags) {
    StaticAdapters.STRING_ADAPTER.writeToParcel(data.getLocationName(), dest, flags);
    StaticAdapters.STRING_ADAPTER.writeToParcel(data.getTag(), dest, flags);
    PaperParcelResultScannedPositionRoute.BASE_ROUTE_PARCELABLE_ADAPTER.writeToParcel(
        data.getReturnRoute(), dest, flags);
    dest.writeInt(data.isReturning() ? 1 : 0);
  }
}