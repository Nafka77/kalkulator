package com.jsfcourse.calc;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class Credit {
	private String sim;
	private String sam;
	private String sum;
	private Double result;

	@Inject
	FacesContext ctx;

	public String getsim() {
		return sim;
	}

	public void setsim(String sim) {
		this.sim = sim;
	}

	public String getsam() {
		return sam;
	}

	public void setsam(String sam) {
		this.sam = sam;
	}
	public String getsum() {
		return sum;
	}

	public void setsum(String sum) {
		this.sum = sum;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	public boolean doTheMath() {
		try {
			double sim = Double.parseDouble(this.sim);
			double sam = Double.parseDouble(this.sam);
			double sum = Double.parseDouble(this.sum);
			//result = (($this->form->amoun /$this->form->years) + ($this->form->amoun*($this->form->interest_rate/$procent)));
			result = (double) Math.round(((sim/(sam*12))+(sim/(sam*12))*(sum/100))*100)/100;

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true; 
		} catch (Exception e) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
			return false; 
		}
	}
	public String calc() {
		if (doTheMath()) {
			return "showresult";
		}
		return null;
	}
	public String calc_AJAX() {
		if (doTheMath()) {
			
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Rata miesięczna wynosi: " + result, null));
		}
		return null;
	}

	public String info() {
		return "info";
	}
}