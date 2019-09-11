package com.example.a2394231516.linkwifi2.ui;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a2394231516.linkwifi2.R;
import com.example.a2394231516.linkwifi2.SendAsyncTask;
import com.example.a2394231516.linkwifi2.handle.ConnectThread;
import com.example.a2394231516.linkwifi2.handle.ListenerThread;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int DEVICE_CONNECTING = 2;
    public static final int DEVICE_CONNECTED = 3;
    public static final int SEND_MSG_SUCCSEE = 4;
    public static final int SEND_MSG_ERROR = 5;
    public static final int GET_MSG = 6;
    private static final int TURN_ON = 7;
    private static final int TURN_OFF = 8;

    private Button bt_send;
    private TextView tv_content;
    private TextView tv_send_text;
    private EditText ed_text;
    private WifiManager mWifiManager;
    private  int port = 54321;  //连接的端口
    private  String ip = "196.168.43.1";
    private ConnectThread mConnectThread;
    private ListenerThread mListenerThread;
    private InputStream  in;
    private DataInputStream mDataInputStream;
    Context mContext;

    /*
    handler信息处理
     */
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    tv_content.setText("wifi信息接收："+msg.obj);
                    Toast.makeText(MainActivity.this, "接收到信息", Toast.LENGTH_SHORT).show();
                    break;
                case 7:
                    statue.setText("状态：已经发送打开指令");
                    break;
                case 8:
                    statue.setText("状态：已经发送关闭指令");
                    break;
                case DEVICE_CONNECTING:
                    mConnectThread = new ConnectThread(mContext,mListenerThread.getSocket(), handler);
                    mConnectThread.start();
                    break;
                case DEVICE_CONNECTED:
                    tv_content.setText("设备连接成功");
                    break;
                case SEND_MSG_SUCCSEE:
                    tv_content.setText("发送消息成功:" + msg.getData().getString("MSG"));
                    break;
                case SEND_MSG_ERROR:
                    tv_content.setText("发送消息失败:" + msg.getData().getString("MSG"));
                    break;
                case GET_MSG:
                    tv_content.setText("收到消息:" + msg.getData().getString("MSG"));
                    break;
                default:
                    tv_content.setText("啥都没有");
                    break;
            }
        }
    };
    private Socket mSocket;
   private ServerSocket mserversocket;
    private Button turn_on;
    private Button turn_off;
    private TextView statue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initData();
    }

    /*
    初始化数据
     */
    private void initData() {
        mWifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if(!mWifiManager.isWifiEnabled()){

            mWifiManager.setWifiEnabled(true);

        }
        Toast.makeText(this, "请连接到设备的热点", Toast.LENGTH_SHORT).show();

//        Service mService = new Service();
//        mService.setHandler(handler);   //设置线程
//        new Thread(mService).start();   //开启线程
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    String str = String.valueOf("23234545");
//                    new SendAsyncTask().execute(str);
//                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();

    }



    /*
    初始化视图
     */
    private void initView() {
        statue = findViewById(R.id.statue);
        turn_on = findViewById(R.id.turn_on);
        turn_off = findViewById(R.id.turn_off);
        turn_on.setOnClickListener(this);
        turn_off.setOnClickListener(this);
//        bt_send = (Button)findViewById(R.id.bt_send);
//        tv_content = (TextView)findViewById(R.id.tv_content);
//        tv_send_text = (TextView)findViewById(R.id.tv_send_text);
//        ed_text = (EditText)findViewById(R.id.ed_text);
//        bt_send.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.turn_on:
                String str = "000000";
                char[] chars = str.toCharArray();
                StringBuffer hex = new StringBuffer();
                for(int i=0; i<chars.length;i++){
                    hex.append(Integer.toHexString(chars[i]));
                }
                new SendAsyncTask().execute(str);
                Message message = new Message();
                message.what = MainActivity.TURN_ON;
                handler.sendMessage(message);
                break;
            case R.id.turn_off:
                String str2 = "111111";
                char[] chars2 = str2.toCharArray();
                StringBuffer buffer2 = new StringBuffer();
                for(int i=0; i<chars2.length; i++){
                    buffer2.append(Integer.toHexString(chars2[i]));
                }
                new SendAsyncTask().execute(str2);
                Message message2 = new Message();
                message2.what = MainActivity.TURN_OFF;
                handler.sendMessage(message2);
                break;
//            case R.id.bt_send:
//                String str = String.valueOf(ed_text.getText());
////                char[] chars = str.toCharArray();
////                StringBuffer hex = new StringBuffer();
////                for(int i=0; i<chars.length; i++){
////                    hex.append(Integer.toHexString((int)chars[i]));
////                }
////                String strip = String.valueOf(ip.getText());
//                new SendAsyncTask().execute(str);  //开启异步
//                tv_send_text.setText(str);
//                break;
            default:
                break;
        }
    }
}
