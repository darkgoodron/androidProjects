package ru.mirea.vetoshkin.mireaproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MapsFragment extends Fragment implements GoogleMap.OnMapClickListener{

    private GoogleMap googleMap;
    private final ArrayList<MarkerOptions> mapMarkers = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View inflaterView = inflater.inflate(R.layout.fragment_maps, container, false);
        return inflaterView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }

    private final OnMapReadyCallback callback = new OnMapReadyCallback()
    {
        @Override
        public void onMapReady(GoogleMap googleMap) {
            googleMap.setOnMapClickListener(MapsFragment.this);
            LatLng strom = new LatLng(55.794259, 37.701448);
            googleMap.addMarker(new MarkerOptions().position(strom).title("РТУ МИРЭА, г. Москва, ул. Стромынка, д.20"));
            LatLng main = new LatLng(55.670005, 37.479894);
            googleMap.addMarker(new MarkerOptions().position(main).title("РТУ МИРЭА, г. Москва, Проспект Вернадского, д. 78"));
            LatLng him = new LatLng(55.661445, 37.477049);
            googleMap.addMarker(new MarkerOptions().position(him).title("РТУ МИРЭА, г. Москва, Проспект Вернадского, д. 86"));
            LatLng stavropol = new LatLng(45.049513, 41.912041);
            googleMap.addMarker(new MarkerOptions().position(stavropol).title("Ставропольский край\n г. Ставрополь,\n пр. Кулакова, д. 8"));
            LatLng phrazefo = new LatLng(55.966853, 38.050774);
            googleMap.addMarker(new MarkerOptions().position(phrazefo).title("Московская область, г. Фрязино, ул. Вокзальная, д. 2а"));
        }
    };

    private void addMarker(Date date, LatLng latLng){
        MarkerOptions marker = new MarkerOptions().title("Я был здесь в: "+date).position(latLng);
        Toast.makeText(getActivity(), "Время:"+date, Toast.LENGTH_SHORT).show();
        googleMap.addMarker(marker);
        mapMarkers.add(marker);
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        CameraPosition cameraPos = new CameraPosition.Builder().target(
                latLng).zoom(12).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPos));
        Date currentTime = Calendar.getInstance().getTime();
        latLng.toString();
        addMarker(currentTime, latLng);
    }

}