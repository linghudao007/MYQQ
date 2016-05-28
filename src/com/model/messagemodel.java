package com.model;

public class messagemodel {

	private boolean shadow;
	private int portait;
	private String tittle;
	private int logo;
	private boolean shadows;
	public messagemodel(boolean shadow, int portait, String tittle, int logo,boolean shadows) {
		super();
		this.shadow = shadow;
		this.portait = portait;
		this.tittle = tittle;
		this.logo = logo;
		this.shadows=shadows;
	}
	public boolean isShadows() {
		return shadows;
	}
	public void setShadows(boolean shadows) {
		this.shadows = shadows;
	}
	public boolean isShadow() {
		return shadow;
	}
	public void setShadow(boolean shadow) {
		this.shadow = shadow;
	}
	public int getPortait() {
		return portait;
	}
	public void setPortait(int portait) {
		this.portait = portait;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public int getLogo() {
		return logo;
	}
	public void setLogo(int logo) {
		this.logo = logo;
	}
	
}
