package com.slava.snake.collection;

import lombok.Data;

@Data
public class TrafficByDate {

    long browserPageViews;

    long browserPageViewsB2B;

    long mobileAppPageViews;

    long mobileAppPageViewsB2B;

    long pageViews;

    long pageViewsB2B;

    long browserSessions;

    long browserSessionsB2B;

    long mobileAppSessions;

    long mobileAppSessionsB2B;

    long sessions;

    long sessionsB2B;

    double buyBoxPercentage;

    double buyBoxPercentageB2B;

    double orderItemSessionPercentage;

    double orderItemSessionPercentageB2B;

    double unitSessionPercentage;

    double unitSessionPercentageB2B;

    double averageOfferCount;

    double averageParentItems;

    long feedbackReceived;

    long negativeFeedbackReceived;

    double receivedNegativeFeedbackRate;

}
