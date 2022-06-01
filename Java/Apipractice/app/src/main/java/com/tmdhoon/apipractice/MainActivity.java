package com.tmdhoon.apipractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    EditText edit;
    TextView text;
    XmlPullParser xpp;

    String key = "iqtjLS3HEpGtUS15TyOeiyDbdsV+iOqnGLT25kLmdybcppa7YL7Fw5wMoqougDkXqSrqTbXYi3I4Vb8E4iXvyw=="; // 서비스 키
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = (EditText)findViewById(R.id.edit);
        text = (TextView)findViewById(R.id.result);
    }
    public void mOnClick(View view){
        switch(view.getId()){
            case R.id.button:
                new Thread(new Runnable() {                                                                         // 쓰레드
                    @Override
                    public void run() {
                        data=getXmlData();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                text.setText(data);
                            }
                        });
                    }
                }).start();
                break;
        }
    }
    String getXmlData(){
        StringBuffer buffer = new StringBuffer();
        String str = edit.getText().toString();
        String location = URLEncoder.encode(str);
        String query = "%EC%A0%84%EB%A0%A5%EB%A1%9C";

        String queryUrl = "http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList?addr="+location+"&pageNo=1&numOfRows=10&ServiceKey=iqtjLS3HEpGtUS15TyOeiyDbdsV+iOqnGLT25kLmdybcppa7YL7Fw5wMoqougDkXqSrqTbXYi3I4Vb8E4iXvyw=="; // 서비스 키
        try{
            URL url = new URL(queryUrl);
            InputStream is = url.openStream();

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(is, "UTF-8"));

            String tag;

            xpp.next();
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT){
                switch (eventType){
                    case XmlPullParser.START_DOCUMENT:
                        buffer.append("파싱 시작...\n\n");
                        break;

                    case XmlPullParser.START_TAG:
                        tag = xpp.getName();

                        if(tag.equals("item"));
                        else if(tag.equals("addr")){
                            buffer.append("주소 : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("chargeTp")){
                            buffer.append("충전소 타입 : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("cpId")){
                            buffer.append("충전소ID : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("cpNm")){
                            buffer.append("충전소 명칭 : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("cpStat")){
                            buffer.append("충전소 상태 코드 : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("cpTp")){
                            buffer.append("충전 방식 : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("csId")){
                            buffer.append("충전소 ID : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("cpNm")){
                            buffer.append("충전소 명칭 : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("lat")){
                            buffer.append("위도 : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("longi")){
                            buffer.append("경도 : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        else if(tag.equals("statUpdateDatetime")){
                            buffer.append("충전기상태갱신시각 : ");
                            xpp.next();
                            buffer.append(xpp.getText());
                            buffer.append("\n");
                        }
                        break;

                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag = xpp.getName();

                        if(tag.equals("item")) buffer.append("\n");
                        break;
                }

                eventType = xpp.next();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        buffer.append("파싱 끝\n");
        return buffer.toString();
    }
}