package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.faces.context.FacesContext;

public class LocaleService {
	
	private Locale currentLocale;

	public LocaleService() {
		this.currentLocale = FacesContext.getCurrentInstance().getApplication().getDefaultLocale();
	}

	public void changeCurrentLocale(Locale newLocale) {
		Iterator<Locale> supportedLocales = FacesContext.getCurrentInstance().getApplication().getSupportedLocales();
		Locale newSupportedLocale = FacesContext.getCurrentInstance().getViewRoot().getLocale();;
		while (supportedLocales.hasNext()) {
			newSupportedLocale = supportedLocales.next();
			if (newLocale.equals(newSupportedLocale)) {
				System.out.println("Trocando linguagem para: " + newLocale);
			}
		}
		
		currentLocale = newSupportedLocale;
		FacesContext.getCurrentInstance().getViewRoot().setLocale(newSupportedLocale);
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

	public void setCurrentLocale(Locale currentLocale) {
		this.currentLocale = currentLocale;
	}

}
