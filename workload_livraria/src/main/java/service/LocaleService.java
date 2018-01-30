package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.faces.context.FacesContext;

public class LocaleService {
	
	private Locale currentLocale;

	public LocaleService() {
		this.currentLocale = FacesContext.getCurrentInstance().getApplication().getDefaultLocale();
	}
	
	public String changeLocale() {
		Map<String, String> parameterMap = (Map<String, String>) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		   String newLanguage = parameterMap.get("newLanguage");
		currentLocale = new Locale(newLanguage);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(currentLocale);
		
		return FacesContext.getCurrentInstance().getViewRoot().getViewId();
	}
	
	public List<Locale> supportedLocales(){
		Iterator<Locale> supportedLocales = FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
		List<Locale> listaLiguagens = new ArrayList<>();
		while (supportedLocales.hasNext()) {
			Locale locale = (Locale) supportedLocales.next();
			listaLiguagens.add(locale);
		}
		
		return listaLiguagens;
	}
	
	public Locale getCurrentLocale() {
		return currentLocale;
	}

	public void setCurrentLocale(Locale locale) {
		this.currentLocale = locale;
	}

}
