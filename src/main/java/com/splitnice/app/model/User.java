package com.splitnice.app.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "user_d")
public class User implements Serializable {
    @Id
    @GeneratedValue
    private long user_id;

    @NonNull
    private String name;

    @UpdateTimestamp
    private Date updated_ts;

    @CreationTimestamp
    private Date created_ts;
}
