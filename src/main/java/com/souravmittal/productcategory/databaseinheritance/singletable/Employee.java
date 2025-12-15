package com.souravmittal.productcategory.databaseinheritance.singletable;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_employee")
@DiscriminatorValue(value = "EMPLOYEE")
//@DiscriminatorValue(value = "STUDENT")  //error
public class Employee extends User {

    private long salary;
}
