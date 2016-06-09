package com.sniffydn.sandbox.core.subscription;

import com.sniffydn.sandbox.core.subscription.service.SubscriptionService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author dnyffeler
 */
public class SubscriptionTester {

    public static final SimpleDateFormat format = new SimpleDateFormat("MMM d yyyy");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<SeriesProductLink> seriesProductLinks = new ArrayList<>();
        Calendar c = new GregorianCalendar(2016, 1, 1);
        int linkId = 0;
        for (int i = 0; i < 12; i++) {
            SeriesProductLink spl = new SeriesProductLink();
            spl.setLinkId(++linkId);
            spl.setSeriesId("Plain Postcards");
            spl.setProductId("Plain Postcard " + i);
            spl.setLinkSequence(i);

            c.add(Calendar.DAY_OF_MONTH, -1);
            spl.setLinkEndDate(c.getTime());

            c.set(Calendar.DAY_OF_MONTH, 1);
            spl.setLinkStartDate(c.getTime());

            c.add(Calendar.MONTH, -1);
            spl.setTemplateReadyDate(c.getTime());

            c.add(Calendar.MONTH, 3);

            seriesProductLinks.add(spl);
        }

        c.set(2016, 1, 15);
        for (int i = 0; i < 12; i++) {
            SeriesProductLink spl = new SeriesProductLink();
            spl.setLinkId(++linkId);
            spl.setSeriesId("Pretty Postcards");
            spl.setProductId("Pretty Postcard " + i);
            spl.setLinkSequence(i);

            spl.setLinkEndDate(c.getTime());

            c.add(Calendar.MONTH, -1);
            c.add(Calendar.DAY_OF_MONTH, 1);
            spl.setLinkStartDate(c.getTime());

            c.add(Calendar.MONTH, -1);
            spl.setTemplateReadyDate(c.getTime());

            c.add(Calendar.MONTH, 3);
            c.add(Calendar.DAY_OF_MONTH, -1);

            seriesProductLinks.add(spl);
        }

            SeriesProductLink standAloneLink = new SeriesProductLink();
            standAloneLink.setLinkId(++linkId);
            standAloneLink.setSeriesId(null);
            standAloneLink.setProductId("Stand alone subscribable product");
            standAloneLink.setLinkSequence(null);

            standAloneLink.setLinkEndDate(c.getTime());

            c.add(Calendar.MONTH, -1);
            c.add(Calendar.DAY_OF_MONTH, 1);
            standAloneLink.setLinkStartDate(c.getTime());

            c.add(Calendar.MONTH, -1);
            standAloneLink.setTemplateReadyDate(c.getTime());

            c.add(Calendar.MONTH, 3);
            c.add(Calendar.DAY_OF_MONTH, -1);

            seriesProductLinks.add(standAloneLink);

        for (SeriesProductLink spl : seriesProductLinks) {
            System.out.println("\n\nLink Id: " + spl.getLinkId());
            System.out.println("Series Id: " + spl.getSeriesId());
            System.out.println("Product Id: " + spl.getProductId());
            System.out.println("Sequence: " + spl.getLinkSequence());
            System.out.println("End Date: " + format.format(spl.getLinkEndDate()));
            System.out.println("Start Date: " + format.format(spl.getLinkStartDate()));
            System.out.println("Template Ready Date: " + format.format(spl.getTemplateReadyDate()));
        }

        List<CustomerSubscription> subscriptions = new ArrayList<>();
        CustomerSubscription subscription = new CustomerSubscription();
        subscription.setCustomerId("Johnny");
        subscription.setListId("Purchased List 1");
        subscription.setListKey("Purchased List 1 Key");
        subscription.setPreferredSendDay(5);
        subscription.setSeriesProductLinkId(null);
        subscription.setSeriesId("Plain Postcards");
        c.set(2016, 4, 7);
        subscription.setStartDate(c.getTime());
        subscription.setStatus("Active");
        subscriptions.add(subscription);

        subscription = new CustomerSubscription();
        subscription.setCustomerId("Johnny");
        subscription.setListId(null);
        subscription.setListKey(null);
        subscription.setPreferredSendDay(15);
        subscription.setSeriesProductLinkId(standAloneLink.getLinkId());
        subscription.setSeriesId(null);
        c.set(2016, 2, 7);
        subscription.setStartDate(c.getTime());
        subscription.setStatus("Active");
        subscriptions.add(subscription);

        subscription = new CustomerSubscription();
        subscription.setCustomerId("Johnny");
        subscription.setListId("User List 1");
        subscription.setListKey("User List 1 Key");
        subscription.setPreferredSendDay(7);
        subscription.setSeriesProductLinkId(null);
        subscription.setSeriesId("Pretty Postcards");
        c.set(2016, 1, 1);
        subscription.setStartDate(c.getTime());
        subscription.setStatus("Active");
        subscriptions.add(subscription);

        System.out.println("\n\n\nSubscriptions:---------------------------------------------------");
        for (CustomerSubscription sub : subscriptions) {
            System.out.println("\n\nSubscription Id: " + sub.getId());
            System.out.println("Customer: " + sub.getCustomerId());
            System.out.println("List: " + sub.getListId());
            System.out.println("Link Id: " + sub.getSeriesProductLinkId());
            System.out.println("Series: " + sub.getSeriesId());
            System.out.println("Preferred Send Day: " + sub.getPreferredSendDay());
            System.out.println("Status: " + sub.getStatus());
            System.out.println("Start Date: " + format.format(sub.getStartDate()));
        }


        //Fill out Subscription Event Subscription Service
        SubscriptionService ss = SubscriptionService.getInstance();
        ss.setSubscriptions(subscriptions);
        ss.setSeriesProductLinks(seriesProductLinks);
        c.set(2016, 1, 1);
        ss.setCurrentDate(c.getTime());
        
        ss.createSubscriptionEvents();

        System.out.println("\n\nCurrent Date: " + format.format(c.getTime()));
        System.out.println("\n\n\nSubscription Event:---------------------------------------------------");
        for(SubscriptionEvent se: ss.getSubscriptionEvents()) {
            System.out.println("\n\nSubscription Event Id: " + se.getId());
            System.out.println("Status: " + se.getStatus());
            System.out.println("Product: " + se.getProductId());
            System.out.println("SendByDate: " + format.format(se.getSendByDate()));
            System.out.println("Subscription: " + se.getSubscriptionId());
        }

    }


}
