package com.baidu.ocr.demo;

import com.baidu.aip.face.AipFace;

import org.json.JSONObject;

import java.util.HashMap;

import static android.R.attr.path;

/**
 * Created by Administrator on 2017/7/27.
 */

public class AipFaceClient {
    //设置APPID/AK/SK
    public static final String APP_ID = "9929829";
    public static final String API_KEY = "jMOgEkwgt4mg4posgs91yE0R";
    public static final String SECRET_KEY = "29KGdC2box6mvzwAyD6zVNEnbb9EVErt";

    private static AipFaceClient instance;
    private static AipFace apiFace;

    private AipFaceClient (){
        // 初始化一个FaceClient
        if (apiFace == null) {
            apiFace = new AipFace(APP_ID, API_KEY, SECRET_KEY);
        }
        // 可选：设置网络连接参数
        apiFace.setConnectionTimeoutInMillis(2000);
        apiFace.setSocketTimeoutInMillis(60000);
    }

    public static AipFaceClient getInstance() {
        if (instance == null) {
            instance = new AipFaceClient();
        }
        return instance;
    }

    public JSONObject faceRecognize(String imagePath) {
        // 自定义参数定义
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("max_face_num", "1");
        options.put("face_fields", "age,beauty,gender");

        // 参数为本地图片路径
        if(instance != null && apiFace != null) {
            JSONObject response = apiFace.detect(imagePath, options);
            System.out.println(response.toString());
            return response;
        } else {
            return null;
        }

//        // 参数为本地图片文件二进制数组
//        byte[] file = readImageFile(imagePath);
//        JSONObject response = client.detect(file, options);
//        System.out.println(response.toString());
    }
}
