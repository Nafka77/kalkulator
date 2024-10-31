package com.jsfcourse.calc;

import java.io.Serializable;
import java.util.ResourceBundle;

import jakarta.annotation.PostConstruct;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class KredytBB implements Serializable {
	private Double kwota;
	private Double czas;
	private Double procent;
	private Double result;
	
	// Resource injected
	@Inject
	@ManagedProperty("#{txtCalcErr}")
	private ResourceBundle txtCalcErr;

	// Resource injected
	@Inject
	@ManagedProperty("#{txtCalc}")
	private ResourceBundle txtCalc;

	@Inject
	FacesContext ctx;

	public Double getKwota() {
		return kwota;
	}

	public void setKwota(Double kwota) {
		this.kwota = kwota;
	}

	public Double getCzas() {
		return czas;
	}

	public void setCzas(Double czas) {
		this.czas = czas;
	}
	public Double getProcent() {
		return procent;
	}

	public void setProcent(Double procent) {
		this.procent = procent;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	public String calc() {
			result = (double) Math.round(((kwota/(czas*12))+(kwota/(czas*12))*(procent/100))*100)/100;

			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, txtCalcErr.getString("calcComputationOkInfo"), null));
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, txtCalc.getString("result") + ": " + result + "zł", null));

			return null;

	    }

	}
