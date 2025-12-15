package com.souravmittal.productcategory.databaseinheritance.joinedcolumn;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jc_employee")
//@PrimaryKeyJoinColumn(name = "user_id") //foreign key column will be id
public class Employee extends User {

    private long salary;
}
