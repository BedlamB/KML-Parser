package com.example;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

public class KMLHandler2 {
    private XmlResourceParser xpp;
    private ArrayList<Location> locations = new ArrayList<Location>();
    private Context context;

    public KMLHandler2(Context context){
        this.context = context;
    }

    public ArrayList<Location> getParsedItems() throws IOException, XmlPullParserException {
        try {
            getAllXML();
        } catch (XmlPullParserException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return locations;
    }

    public void getAllXML() throws XmlPullParserException, IOException {
        Resources res = context.getResources();
        xpp = res.getXml(R.xml.purple);
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if(eventType == XmlPullParser.START_TAG){
                if(xpp.getName().equals("coordinates")){


                    // convert to doubles

                    String s = xpp.nextText();
                    String[] tokens = s.split(",");
                    String lat = tokens[1];
                    String lon = tokens[0];
                    double d = Double.valueOf(lat.trim()).doubleValue();
                    double d2 = Double.valueOf(lon.trim()).doubleValue();
                    Location l = new Location(d, d2);  //longitude first in KML
                    locations.add(l);

                }
            }
            eventType = xpp.next();
        }


    }

}
