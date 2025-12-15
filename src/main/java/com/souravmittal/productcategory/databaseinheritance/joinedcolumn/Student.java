package com.souravmittal.productcategory.databaseinheritance.joinedcolumn;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jc_student")
@PrimaryKeyJoinColumn(name = "user_id")
public class Student extends User {

    private String batch;
}
