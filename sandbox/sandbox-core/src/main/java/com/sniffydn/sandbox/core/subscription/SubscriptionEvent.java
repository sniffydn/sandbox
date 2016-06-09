
package com.sniffydn.sandbox.core.subscription;

import java.util.Date;

public class SubscriptionEvent {
       private Integer id;
       private Integer subscriptionId;
       private String productId;
       private Date sendByDate;
       private String orderId;
       private String status;
       private Date productionDate;
       private Date shippedDate;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the subscriptionId
     */
    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    /**
     * @param subscriptionId the subscriptionId to set
     */
    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    /**
     * @return the productId
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * @return the sendByDate
     */
    public Date getSendByDate() {
        return sendByDate;
    }

    /**
     * @param sendByDate the sendByDate to set
     */
    public void setSendByDate(Date sendByDate) {
        this.sendByDate = sendByDate;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
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
     * @return the productionDate
     */
    public Date getProductionDate() {
        return productionDate;
    }

    /**
     * @param productionDate the productionDate to set
     */
    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    /**
     * @return the shippedDate
     */
    public Date getShippedDate() {
        return shippedDate;
    }

    /**
     * @param shippedDate the shippedDate to set
     */
    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }
}
