package com.example.a2394231516.linkwifi2;

import android.os.Handler;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 项目名：  Linkwifi2
 * 包名：    com.example.a2394231516.linkwifi2
 * 文件名：  Service
 * 创建者：  LCW
 * 创建时间：2019/4/27 16:45
 * 描述：    监听收到的信息
 */
public class Service implements Runnable{


    private ServerSocket mServerSocket;
    private byte[] receice;
    private DataInputStream in;
    private Handler handler = new Handler();
    private Socket clinet;
    private InputStream inputstream;
    private String Buffer;
    private PrintStream out = null;

    public Service(){

    }

    public void setHandler(Handler handler){
        this.handler = handler;
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[1024];
            int bytes;
            while (true) {
                clinet = new Socket("196.168.43.1",54321);
                out = new PrintStream(clinet.getOutputStream());
                out.write(0);    //传送数据(十六进制即byte类型
                out.flush();
                BufferedReader bff = new BufferedReader(new InputStreamReader(clinet.getInputStream()));
                String line = null;
                String Buffer = "";
                while((line = bff.readLine()) != null){
                    Buffer = Buffer + line;
                }
                Log.d("tag",Buffer);

            }

        } catch (Exception e) {
            e.printStackTrace();

                try {
                    if(clinet != null)
                    clinet.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
        }

    }
}
