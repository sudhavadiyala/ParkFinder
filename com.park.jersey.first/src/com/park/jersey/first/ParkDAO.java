package com.park.jersey.first;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ParkDAO {

	
	public List<Park> findaPark()
	{
		List<Park> parkList = new ArrayList<Park>();
		Connection cn = DBUtil.connect();
		Statement ps = null;
		ResultSet rs = null;
		try{
			ps = cn.createStatement();
			rs = ps.executeQuery("select * from parkdata");
			while(rs.next())
			{
			   Park p = new Park();
			   p.setPark_name(rs.getString("park_name"));
			   p.setPark_state(rs.getString("park_state"));
			   p.setPark_location(rs.getString("park_location"));
			   p.setPark_zip(rs.getString("park_zip"));
			   p.setPark_opentimings(rs.getString("park_opentimings"));
			   p.setPark_opendays(rs.getString("park_opendays"));
			   p.setPark_contactnum(rs.getString("park_contactnum"));
			   p.setPark_distance(rs.getInt("park_distance"));
			   parkList.add(p);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return parkList;
	}
	
	public List<Park> zipSpecificPark(String zip)
	{
		List<Park> parkList = new ArrayList<Park>();
		List<Park> parkList1 = new ArrayList<Park>();
		
		
		Connection cn = DBUtil.connect();
		Statement ps = null;
		ResultSet rs = null;
		try{
			ps = cn.createStatement();
			rs = ps.executeQuery("select * from parkdata where park_state ='New Jersey'");
			while(rs.next())
			{
			   Park p = new Park();
			   p.setPark_name(rs.getString("park_name"));
			   p.setPark_state(rs.getString("park_state"));
			   p.setPark_location(rs.getString("park_location"));
			   p.setPark_zip(rs.getString("park_zip"));
			   p.setPark_opentimings(rs.getString("park_opentimings"));
			   p.setPark_opendays(rs.getString("park_opendays"));
			   p.setPark_contactnum(rs.getString("park_contactnum"));
			   p.setPark_distance(rs.getInt("park_distance"));
			   parkList.add(p);
			}
			
			
			RadiusCalc r = new RadiusCalc();
			parkList1 = r.findDistance(parkList,zip);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return parkList1;
	}
	
	
}

