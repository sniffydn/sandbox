package com.sniffydn.sandbox.core.subscription.service;

import com.sniffydn.sandbox.core.subscription.CustomerSubscription;
import com.sniffydn.sandbox.core.subscription.SeriesProductLink;
import com.sniffydn.sandbox.core.subscription.SubscriptionEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class SubscriptionService {

    private static SubscriptionService instance;
    private List<CustomerSubscription> subscriptions;
    private List<SeriesProductLink> seriesProductLinks;
    private List<SubscriptionEvent> subscriptionEvents;
    private Date currentDate;
    private static int seCount = 0;

    private SubscriptionService() {
    }

    public static SubscriptionService getInstance() {
        if (instance == null) {
            instance = new SubscriptionService();
            instance.subscriptionEvents = new ArrayList<>();
        }
        return instance;
    }

    public void createOrders() {
        //create orders and send out emails
    }

    public void createSubscriptionEvents() {
        Calendar subscriptionStartDate = new GregorianCalendar();
        Calendar splEndDate = new GregorianCalendar();

        for (CustomerSubscription subscription : subscriptions) {
            if (subscription.getStartDate().after(currentDate)) {

                subscriptionStartDate.setTime(subscription.getStartDate());

                for (SeriesProductLink spl : seriesProductLinks) {
                    if(spl.getSeriesId() == null && spl.getLinkId().equals(subscription.getSeriesProductLinkId())) {
                        if (spl.getLinkEndDate().after(subscription.getStartDate())) {

                            SubscriptionEvent se = new SubscriptionEvent();
                            se.setId(seCount++);
                            se.setProductId(spl.getProductId());

                            //figure out send by preferred date...
                            se.setSendByDate(spl.getLinkEndDate());

                            splEndDate.setTime(spl.getLinkEndDate());
                            splEndDate.set(Calendar.DAY_OF_MONTH, subscriptionStartDate.get(Calendar.DAY_OF_MONTH));
                            if(splEndDate.getTime().after(spl.getLinkEndDate())) {
                                splEndDate.add(Calendar.MONTH, -1);
                            }

                            if(splEndDate.getTime().before(spl.getLinkEndDate()) && splEndDate.getTime().after(spl.getLinkStartDate())) {
                                splEndDate.setTime(splEndDate.getTime());
                            }

                            se.setStatus("Active");
                            se.setSubscriptionId(subscription.getId());
                            subscriptionEvents.add(se);
                        }
                    } else if (spl.getSeriesId() != null && spl.getSeriesId().equals(subscription.getSeriesId())) {
                        if (spl.getLinkEndDate().after(subscription.getStartDate())) {

                            SubscriptionEvent se = new SubscriptionEvent();
                            se.setId(seCount++);
                            se.setProductId(spl.getProductId());

                            //figure out send by preferred date...
                            se.setSendByDate(spl.getLinkEndDate());

                            splEndDate.setTime(spl.getLinkEndDate());
                            splEndDate.set(Calendar.DAY_OF_MONTH, subscriptionStartDate.get(Calendar.DAY_OF_MONTH));
                            if(splEndDate.getTime().after(spl.getLinkEndDate())) {
                                splEndDate.add(Calendar.MONTH, -1);
                            }

                            if(splEndDate.getTime().before(spl.getLinkEndDate()) && splEndDate.getTime().after(spl.getLinkStartDate())) {
                                splEndDate.setTime(splEndDate.getTime());
                            }

                            se.setStatus("Active");
                            se.setSubscriptionId(subscription.getId());
                            subscriptionEvents.add(se);
                        }
                    }
                }
            }
        }
    }

    /**
     * @return the subscriptions
     */
    public List<CustomerSubscription> getSubscriptions() {
        return subscriptions;
    }

    /**
     * @param subscriptions the subscriptions to set
     */
    public void setSubscriptions(List<CustomerSubscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    /**
     * @return the seriesProductLinks
     */
    public List<SeriesProductLink> getSeriesProductLinks() {
        return seriesProductLinks;
    }

    /**
     * @param seriesProductLinks the seriesProductLinks to set
     */
    public void setSeriesProductLinks(List<SeriesProductLink> seriesProductLinks) {
        this.seriesProductLinks = seriesProductLinks;
    }

    /**
     * @return the subscriptionEvents
     */
    public List<SubscriptionEvent> getSubscriptionEvents() {
        return subscriptionEvents;
    }

    /**
     * @param subscriptionEvents the subscriptionEvents to set
     */
    public void setSubscriptionEvents(List<SubscriptionEvent> subscriptionEvents) {
        this.subscriptionEvents = subscriptionEvents;
    }

    /**
     * @return the currentDate
     */
    public Date getCurrentDate() {
        return currentDate;
    }

    /**
     * @param currentDate the currentDate to set
     */
    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
}
