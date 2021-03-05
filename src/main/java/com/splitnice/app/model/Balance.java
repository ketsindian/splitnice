package com.splitnice.app.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "balance_d")
public class Balance {

    @Id
    @GeneratedValue
    private long balance_id;

    @ManyToOne
    @JoinColumn(name = "user_borrower", referencedColumnName = "user_id")
    private User user_borrower;

    @ManyToOne
    @JoinColumn(name = "user_lender", referencedColumnName = "user_id",updatable = false)
    private User user_lender;

    private long amount;

    @UpdateTimestamp
    private Date updated_ts;

    @CreationTimestamp
    private Date created_ts;
}
