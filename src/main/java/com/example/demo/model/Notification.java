package com.example.demo.model;

public class Notification {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTIFICATION.ID
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTIFICATION.NOTIFIER
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    private Long notifier;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTIFICATION.RECEIVER
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    private Long receiver;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTIFICATION.OUTERID
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    private Long outerid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTIFICATION.TYPE
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    private Integer type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTIFICATION.GMT_CREATE
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTIFICATION.STATUS
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTIFICATION.OUTER_TITLE
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    private String outerTitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column NOTIFICATION.NOTIFIER_NAME
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    private String notifierName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTIFICATION.ID
     *
     * @return the value of NOTIFICATION.ID
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTIFICATION.ID
     *
     * @param id the value for NOTIFICATION.ID
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTIFICATION.NOTIFIER
     *
     * @return the value of NOTIFICATION.NOTIFIER
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    public Long getNotifier() {
        return notifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTIFICATION.NOTIFIER
     *
     * @param notifier the value for NOTIFICATION.NOTIFIER
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    public void setNotifier(Long notifier) {
        this.notifier = notifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTIFICATION.RECEIVER
     *
     * @return the value of NOTIFICATION.RECEIVER
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    public Long getReceiver() {
        return receiver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTIFICATION.RECEIVER
     *
     * @param receiver the value for NOTIFICATION.RECEIVER
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    public void setReceiver(Long receiver) {
        this.receiver = receiver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTIFICATION.OUTERID
     *
     * @return the value of NOTIFICATION.OUTERID
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    public Long getOuterid() {
        return outerid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTIFICATION.OUTERID
     *
     * @param outerid the value for NOTIFICATION.OUTERID
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    public void setOuterid(Long outerid) {
        this.outerid = outerid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTIFICATION.TYPE
     *
     * @return the value of NOTIFICATION.TYPE
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTIFICATION.TYPE
     *
     * @param type the value for NOTIFICATION.TYPE
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTIFICATION.GMT_CREATE
     *
     * @return the value of NOTIFICATION.GMT_CREATE
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTIFICATION.GMT_CREATE
     *
     * @param gmtCreate the value for NOTIFICATION.GMT_CREATE
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTIFICATION.STATUS
     *
     * @return the value of NOTIFICATION.STATUS
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTIFICATION.STATUS
     *
     * @param status the value for NOTIFICATION.STATUS
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTIFICATION.OUTER_TITLE
     *
     * @return the value of NOTIFICATION.OUTER_TITLE
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    public String getOuterTitle() {
        return outerTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTIFICATION.OUTER_TITLE
     *
     * @param outerTitle the value for NOTIFICATION.OUTER_TITLE
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    public void setOuterTitle(String outerTitle) {
        this.outerTitle = outerTitle == null ? null : outerTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column NOTIFICATION.NOTIFIER_NAME
     *
     * @return the value of NOTIFICATION.NOTIFIER_NAME
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    public String getNotifierName() {
        return notifierName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column NOTIFICATION.NOTIFIER_NAME
     *
     * @param notifierName the value for NOTIFICATION.NOTIFIER_NAME
     *
     * @mbg.generated Fri Feb 11 18:21:49 CST 2022
     */
    public void setNotifierName(String notifierName) {
        this.notifierName = notifierName == null ? null : notifierName.trim();
    }
}