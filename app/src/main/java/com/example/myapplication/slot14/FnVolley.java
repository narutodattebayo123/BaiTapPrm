package com.example.myapplication.slot14;

import android.content.Context;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FnVolley {
    // getStringByVolley
    public void getStringByVolley(Context context, TextView textView) {
        // 1. Tạo request
        RequestQueue queue = Volley.newRequestQueue(context);
        // 2. URL
        String url = "https://www.google.com/";
        // 3. Truyền tham số
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Lấy về 1000 ký tự đầu tiên
                textView.setText("KQ: " + response.substring(0, 1000));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText(error.getMessage());
            }
        });
        // 4. Thực thi request
        queue.add(stringRequest);
    }

    // getArrayOfObjects
    String strJSON = "";
    public void getArrayOfObjects(Context context, TextView textView) {
        // URL của JSON
        String url = "https://hungnttg.github.io/array_json_new.json";
        // 1. Tạo request
        RequestQueue queue = Volley.newRequestQueue(context);
        // 2. JsonArrayRequest
        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                // Duyệt mảng
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject person = response.getJSONObject(i);
                        // Lấy về 1 đối tượng trong mảng
                        // Đọc từng trường dữ liệu
                        String id = person.getString("id");
                        String name = person.getString("name");
                        String email = person.getString("email");
                        JSONObject phone = person.getJSONObject("phone");
                        // Lấy về đối tượng con
                        String mobile = phone.getString("mobile");
                        // Lấy về từng trường của đối tượng con
                        String home = phone.getString("home");
                        // Chuyển sang chuỗi
                        strJSON += "ID: " + id + "\n";
                        strJSON += "Name: " + name + "\n";
                        strJSON += "Email: " + email + "\n";
                        strJSON += "Mobile: " + mobile + "\n";
                        strJSON += "Home: " + home + "\n";
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
                // Đưa dữ liệu lên TextView
                textView.setText(strJSON);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText(error.getMessage());
            }
        });
        // 4. Thực thi request
        queue.add(request);
    }
    public void insertVolley(Context context, TextView tvResult, TextView tvName, TextView tvPrice, TextView tvDes){
        RequestQueue queue = Volley.newRequestQueue(context);
        String url="http://10.33.14.8/000/202406/create_product.php";

//        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
//                new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                tvResult.setText(response.toString());
//            }
//        })
    }
}
