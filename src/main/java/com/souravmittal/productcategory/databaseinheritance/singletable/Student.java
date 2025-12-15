package com.souravmittal.productcategory.databaseinheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_student")
@DiscriminatorValue(value = "STUDENT")
public class Student extends User {

    private String batch;
}
