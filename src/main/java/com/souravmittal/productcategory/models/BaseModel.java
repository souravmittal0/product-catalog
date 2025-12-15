package com.souravmittal.productcategory.models;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {

    @Id
    private long id;

    private Date createdAt;

    private Date modifiedAt;

    @Enumerated(EnumType.ORDINAL)
    private State state;
}
