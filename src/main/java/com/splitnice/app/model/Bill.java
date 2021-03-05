package com.splitnice.app.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "bill_d")
public class Bill {

    @Id
    @GeneratedValue
    private long bill_id;

    private String bill_title;

    @UpdateTimestamp
    private Date updated_ts;

    @CreationTimestamp
    private Date created_ts;
}
