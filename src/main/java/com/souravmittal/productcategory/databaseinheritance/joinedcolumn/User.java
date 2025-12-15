package com.souravmittal.productcategory.databaseinheritance.joinedcolumn;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity(name = "jc_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    private UUID id;

    private String name;
}
