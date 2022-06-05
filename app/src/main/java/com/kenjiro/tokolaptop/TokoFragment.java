package com.kenjiro.tokolaptop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TokoFragment extends Fragment {

    public TokoFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_toko, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Giving the same onClickListener method to every image on Fragment.
        // Each id will have different action, can be seen on doImplicit method.
        for (int iImage=1; iImage<3; iImage++){
            int idImage = getResources().getIdentifier("Implicit_" + iImage, "id", requireContext().getPackageName());
            View eventImage = view.findViewById(idImage);
            eventImage.setOnClickListener(this::doImplicit);
        }
    }

    public void doImplicit(View view){
        // Switch case using the id from for loop on onViewCreated method.
        switch (view.getId()){
            // If we click on the ImageView with id = Implicit_1
            case R.id.Implicit_1:
                String loc = "Laptop Store Denpasar";

                // Parse the location and create the intent.
                Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
                Intent intent1 = new Intent(Intent.ACTION_VIEW, addressUri);

                // Find an activity to handle the intent, and start that activity.
                startActivity(intent1);
                break;
            // If we click on the ImageView with id = Implicit_2
            case R.id.Implicit_2:
                String number = "081246007474";

                // Parse the number and create the intent.
                Uri numberUri = Uri.parse("tel:" + number);
                Intent intent2 = new Intent(Intent.ACTION_DIAL, numberUri);

                // Find an activity to handle the intent, and start that activity.
                startActivity(intent2);
                break;
        }
    }
}