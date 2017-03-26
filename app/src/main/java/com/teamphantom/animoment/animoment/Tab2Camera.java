package com.teamphantom.animoment.animoment;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;
import android.graphics.Bitmap;
/**
 * Created by dchi on 3/25/17.
 */

public class Tab2Camera extends Fragment {

    Button btnPic;
    ImageView imgTakenPic;
    private static final int CAM_REQUEST = 1313;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2camera, container, false);
        btnPic = (Button) rootView.findViewById(R.id.captureButton);
        imgTakenPic = (ImageView) rootView.findViewById(R.id.cameraView);
        btnPic.setOnClickListener(new btnTakePhotoClicker());
        return rootView;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == CAM_REQUEST){
         Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgTakenPic.setImageBitmap(bitmap);
        }
    }
   class btnTakePhotoClicker implements Button.OnClickListener{
       @Override
       public void onClick(View view) {
           Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
           startActivityForResult(intent, CAM_REQUEST);
       }
   }
}

