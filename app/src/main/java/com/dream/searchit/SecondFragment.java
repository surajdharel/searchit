package com.dream.searchit;


import android.*;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.net.sip.SipSession;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dream.searchit.models.Contact_info;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {
    private GoogleMap map;
    private LatLng latLng;
    private Marker marker;
    private GoogleApiClient googleApiClient;
    private MapView mview;
    private View layout;
    private static final int REQUEST_LOCATION_PERMISSION = 100;
    private LocationRequest locationRequest;
    private Contact_info info;



    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      //  double lat = 28.2120;
      //  double lng = 83.9991;





        Intent i = getActivity().getIntent(); // in case of fragment, write getactivity.getintent to call data from activity!!
        info= (Contact_info) i.getSerializableExtra("Name1");





        final LatLng latLng = new LatLng(info.getLat(), info.getLng());

        layout = inflater.inflate(R.layout.fragment_second, container, false);






        SupportMapFragment fragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (fragment == null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragment = SupportMapFragment.newInstance();
            fragmentTransaction.replace(R.id.map, fragment).commit();
        }

        if (fragment != null) {
            fragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    if (googleMap != null) {

                        googleMap.getUiSettings().setAllGesturesEnabled(true);


                        CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(15.0f).build();

                        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
                        googleMap.addMarker(new MarkerOptions().position(latLng).title("pokhara").snippet("lakeside"));
                        googleMap.moveCamera(cameraUpdate);



                    }

                }
            });


        }


        return layout;


    }
}