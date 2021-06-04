package net.recurso.entidad;

import java.sql.Date;

public class Solicitud {
	private int cod_soli;
	private int cod_user;
	private int cod_area;
	private int cod_informe;
	private String fec_info;
	private String perfil_soli;
	private String descri_soli;
	
	public Solicitud() {
	}
	
	public int getCod_soli() {
		return cod_soli;
	}
	public void setCod_soli(int cod_soli) {
		this.cod_soli = cod_soli;
	}
	public int getCod_user() {
		return cod_user;
	}
	public void setCod_user(int cod_user) {
		this.cod_user = cod_user;
	}
	public int getCod_area() {
		return cod_area;
	}
	public void setCod_area(int cod_area) {
		this.cod_area = cod_area;
	}
	public int getCod_informe() {
		return cod_informe;
	}
	public void setCod_informe(int cod_informe) {
		this.cod_informe = cod_informe;
	}
	public String getFec_info() {
		return fec_info;
	}
	public void setFec_info(String fec_info) {
		this.fec_info = fec_info;
	}
	public String getPerfil_soli() {
		return perfil_soli;
	}
	public void setPerfil_soli(String perfil_soli) {
		this.perfil_soli = perfil_soli;
	}
	public String getDescri_soli() {
		return descri_soli;
	}
	public void setDescri_soli(String descri_soli) {
		this.descri_soli = descri_soli;
	}
}
