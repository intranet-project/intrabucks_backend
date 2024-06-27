package com.intrabucks.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Customer")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_sequence")
	@SequenceGenerator(name = "cust_sequence", sequenceName = "cust_sequence", allocationSize = 1)
	@Column(name = "cust_id")
	private Long custId;

    @Column(name = "cust_name")
    private String custName;

    @Column(name = "cust_password")
    private String custPassword;

    @Column(name = "cust_email", unique = true)
    private String custEmail;

    @Column(name = "cust_phone")
    private String custPhone;

    @Column(name = "cust_created_at")
    @Temporal(TemporalType.DATE)
    private Date custCreatedAt;

    @Column(name = "cust_gender", length = 10)
    private String custGender;

    @Column(name = "cust_age")
    private Integer custAge;


}
