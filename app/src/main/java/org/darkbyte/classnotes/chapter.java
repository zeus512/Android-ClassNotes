package org.darkbyte.classnotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class chapter extends AppCompatActivity {
    RecyclerView recyclerView;
    chapterAdapter adapter;
    List<chapterModel> list;
    static String dep;
    static String sem,subject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        list=new ArrayList<>();


//        Log.v("saa",""+list);
        adapter=new chapterAdapter(list);
        recyclerView=(RecyclerView)findViewById(R.id.chapter_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        Intent i =getIntent();
        Bundle b = i.getBundleExtra("bundle");
        dep=b.getString("department");
        sem=b.getString("semester");
        subject=b.getString("subject");
        fetchchapters();
    }
    public void fetchchapters(){
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                . writeTimeout(120, TimeUnit.SECONDS)
                .build();
        AndroidNetworking.post("http://"+Constants.ip+"/classnotes/index.php/chapter/"+dep+"/"+subject)
                .setPriority(Priority.MEDIUM)
                .setOkHttpClient(okHttpClient)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //  loadToast.success();
                        Log.d("LOG", "RESPONSE" + response);
                        // Toast.makeText(getApplicationContext(), "Response" + response.toString(), Toast.LENGTH_SHORT).show();
                        int j = response.length();
                        list.clear();
                        for (int i = 0; i < j; i++) {
                            Log.v("fgfgh","vlue"+j);
                            JSONObject json=null;
                            try {
                                chapterModel homeItem_model =new chapterModel();
                                json = response.getJSONObject(i);
                                Log.v("fgfgh","vlue"+json);


                                if (!json.has("NoItems")){

                                    //  progressBar.setVisibility(View.GONE);
                                    if (response != null) {

                                        homeItem_model.setchaptername(json.getString("chapter"));

                                        list.add(i,homeItem_model);
                                    }


                                }else {

                                    Toast.makeText(getApplicationContext(), "nothing in database", Toast.LENGTH_SHORT).show();
                                }


                            } catch (JSONException e) {
                                e.printStackTrace();
                                Toast.makeText(getApplicationContext(), "Please try after sometime", Toast.LENGTH_SHORT).show();
                            }

                            adapter.refresh(list);
                        }
                    }
                    @Override
                    public void onError(ANError anError) {
                        // loadToast.error();
                        Log.d("LOG", "RESPONSE" + anError);
                        Toast.makeText(getApplicationContext(), "Check Your Network Connection", Toast.LENGTH_SHORT).show();

                    }
                });
    }
}
