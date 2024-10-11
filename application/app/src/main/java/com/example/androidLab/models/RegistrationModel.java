package com.example.androidLab.models;

public class RegistrationModel {
    private String username;
    private String password;
    private String emailAddress;
    private String phoneNumber;
    private String country;
    private String region;
    private String province;
    private String gender;
    private String interest;
    private String birthDate;
    private String birthTime;


    public RegistrationModel() { }

    public RegistrationModel(String username,     String password,
                             String emailAddress, String phoneNumber,
                             String country,      String region,
                             String province,     String gender,
                             String interest,     String birthDate,
                             String birthTime)
    {
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.region = region;
        this.province = province;
        this.gender = gender;
        this.interest = interest;
        this.birthDate = birthDate;
        this.birthTime = birthTime;
    }

    public String getUsername()     { return username;     }
    public String getPassword()     { return password;     }
    public String getEmailAddress() { return emailAddress; }
    public String getPhoneNumber()  { return phoneNumber;  }
    public String getCountry()      { return country;      }
    public String getRegion()       { return  region;      }
    public String getProvince()     { return province;     }
    public String getGender()       { return gender;       }
    public String getInterest()     { return interest;     }
    public String getBirthDate()    { return birthDate;    }
    public String getBirthTime()    { return birthTime;    }

    public void setUsername(String username)         { this.username = username;         }
    public void setPassword(String password)         { this.password = password;         }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }
    public void setPhoneNumber(String phoneNumber)   { this.phoneNumber = phoneNumber;   }
    public void setCountry(String country)           { this.country = country;           }
    public void setRegion(String region)             { this.region = region;             }
    public void setProvince(String province)         { this.province = province;         }
    public void setGender(String gender)             { this.gender = gender;             }
    public void setInterest(String interest)         { this.interest = interest;         }
    public void setBirthDate(String birthDate)       { this.birthDate = birthDate;       }
    public void setBirthTime(String birthTime)       { this.birthTime = birthTime;       }
}
