
package com.egen.rest.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.egen.rest.domain.Reservation;
import com.egen.rest.exception.AppException;
import com.egen.rest.hibernate.DBUtil;

@Component
@Qualifier("reservationsDao")
public class ReservationsDao {
	
	public List<Reservation> getAll() throws AppException {
		try {
			Session session = DBUtil.getSession();
			Query query = session.createQuery("from Reservation");
			List<Reservation> reservationList = query.list();
			return reservationList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}

	}

	public Reservation create(Reservation reservation) throws AppException {
		if(isValidData(reservation)){
			try {
				Session session = DBUtil.getSession();
				session.beginTransaction();
				session.save(reservation);
				session.getTransaction().commit();

				return reservation;
			} catch (Exception e) {
				e.printStackTrace();
				throw new AppException(e.getMessage());
			}
		}else{
			throw new AppException("Invalid reservation data");
		}
		

	}

	public Reservation get(Integer id) throws AppException {
		try {
			Session session = DBUtil.getSession();
			Query query = session.createQuery("FROM Reservation where id=:restId");
			query.setParameter("restId", id);
			return (Reservation) query.list().get(0);

		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
	}

	public boolean delete(Integer id) throws AppException {
		boolean flagDeleted = false;
		try {
			Session session = DBUtil.getSession();
			session.beginTransaction();
			Query query = session.createQuery("delete Reservation where id=:restId");
			query.setParameter("restId", id);
			query.executeUpdate();
			session.getTransaction().commit();
			flagDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		return flagDeleted;
	}

	private boolean isValidData(Reservation reservation) {

		if (reservation.getReserveDate() == null || reservation.getReserveDate().trim().length() <= 0) {
			return false;
		}
		if (reservation.getNoOfPeople() == null || reservation.getNoOfPeople() <= 0) {
			return false;
		}
		if (reservation.getCustomerName() == null || reservation.getCustomerName().trim().length() == 0) {
			return false;
		}
		if (reservation.getCustomerPhone() == null || reservation.getCustomerPhone().trim().length() <= 0) {
			return false;
		}
		return true;
	}

	public Reservation update(int id, Reservation reservation) throws AppException {
		Reservation persistedReservation = get(id);
		
		if(isValidData(reservation)){
			if (persistedReservation != null) {
				try {
					Session session = DBUtil.getSession();
					session.beginTransaction();
					
					persistedReservation.setReserveDate(reservation.getReserveDate());
					persistedReservation.setReserveTime(reservation.getReserveTime());
					persistedReservation.setNoOfPeople(reservation.getNoOfPeople());
					persistedReservation.setStatus(reservation.getStatus());
					persistedReservation.setTableNo(reservation.getTableNo());
					persistedReservation.setCustomerName(reservation.getCustomerName());
					persistedReservation.setCustomerEmail(reservation.getCustomerEmail());
					persistedReservation.setCustomerPhone(reservation.getCustomerPhone());
					session.save(persistedReservation);
					session.getTransaction().commit();
				} catch (Exception e) {
					e.printStackTrace();
					throw new AppException(e.getMessage());
				}

			}
		}else{
			throw new AppException("Data is invalid");
		}

		return persistedReservation;
	}

}
