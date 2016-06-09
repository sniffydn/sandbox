
package com.sniffydn.sandbox.core.subscription;

import java.util.Date;

public class CustomerSubscription {
    private Integer id;
    private String customerId;
    private String seriesId;
    private String status;
    private Integer preferredSendDay;
    private Integer seriesProductLinkId;
    private String listId;
    private String listKey;
    private Date startDate;

    public static int idSequence = 0;
    public CustomerSubscription() {
        idSequence++;
        id = idSequence;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the seriesId
     */
    public String getSeriesId() {
        return seriesId;
    }

    /**
     * @param seriesId the seriesId to set
     */
    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the preferredSendDay
     */
    public Integer getPreferredSendDay() {
        return preferredSendDay;
    }

    /**
     * @param preferredSendDay the preferredSendDay to set
     */
    public void setPreferredSendDay(Integer preferredSendDay) {
        this.preferredSendDay = preferredSendDay;
    }

    /**
     * @return the listId
     */
    public String getListId() {
        return listId;
    }

    /**
     * @param listId the listId to set
     */
    public void setListId(String listId) {
        this.listId = listId;
    }

    /**
     * @return the listKey
     */
    public String getListKey() {
        return listKey;
    }

    /**
     * @param listKey the listKey to set
     */
    public void setListKey(String listKey) {
        this.listKey = listKey;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the seriesProductLinkId
     */
    public Integer getSeriesProductLinkId() {
        return seriesProductLinkId;
    }

    /**
     * @param seriesProductLinkId the seriesProductLinkId to set
     */
    public void setSeriesProductLinkId(Integer seriesProductLinkId) {
        this.seriesProductLinkId = seriesProductLinkId;
    }
}
