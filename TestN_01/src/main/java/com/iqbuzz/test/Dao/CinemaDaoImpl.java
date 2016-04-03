package com.iqbuzz.test.Dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iqbuzz.test.Model.Info_Buy;
import com.iqbuzz.test.Model.Person;

@Repository
@Transactional(rollbackFor =Exception.class)

public class CinemaDaoImpl implements CinemaDao {

    private SessionFactory sessionFactory;
    
    @Autowired
    public CinemaDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public int setPerson(String name, String familly, String second_familly, int price) {
		Person pers = new Person(name, familly, second_familly);
		Info_Buy info_buy = new Info_Buy();
		info_buy.setPrice(price);
		info_buy.setPerson(pers);
		pers.setInfo_buy(info_buy);
		return (Integer)sessionFactory.getCurrentSession().save(pers);
	}

	@Override
	public void clear() {
		sessionFactory.getCurrentSession().createSQLQuery("truncate table Person").executeUpdate();
	}


	@Override
	public void checkbook(int id) {
		 sessionFactory.getCurrentSession().createSQLQuery("delete from Info_Buy where persID = :persID and paid = :paid")
		.setInteger("persID", id).setBoolean("paid", false).executeUpdate();
	}

	@Override
	public String buy(int id, Long ccn) {
		Info_Buy info_buy = (Info_Buy) sessionFactory.getCurrentSession().get(Info_Buy.class, id);
		//if there is id much in DB
		if(info_buy!=null){
		if(info_buy.isPaid())return "You Are Already bought your ticket!";
		else {
		info_buy.setCcn(ccn);
		info_buy.setPaid(true);
		sessionFactory.getCurrentSession().saveOrUpdate(info_buy);
		return "You Have registered Successfully in our DB! Enjoy Watching!";
		}
		}
		else {
			return "There is No Booking With This ID Number";
		}
	}

	@Override
	public void clearbooking() {
		sessionFactory.getCurrentSession().createSQLQuery("delete from Info_Buy  where persID >= :persID and paid = :paid")
		.setInteger("persID", 1).setBoolean("paid", false).executeUpdate();
		
	}

}
