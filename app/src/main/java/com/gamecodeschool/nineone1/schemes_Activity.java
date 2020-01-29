package com.gamecodeschool.nineone1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class schemes_Activity extends AppCompatActivity {
    TextView tvTitle,tvDivision,tvEmail,tvPattern,tvElig,tvBen,tvProc,tvLink;
    private String sesrchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schemes_);
        Intent intent=getIntent();
        sesrchText=intent.getStringExtra("key");

        tvTitle=findViewById(R.id.tvtit);
        tvDivision=findViewById(R.id.division);
        tvEmail=findViewById(R.id.tvemail);
        tvPattern=findViewById(R.id.tvpat);
        tvElig=findViewById(R.id.tvelig);
        tvBen=findViewById(R.id.tvBenefits);
        tvProc=findViewById(R.id.tvproc);
        tvLink=findViewById(R.id.tvLink);

        String url="https://api.myjson.com/bins/15zpq2";
        /*JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject jsonObject=new JSONObject(String.valueOf(response));
                    JSONArray jsonArray=jsonObject.getJSONArray("data");
                    for(int i=0;i<1;i++){
                        JSONObject patient=jsonArray.getJSONObject(i);
                        String title,disease,division,email,pattern,eligibility,benefits,link;

                            disease=patient.getString("disease");
                            title=patient.getString("title");
                            division=patient.getString("division");
                            email=patient.getString("email");
                            pattern=patient.getString("pattern");
                            eligibility=patient.getString("eligibility");
                            benefits=patient.getString("benefits");
                            link=patient.getString("link");
                            tvTitle.setText(title);
                            tvDivision.setText(division);
                            tvEmail.setText(email);
                            tvPattern.setText(pattern);
                            tvElig.setText(eligibility);
                            tvBen.setText(benefits);
                            tvLink.setText(link);
                            tvProc.setText(disease);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(schemes_Activity.this,"Error",Toast.LENGTH_SHORT).show();
            }
        });*/

    }
}
