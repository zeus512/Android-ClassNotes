package org.darkbyte.classnotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
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

public class Subject extends AppCompatActivity {
RecyclerView recyclerView;
    SubjectAdapter adapter;
    List<SubjectModel> list;
    static String dep;
    static String sem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        list=new ArrayList<>();


//        Log.v("saa",""+list);
        adapter=new SubjectAdapter(list);
        recyclerView=(RecyclerView)findViewById(R.id.subject_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

          Intent i =getIntent();
        Bundle b = i.getBundleExtra("bundle");
         dep=b.getString("department");
         sem=b.getString("semester");
        sem=sem.toLowerCase();
        fetchsubjects();
    }
    public void fetchsubjects(){
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                . writeTimeout(120, TimeUnit.SECONDS)
                .build();
        AndroidNetworking.post("http://"+Constants.ip+"/classnotes/index.php/subject/"+dep+"/"+sem)
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
                            JSONObject json;
                            try {
                                SubjectModel homeItem_model =new SubjectModel();
                                json = response.getJSONObject(i);
                                Log.v("fgfgh","vlue"+json);


                                    if (!json.has("NoItems")){

                                        //  progressBar.setVisibility(View.GONE);
                                        if (response != null) {

                                            homeItem_model.setSubjectname(json.getString("subject"));

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
