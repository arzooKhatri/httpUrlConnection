package com.apiCall.apiCall.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

    private String MobileNo;
    private String City;
    private String ContactPerson;
    private String EmailId;
    private String CompanyName;
    private String LoginID;
}
