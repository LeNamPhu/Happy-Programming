/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author ThienNho
 */
public class RequestError {
    String dateError, hourError, skillError,titleError, contentError;
    public RequestError(){
        this.dateError = "";
        this.hourError = "";
        this.skillError = "";
        this.titleError = "";
        this.contentError = "";
        
    }

    public RequestError(String dateError, String hourError, String skillError, String titleError, String contentError) {
        this.dateError = dateError;
        this.hourError = hourError;
        this.skillError = skillError;
        this.titleError = titleError;
        this.contentError = contentError;
    }

    public String getTitleError() {
        return titleError;
    }

    public void setTitleError(String titleError) {
        this.titleError = titleError;
    }

    public String getContentError() {
        return contentError;
    }

    public void setContentError(String contentError) {
        this.contentError = contentError;
    }

   

    public String getDateError() {
        return dateError;
    }

    public void setDateError(String dateError) {
        this.dateError = dateError;
    }

    public String getHourError() {
        return hourError;
    }

    public void setHourError(String hourError) {
        this.hourError = hourError;
    }

    public String getSkillError() {
        return skillError;
    }

    public void setSkillError(String skillError) {
        this.skillError = skillError;
    }
    
    
}
