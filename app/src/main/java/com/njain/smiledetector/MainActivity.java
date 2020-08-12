package com.njain.smiledetector;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.frame.Frame;
import com.otaliastudios.cameraview.frame.FrameProcessor;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FrameProcessor {

    private Facing cameraFacing = Facing.FRONT;
    private ImageView imageView;
    private CameraView faceDetectionCameraView;
    private RecyclerView bottomSheetRecyclerView;
    private BottomSheetBehavior bottomSheetBehavior;
    private ArrayList<FaceDetectionModel> faceDetectionModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        faceDetectionModels = new ArrayList<>();
        bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottom_sheet));

        imageView = findViewById(R.id.face_detection_image_view);
        faceDetectionCameraView = findViewById(R.id.face_detection_camera_view);
        ImageView toggleButton = findViewById(R.id.face_detection_camera_toggle_button);
        FrameLayout bottomSheetButton = findViewById(R.id.bottom_sheet_button);
        bottomSheetRecyclerView = findViewById(R.id.bottom_sheet_recycler_view);

        faceDetectionCameraView.setFacing(cameraFacing);
        faceDetectionCameraView.setLifecycleOwner(this);
        faceDetectionCameraView.addFrameProcessor(this);
    }

    @Override
    public void process(@NonNull Frame frame) {

    }
}