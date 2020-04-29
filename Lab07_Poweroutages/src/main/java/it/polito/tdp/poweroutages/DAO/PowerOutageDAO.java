package it.polito.tdp.poweroutages.DAO;

import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.poweroutages.model.Event;
import it.polito.tdp.poweroutages.model.Nerc;

public class PowerOutageDAO {
	
	public List<Nerc> getNercList() {

		String sql = "SELECT id, value FROM nerc";
		List<Nerc> nercList = new ArrayList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				Nerc n = new Nerc(res.getInt("id"), res.getString("value"));
				nercList.add(n);
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return nercList;
	}
	
	public List<Event> getEventList(int id){
		
		String sql = "SELECT date_event_began, date_event_finished, customers_affected FROM poweroutages p,  nerc n WHERE p.nerc_id = n.id AND n.id = ?";
		
		List<Event> nercList = new ArrayList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet res = st.executeQuery();
			
			while (res.next()) {
				LocalDateTime inizio = res.getTimestamp("date_event_began").toLocalDateTime();
				LocalDateTime fine = res.getTimestamp("date_event_finished").toLocalDateTime();
				
				Event e = new Event(inizio,fine,res.getInt("customers_affected"));
				nercList.add(e);
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return nercList;
	}
	

}
