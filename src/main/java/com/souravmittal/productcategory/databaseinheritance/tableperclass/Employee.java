package com.souravmittal.productcategory.databaseinheritance.tableperclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_employee")
public class Employee extends User {

    private long salary;
}
