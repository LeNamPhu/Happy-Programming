/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author admin
 */
public class Request {
    private int id;
    private String title;
    private String status;
    private String content;
    private int menteeID;
    private Date deadlineDate;
    private int deadlineHour;
    private Date createdDate;

    public Request(int id, String title, String status, String content, int menteeID, Date deadlineDate, int deadlineHour, Date createdDate) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.content = content;
        this.menteeID = menteeID;
        this.deadlineDate = deadlineDate;
        this.deadlineHour = deadlineHour;
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMenteeID() {
        return menteeID;
    }

    public void setMenteeID(int menteeID) {
        this.menteeID = menteeID;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public int getDeadlineHour() {
        return deadlineHour;
    }

    public void setDeadlineHour(int deadlineHour) {
        this.deadlineHour = deadlineHour;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    
}
