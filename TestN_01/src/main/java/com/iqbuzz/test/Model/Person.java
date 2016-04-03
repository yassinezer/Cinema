package com.iqbuzz.test.Model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  int persID; 
	
	@Column(name="name" , length = 50 )
    private String name;
     
    @Column(name="familly"  , length = 50 )
    private String familly;
    
    @Column(name="second_familly" , length = 50 )
    private String second_familly;
    
    @OneToOne(cascade=CascadeType.ALL, mappedBy="person", fetch = FetchType.EAGER)
    private Info_Buy info_buy;
    
	public Person() {
		super();
	}

	public Person(String name, String familly, String second_familly) {
		this.name = name;
		this.familly= familly;
		this.second_familly= second_familly;
	}
	public int getPersID() {
		return persID;
	}

	public void setPersID(int persID) {
		this.persID = persID;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamilly() {
		return familly;
	}

	public void setFamilly(String familly) {
		this.familly = familly;
	}

	public String getSecond_familly() {
		return second_familly;
	}

	public void setSecond_familly(String second_familly) {
		this.second_familly = second_familly;
	}

	public Info_Buy getInfo_buy() {
		return info_buy;
	}

	public void setInfo_buy(Info_Buy info_buy) {
		this.info_buy = info_buy;
	}
    
}
