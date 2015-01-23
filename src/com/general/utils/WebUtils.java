package com.general.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;


import com.tbs.general.Constants;

public class WebUtils {

	public static final String WELCOME = "Welcome";

	public static Map<String, String> objectToMap(Object object) {
		Map<String, String> map = new TreeMap();
		if (object != null) {
			for (Field field : object.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				try {
					Object obj = field.get(object);
					if (obj != null) {
						map.put(camelCasingStylingToNormal(field.getName()),
								String.valueOf(obj));

					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return map;
	}

	public static String camelCasingStylingToNormal(String camelStyledString) {
		StringBuilder stringBuilder = new StringBuilder();
		int counter = 0;
		if (camelStyledString != null) {
			char[] chars = camelStyledString.toCharArray();
			for (int i = 0; i < camelStyledString.toCharArray().length; i++) {
				char currentChar = chars[i];
				if (i == 0) {
					stringBuilder.append(String.valueOf(currentChar)
							.toUpperCase());
					continue;
				}
				if (((int) currentChar) >= 65 && ((int) currentChar) <= 90) {
					stringBuilder.append(" ");
					stringBuilder.append(String.valueOf(currentChar)
							.toUpperCase());
					counter++;
				} else {
					stringBuilder.append(String.valueOf(currentChar)
							.toLowerCase());

				}
			}
		}
		return stringBuilder.toString();
	}

	public static void fireErrorMessage(String key) {
		String messageToDisplay = extractFromBundle(key);
		fireMessage(FacesMessage.SEVERITY_ERROR, messageToDisplay);
	}

	public static void fireInfoMessage(String key) {
		String messageToDisplay = extractFromBundle(key);
		fireMessage(FacesMessage.SEVERITY_INFO, messageToDisplay);

	}

	public static void fireMessage(FacesMessage.Severity severity,
			String messageToDisplay) {
		FacesContext
				.getCurrentInstance()
				.getCurrentInstance()
				.addMessage("",
						new FacesMessage(severity, messageToDisplay, ""));

	}

	public static String extractFromBundle(String key) {
		ResourceBundle bundle = FacesContext.getCurrentInstance()
				.getApplication()
				.getResourceBundle(FacesContext.getCurrentInstance(), "loc");
		try {
			return bundle.getString(key);
		} catch (Exception ex) {
			return key + " Not Found";
		}
	}

	public static void redirectTo(String homePage) {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(homePage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String perpareWelcomeMessage(String firstName) {

		String welcome = extractFromBundle(WELCOME);
		return String.format("%s ,", welcome);
	}

	public static String getWarPath() {
		String targetedLocation = FacesContext.getCurrentInstance()
				.getExternalContext().getRealPath("/");
		return targetedLocation;

	}

	

	public static void invokeJavaScriptFunction(String functionWithParameter) {

		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.execute(functionWithParameter);
	}

	public static void fireDetailsIntoMessage(String key, String details) {
		String messageToDisplay = extractFromBundle(key);
		fireDetailedMessage(FacesMessage.SEVERITY_INFO, messageToDisplay,
				details);

	}

	private static void fireDetailedMessage(Severity severity, String title,
			String details) {
		FacesContext.getCurrentInstance().getCurrentInstance()
				.addMessage("", new FacesMessage(severity, title, details));

	}

	public static void invalidateSession() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		session.invalidate();

	}

	public static String getRealPath(String str) {
		URL url = null;
		try {
			url = FacesContext.getCurrentInstance().getExternalContext()
					.getResource(str);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return (url != null) ? url.getPath() : "";
	}

	public static boolean isFileExistInWar(String filePath) {
		String realFilePath = getRealPath("//"+filePath);
		File f = new File(realFilePath);

		return f.exists();
	}

	public static void injectIntoSession(String key , Object objectToInject)
	{
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put(key, objectToInject);	
	}
	public static Object extractFromSession(String key )
	{
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		Object objectToReturn = sessionMap.get(key);
		return objectToReturn;
	
	}
	
	
}
