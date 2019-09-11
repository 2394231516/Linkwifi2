package com.example.a2394231516.linkwifi2;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/*
 * 项目名：  Linkwifi2
 * 包名：    com.example.a2394231516.linkwifi2
 * 文件名：  SendAsyncTask
 * 创建者：  LCW
 * 创建时间：2019/4/27 16:33
 * 描述：    传输数据异步处理
 */


public class SendAsyncTask extends AsyncTask<String,Void,Void> {
    private  int port = 8899;  //连接的端口
    private  String ip = "192.168.1.100";
    private Socket socket;
    private PrintStream out =null;
    @Override
    protected Void doInBackground(String... params) {

        String str = params[0];

//        char[] chars = str.toCharArray();
//        StringBuffer hex = new StringBuffer();
//        for(int i=0; i<chars.length; i++){
//            hex.append(Integer.toHexString((int)chars[i]));
//        }
//        Log.i("tag",String.valueOf(hex));
//
//        for(int i =0; i<str.length(); i++){
//            array[i / 2] = array[i / 2] + str.charAt(i);
//        }
//        for(int i=0; i<array.length; i++){
//
//        }

/*
十六进制转换成字符串
 */
//        StringBuilder sb = new StringBuilder();
//        for(int i=0; i< bytes.length; i++){
//            String hex = Integer.toHexString(0xFF & bytes[i]);
//            if(hex.length() ==1){
//                sb.append('0');
//            }
//            sb.append(hex);
//        }

//        Log.i("tag", String.valueOf(sb).toUpperCase());

        byte[] bytes = changform(str);    //字符串转换成byte
        Log.i("tag", String.valueOf(bytes));

        try {
            socket = new Socket(ip,port);  //开启通信
            socket.setSoTimeout(5000);  //设置连接超时时间

            out = new PrintStream(socket.getOutputStream());
            out.write(bytes);    //传送数据(十六进制即byte类型
            out.flush();       //提交数据
            BufferedReader bff = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Log.d("msg",bff.toString());
            String line = "";
            int Buffer;
            Buffer = bff.read();
//            while((line = bff.readLine()) != null){
//                Buffer = Buffer + line;
//            }
            Log.d("msg", String.valueOf(Buffer));
            if(socket == null){
                return null;
            }else{
                out.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /*
    字符串转变成十六进制
     */
    private byte[] changform(String str){
        str = str.replace(" ","");
        Log.i("tag",str);
        int len = str.length();
        byte[] bytes = new byte[len / 2];
        for(int i=0; i< len; i+=2){
            bytes[i/2] = (byte)((Character.digit(str.charAt(i),16) << 4) + Character.digit(str.charAt(i+1),16));
        }

        return bytes;
    }



}
