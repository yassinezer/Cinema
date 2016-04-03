package com.iqbuzz.test.Model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Info_Buy implements Serializable {
    
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name="persID", unique=true, nullable=false)
    @GeneratedValue(generator="gen")
    @GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="person"))
	private int persID;
    @Column(name="price" , length = 10 , nullable= false)
	private int price;
    @Column(name="ccn" , length = 14 )
	private Long ccn;
    @Column(name="paid" , length = 10 , nullable= false, columnDefinition="boolean default false")
	private boolean paid;
    @OneToOne(cascade= CascadeType.REMOVE)
    @PrimaryKeyJoinColumn
    private Person person;
    
    public Info_Buy(){
    	super();
    }
	public Info_Buy(int price, Long ccn, boolean paid) {
		this.price = price;
		this.ccn = ccn;
		this.paid = paid;
	}
	public int getPersID() {
		return persID;
	}
	public void setPersID(int persID) {
		this.persID = persID;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Long getCcn() {
		return ccn;
	}
	public void setCcn(Long ccn) {
		this.ccn = ccn;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	
	
	
}
