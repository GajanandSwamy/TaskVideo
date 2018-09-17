package com.example.manvish.taskvideo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.manvish.taskvideo.POJO.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

//    String path="http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";

    private List<Video> employeeList;
    private ProgressDialog pDialog;
    private RecyclerView recyclerView;
    private VideoAdapter eAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Loading Data.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        //Creating an object of our api interface
        ApiService api = RetroClient.getApiService();

        /**
         * Calling JSON
         */
        Call<Video> call = api.getMyJSON();

        /**
         * Enqueue Callback will be call when get response...
         */
        call.enqueue(new Callback<Video>() {
            @Override
            public void onResponse(Call<Video> call, Response<Video> response) {
                //Dismiss Dialog
                pDialog.dismiss();

                if (response.isSuccessful()) {
                    /**
                     * Got Successfully
                     */
                    employeeList = response.body().getVideos();
                    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
                    eAdapter = new VideoAdapter(employeeList);
                    RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(eLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(eAdapter);
                }
            }

            @Override
            public void onFailure(Call<Video> call, Throwable t) {
                pDialog.dismiss();
            }
        });
    }


//
//
////        VideoView videoView =(VideoView)findViewById(R.id.videoView1);
//
//        //Creating MediaController
//        MediaController mediaController= new MediaController(this);
//        mediaController.setAnchorView(videoView);
//
//        //specify the location of media file
////        Uri uri=Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/music/jellyfish-25-mbps-hd-hevc.mp4");
//
//        Uri uri=Uri.parse(path);
//
//
//        //Setting MediaController and URI, then starting the videoView
//        videoView.setMediaController(mediaController);
//        videoView.setVideoURI(uri);
//        videoView.requestFocus();
//        videoView.start();

    }
