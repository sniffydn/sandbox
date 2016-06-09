
package com.sniffydn.sandbox.core.subscription;

import java.util.Date;

public class SeriesProductLink {
    private Integer linkId;
    private String seriesId;
    private String productId;
    private Integer linkSequence;
    private Date linkStartDate;
    private Date linkEndDate;
    private Date templateReadyDate;

    /**
     * @return the linkId
     */
    public Integer getLinkId() {
        return linkId;
    }

    /**
     * @param linkId the linkId to set
     */
    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
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
     * @return the linkSequence
     */
    public Integer getLinkSequence() {
        return linkSequence;
    }

    /**
     * @param linkSequence the linkSequence to set
     */
    public void setLinkSequence(Integer linkSequence) {
        this.linkSequence = linkSequence;
    }

    /**
     * @return the linkStartDate
     */
    public Date getLinkStartDate() {
        return linkStartDate;
    }

    /**
     * @param linkStartDate the linkStartDate to set
     */
    public void setLinkStartDate(Date linkStartDate) {
        this.linkStartDate = linkStartDate;
    }

    /**
     * @return the linkEndDate
     */
    public Date getLinkEndDate() {
        return linkEndDate;
    }

    /**
     * @param linkEndDate the linkEndDate to set
     */
    public void setLinkEndDate(Date linkEndDate) {
        this.linkEndDate = linkEndDate;
    }

    /**
     * @return the templateReadyDate
     */
    public Date getTemplateReadyDate() {
        return templateReadyDate;
    }

    /**
     * @param templateReadyDate the templateReadyDate to set
     */
    public void setTemplateReadyDate(Date templateReadyDate) {
        this.templateReadyDate = templateReadyDate;
    }
}
