/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author trida
 */
public class UserError {
    String AccError;
    String EmailError;
    String PassError;
    String PhoneError;

    public UserError() {
        this.AccError ="";
        this.EmailError="";
        this.PassError="";
        this.PhoneError="";
    }
    
    public UserError(String AccError, String EmailError) {
        this.AccError = AccError;
        this.EmailError = EmailError;
        this.PassError = PassError;
        this.PhoneError = PhoneError;
    }

    public String getAccError() {
        return AccError;
    }

    public void setAccError(String AccError) {
        this.AccError = AccError;
    }

    public String getEmailError() {
        return EmailError;
    }

    public void setEmailError(String EmailError) {
        this.EmailError = EmailError;
    }

    public String getPassError() {
        return PassError;
    }

    public void setPassError(String PassError) {
        this.PassError = PassError;
    }

    public String getPhoneError() {
        return PhoneError;
    }

    public void setPhoneError(String PhoneError) {
        this.PhoneError = PhoneError;
    }
    
    
}