package com.MedAccess.Models;

public class BusinessLogic {
    private String logic_id;
    private String email_pattern;
    private String password_pattern;
    private String phone_pattern;
    private String zipcode_pattern;
    private String suite_pattern;




    public BusinessLogic() {}

    public BusinessLogic(String logic_id, String email_pattern, String password_pattern, String phone_pattern, String zipcode_pattern, String suite_pattern) {
        this.logic_id = logic_id;
        this.email_pattern = email_pattern;
        this.password_pattern = password_pattern;
        this.phone_pattern = phone_pattern;
        this.zipcode_pattern = zipcode_pattern;
        this.suite_pattern = suite_pattern;
    }


    public String getLogic_id() {
        return logic_id;
    }

    public void setLogic_id(String logic_id) {
        this.logic_id = logic_id;
    }

    public String getEmail_pattern() {
        return email_pattern;
    }

    public void setEmail_pattern(String email_pattern) {
        this.email_pattern = email_pattern;
    }

    public String getPassword_pattern() {
        return password_pattern;
    }

    public void setPassword_pattern(String password_pattern) {
        this.password_pattern = password_pattern;
    }

    public String getPhone_pattern() {
        return phone_pattern;
    }

    public void setPhone_pattern(String phone_pattern) {
        this.phone_pattern = phone_pattern;
    }

    public String getZipcode_pattern() {
        return zipcode_pattern;
    }

    public void setZipcode_pattern(String zipcode_pattern) {
        this.zipcode_pattern = zipcode_pattern;
    }

    public String getSuite_pattern() {
        return suite_pattern;
    }

    public void setSuite_pattern(String suite_pattern) {
        this.suite_pattern = suite_pattern;
    }



}
