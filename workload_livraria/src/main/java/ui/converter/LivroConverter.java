package ui.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import data.model.Livro;
import service.LivroService;
import service.exception.ServiceException;

public class LivroConverter implements Converter{
	FacesContext fc = FacesContext.getCurrentInstance();
	
	public LivroConverter() {
		// todo Auto-generated constructor stub
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if(value != null && value.trim().length() > 0) {
            try {
                LivroService service = fc.getApplication().evaluateExpressionGet(fc, "#{livroService}", LivroService.class);
                return service.encontreLivro(Long.valueOf(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            } catch (ServiceException e) {
            	throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Desconhecido", "Erro de servico."));
			}
        }
        else {
            return null;
        }
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null && arg2 instanceof Livro) {
			Livro livro = (Livro) arg2;
			return String.valueOf(livro.getId());
		}
		
		return arg2.toString();
	}

}
