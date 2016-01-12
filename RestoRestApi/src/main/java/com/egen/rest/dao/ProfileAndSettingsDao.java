
package com.egen.rest.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.egen.rest.domain.ProfileAndSettings;
import com.egen.rest.exception.AppException;
import com.egen.rest.hibernate.DBUtil;

@Component
@Qualifier("profileAndSettingsDao")
public class ProfileAndSettingsDao {

	public List<ProfileAndSettings> getAll() throws AppException {
		try {
			Session session = DBUtil.getSession();
			Query query = session.createQuery("from ProfileAndSettings");
			List<ProfileAndSettings> profileList = query.list();
			return profileList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}

	}

	public ProfileAndSettings create(ProfileAndSettings profile) throws AppException {
		try {
			Session session = DBUtil.getSession();
			session.beginTransaction();
			session.save(profile);
			session.getTransaction().commit();

			return profile;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}

	}

	public ProfileAndSettings get(Integer id) throws AppException {
		try {
			Session session = DBUtil.getSession();
			Query query = session.createQuery("FROM ProfileAndSettings where restId=:restId");
			query.setParameter("restId", id);
			return (ProfileAndSettings) query.list().get(0);

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
			Query query = session.createQuery("delete ProfileAndSettings where restId=:restId");
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

	public ProfileAndSettings update(int id, ProfileAndSettings profile) throws AppException {
		ProfileAndSettings persistedProfile = get(id);
		if (persistedProfile != null) {
			try {
				Session session = DBUtil.getSession();
				session.beginTransaction();

				persistedProfile.setRestName(profile.getRestName());
				persistedProfile.setTagLine(profile.getTagLine());
				persistedProfile.setAddrLine1(profile.getAddrLine1());
				persistedProfile.setAddrLine2(profile.getAddrLine2());
				persistedProfile.setCity(profile.getCity());
				persistedProfile.setState(profile.getState());
				persistedProfile.setZipCode(profile.getZipCode());
				persistedProfile.setPhone(profile.getPhone());
				persistedProfile.setEmail(profile.getEmail());
				persistedProfile.setAutoAssign(profile.isAutoAssign());
				persistedProfile.setOpenCloseDetails(profile.getOpenCloseDetails());
				session.save(persistedProfile);
				session.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
				throw new AppException(e.getMessage());
			}

		}

		return persistedProfile;
	}

}
