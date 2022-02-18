package com.example.friendsapiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2, e3, e4;
    AppCompatButton b1;
    String getName, getFriendName, getFriendNickName, getFriendDescription;
    String apiUrl = "http://dummyapifriends.herokuapp.com/adddata";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.nm);
        e2 = (EditText) findViewById(R.id.frnd);
        e3 = (EditText) findViewById(R.id.frnick);
        e4 = (EditText) findViewById(R.id.frdes);
        b1 = (AppCompatButton) findViewById(R.id.sbt);


        b1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                getName=e1.getText().toString();
                getFriendName=e2.getText().toString();
                getFriendNickName=e3.getText().toString();
                getFriendDescription=e4.getText().toString();
                StringRequest sr = new StringRequest(Request.Method.POST, apiUrl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String, String> params = new HashMap<>();
                        params.put("name", getName);
                        params.put("friendName", getFriendName);
                        params.put("friendNickName", getFriendNickName);
                        params.put("DescribeYourFriend", getFriendDescription);
                        return params;
                    }
                };
                RequestQueue rq = Volley.newRequestQueue(getApplicationContext());
                rq.add(sr);
            }
        });

    }
}
