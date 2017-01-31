package com.ait.corrigan.beans;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {

	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

	public static String getCheckLogin() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		return session.getAttribute("customerLogin").toString();
	}

	public static long getCustomerId() {
		HttpSession session = getSession();
		if (session != null) {
			Object idCustomer = session.getAttribute("idCustomer");
			if (idCustomer != null) {
				return Long.parseLong(idCustomer.toString());
			}
		}
		return 0;
	}

}
