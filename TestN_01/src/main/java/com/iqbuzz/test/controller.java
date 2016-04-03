package com.iqbuzz.test;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iqbuzz.test.Dao.CinemaDao;

@Controller
@RequestMapping(value = "/cinema")
public class controller {
	
	@Autowired
	public CinemaDao dao ;
	
	@RequestMapping(method = RequestMethod.GET )
	public ModelAndView welcome()
	{
		return new ModelAndView("welcome");
	}
	
	@RequestMapping(method = RequestMethod.POST , value="/booking", consumes="application/json", produces="application/json")
	public @ResponseBody String setBooking(@RequestBody String str)
	{
		JSONObject jsonObj = new JSONObject(str);
		int persID= dao.setPerson(jsonObj.getJSONArray("params").getString(0), jsonObj.getJSONArray("params").getString(1)
				, jsonObj.getJSONArray("params").getString(2),jsonObj.getJSONArray("params").getInt(3) );
		jsonObj.remove("method");
		jsonObj.remove("params");
		jsonObj.put("result", persID);
		return jsonObj.toString();
	}
	
	
	@RequestMapping(method = RequestMethod.POST , value="/buy", consumes="application/json")
	public @ResponseBody String buy(@RequestBody String str)
	{
		JSONObject jsonObj = new JSONObject(str);
		
		String retrn= dao.buy(jsonObj.getJSONArray("params").getInt(0), jsonObj.getJSONArray("params").getLong(1));
		jsonObj.remove("method");
		jsonObj.remove("params");
		
		jsonObj.put("result", retrn);
		return jsonObj.toString();

	}
	
	@RequestMapping(method = RequestMethod.DELETE , value="/checkbooking", consumes="application/json")
	public void checkbook(@RequestBody String str)
	{
		dao.checkbook(new JSONObject(str).getJSONArray("params").getInt(0));
	}
	
	@RequestMapping(method = RequestMethod.DELETE , value="/clearbooking", consumes="application/json")
	public void clearbooking(@RequestBody String str)
	{
		dao.clearbooking();
	}
	
	@RequestMapping(method = RequestMethod.DELETE , value="/clear", consumes="application/json")
	public void clear(@RequestBody String str)
	{
		dao.clear();
	}

}
