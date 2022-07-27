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
    String dateError, hourError, skillError;
    public RequestError(){
        this.dateError = "";
        this.hourError = "";
        this.skillError = "";
        
        
    }

    public RequestError(String dateError, String hourError, String skillError) {
        this.dateError = dateError;
        this.hourError = hourError;
        this.skillError = skillError;
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
