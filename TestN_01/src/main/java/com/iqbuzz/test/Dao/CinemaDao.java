package com.iqbuzz.test.Dao;

public interface CinemaDao {

	int setPerson(String name, String familly, String second_familly, int price);

	void clear();

	void checkbook(int id);

	String buy(int id, Long ccn);

	void clearbooking();

}
