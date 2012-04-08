package com.example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

public class MyActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView myXmlContent = (TextView)findViewById(R.id.xml_tv);
        String str = null;
        ArrayList<Location> locations =  null;

        KMLHandler2 han2 = new KMLHandler2(this);

        try {
            locations = han2.getParsedItems();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        for(Location location: locations){
            str += " ";
            str += location.getLat();
            str += ",";
            str += location.getLon();
        }
        myXmlContent.setText(str);
    }

}
