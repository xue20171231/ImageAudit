package com.xue.utils;

import com.baidu.aip.imagecensor.AipImageCensor;
import org.json.JSONObject;

/**
 * 图像审核
 * @author Xuezg
 * @version 1.0
 * <url src="http://ai.baidu.com/tech/imagecensoring">图像内容审核</url>
 */
public class ImageAuditUtil {

    /**
     * 该三个变量的值是需要在百度云图像审核应用里创建应用取对应的值
     * <url src="https://console.bce.baidu.com/ai/?fromai=1#/ai/antiporn/app/list">百度云图像审核地址</url>
     */
    //设置APPID/AK/SK
    public static final String APP_ID = "15179734";
    public static final String API_KEY = "Zydq7mnuML4YGvkaiQGdFfX3";
    public static final String SECRET_KEY = "BYhjbgZNCdtKIBP2pCbxFcoOPCL5T5m9";

    /**
     * 图像内容审核入口
     * @param path 图片路径
     */
    public static String imageCensor(String path){
        // 初始化一个AipImageCensor
        AipImageCensor client = new AipImageCensor(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        JSONObject res = client.antiPorn(path);
        System.out.println(res.toString(2));
        return res.toString(2);
    }

    public static void main(String[] args) {
        // 初始化一个AipImageCensor
        AipImageCensor client = new AipImageCensor(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "E:\\myProjects\\ideaWorkspace\\myProjects\\Scan_Info\\web\\images\\t.jpg";
        JSONObject res = client.antiPorn(path);
        System.out.println(res.toString(2));

    }
}
