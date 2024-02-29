package com.slava.snake.dto;

import com.slava.snake.collection.TrafficByAsin;
import lombok.Getter;

@Getter
public class CollectedStatisticTrafficByAsin {

    long browserSessions;

    long browserSessionsB2B;

    long mobileAppSessions;

    long mobileAppSessionsB2B;

    long sessions;

    long sessionsB2B;

    long browserPageViews;

    long browserPageViewsB2B;

    long mobileAppPageViews;

    long mobileAppPageViewsB2B;

    long pageViews;

    long pageViewsB2B;


    public void amount(TrafficByAsin t) {
        this.browserSessions += t.getBrowserSessions();
        this.browserSessionsB2B += t.getBrowserSessionsB2B();
        this.mobileAppSessions += t.getMobileAppSessions();
        this.mobileAppSessionsB2B += t.getMobileAppSessionsB2B();
        this.sessions += t.getSessions();
        this.sessionsB2B += t.getSessionsB2B();
        this.browserPageViews += t.getBrowserPageViews();
        this.browserPageViewsB2B += t.getBrowserPageViewsB2B();
        this.mobileAppPageViews += t.getMobileAppPageViews();
        this.mobileAppPageViewsB2B += t.getMobileAppPageViewsB2B();
        this.pageViews += t.getPageViews();
        this.pageViewsB2B += t.getPageViewsB2B();
    }


    public void average(long count) {
        // certain fields divide by count
    }

}
