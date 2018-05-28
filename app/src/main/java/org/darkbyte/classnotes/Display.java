package org.darkbyte.classnotes;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.DownloadListener;
import com.androidnetworking.interfaces.DownloadProgressListener;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

public class Display extends AppCompatActivity {
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    PDFView pdfView;
    SharedPrefs sharedPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent i =getIntent();
        Bundle b = i.getBundleExtra("bundle");
        final TextView dep= (TextView)findViewById(R.id.department_display);
        final TextView sem =(TextView)findViewById(R.id.semester_display);
        pdfView=(PDFView)findViewById(R.id.pdfView);
        final String dep1=b.getString("department");
        final String sem1=b.getString("semester");
        final String sub1=b.getString("subject");
        final String chap=b.getString("chapter");
        dep.setText(dep1);
        sharedPrefs=new SharedPrefs(this);
        sem.setText(sem1);
        verifyStoragePermissions(this);
       // WebView webview = (WebView) findViewById(R.id.webview);
       // webview.getSettings().setJavaScriptEnabled(true);
        //String pdf = "http://teamvibhav.in/pdf/"+dep1+sem1+sub1+".pdf";
        String pdf = "http://192.168.2.25/pdf/test1.pdf";
       // webview.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + pdf);
      //  webview.loadUrl("https://docs.google.com/viewer?url="+pdf);
        String path=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+"/"+dep1+sem1+sub1+".pdf";
File file=new File(path);
        if (file.exists())
        {
            sharedPrefs.saveprefs(dep1, sem1, sub1,chap, "downloaded");
        }
        else{
            sharedPrefs.saveprefs(dep1, sem1, sub1,chap, "yet to download");
        }
if(!sharedPrefs.getdownloadstatus(dep1,sem1,sub1,chap).equals("downloaded")) {

    AndroidNetworking.download(pdf, String.valueOf(Environment
            .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)), "syl.pdf")
            .setTag("downloadTest")
            .setPriority(Priority.MEDIUM)
            .build()
            .setDownloadProgressListener(new DownloadProgressListener() {
                @Override
                public void onProgress(long bytesDownloaded, long totalBytes) {
                    dep.setText("downloading");

                }
            })
            .startDownload(new DownloadListener() {
                @Override
                public void onDownloadComplete() {
                    // do anything after completion
                    dep.setText("download completed");
                    sharedPrefs.saveprefs(dep1, sem1, sub1,chap, "downloaded");
                }

                @Override
                public void onError(ANError error) {
                    // handle error
                    dep.setText("download failed" + String.valueOf(Environment
                            .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)));
                    sem.setText("" + error);
                    sharedPrefs.saveprefs(dep1, sem1, sub1,chap, "yet to download");
                }
            });
}
 File file2= new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+"/syl.pdf");
Log.v("file",""+file2);

        pdfView.fromFile(file2)
                 // all pages are displayed by default
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)

                .enableAnnotationRendering(false)
                .password(null)
                .scrollHandle(null)
                .load();
    }
    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have read or write permission
        int writePermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int readPermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE);

        if (writePermission != PackageManager.PERMISSION_GRANTED || readPermission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }
}
