package com.codelab.helmi.simades.layanan;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class Result{

	@SerializedName("surat_pengantar_ektp")
	private List<SuratPengantarEktpItem> suratPengantarEktp;

	@SerializedName("surat_bepergian")
	private List<SuratBepergianItem> suratBepergian;

	@SerializedName("surat_pengantar_skck")
	private List<SuratPengantarSkckItem> suratPengantarSkck;

	@SerializedName("surat_kehilangan")
	private List<SuratKehilanganItem> suratKehilangan;

	@SerializedName("surat_kelahiran")
	private List<SuratKelahiranItem> suratKelahiran;

	@SerializedName("surat_wali")
	private List<SuratWaliItem> suratWali;

	@SerializedName("surat_blm_menikah")
	private List<SuratBlmMenikahItem> suratBlmMenikah;

	@SerializedName("surat_tidak_mampu")
	private List<SuratTidakMampuItem> suratTidakMampu;

	@SerializedName("surat_domisili")
	private List<SuratDomisiliItem> suratDomisili;

	@SerializedName("surat_izin_keramaian")
	private List<SuratIzinKeramaianItem> suratIzinKeramaian;

	@SerializedName("surat_usaha")
	private List<SuratUsahaItem> suratUsaha;

	@SerializedName("surat_kematian")
	private List<SuratKematianItem> suratKematian;

	public void setSuratPengantarEktp(List<SuratPengantarEktpItem> suratPengantarEktp){
		this.suratPengantarEktp = suratPengantarEktp;
	}

	public List<SuratPengantarEktpItem> getSuratPengantarEktp(){
		return suratPengantarEktp;
	}

	public void setSuratBepergian(List<SuratBepergianItem> suratBepergian){
		this.suratBepergian = suratBepergian;
	}

	public List<SuratBepergianItem> getSuratBepergian(){
		return suratBepergian;
	}

	public void setSuratPengantarSkck(List<SuratPengantarSkckItem> suratPengantarSkck){
		this.suratPengantarSkck = suratPengantarSkck;
	}

	public List<SuratPengantarSkckItem> getSuratPengantarSkck(){
		return suratPengantarSkck;
	}

	public void setSuratKehilangan(List<SuratKehilanganItem> suratKehilangan){
		this.suratKehilangan = suratKehilangan;
	}

	public List<SuratKehilanganItem> getSuratKehilangan(){
		return suratKehilangan;
	}

	public void setSuratKelahiran(List<SuratKelahiranItem> suratKelahiran){
		this.suratKelahiran = suratKelahiran;
	}

	public List<SuratKelahiranItem> getSuratKelahiran(){
		return suratKelahiran;
	}

	public void setSuratWali(List<SuratWaliItem> suratWali){
		this.suratWali = suratWali;
	}

	public List<SuratWaliItem> getSuratWali(){
		return suratWali;
	}

	public void setSuratBlmMenikah(List<SuratBlmMenikahItem> suratBlmMenikah){
		this.suratBlmMenikah = suratBlmMenikah;
	}

	public List<SuratBlmMenikahItem> getSuratBlmMenikah(){
		return suratBlmMenikah;
	}

	public void setSuratTidakMampu(List<SuratTidakMampuItem> suratTidakMampu){
		this.suratTidakMampu = suratTidakMampu;
	}

	public List<SuratTidakMampuItem> getSuratTidakMampu(){
		return suratTidakMampu;
	}

	public void setSuratDomisili(List<SuratDomisiliItem> suratDomisili){
		this.suratDomisili = suratDomisili;
	}

	public List<SuratDomisiliItem> getSuratDomisili(){
		return suratDomisili;
	}

	public void setSuratIzinKeramaian(List<SuratIzinKeramaianItem> suratIzinKeramaian){
		this.suratIzinKeramaian = suratIzinKeramaian;
	}

	public List<SuratIzinKeramaianItem> getSuratIzinKeramaian(){
		return suratIzinKeramaian;
	}

	public void setSuratUsaha(List<SuratUsahaItem> suratUsaha){
		this.suratUsaha = suratUsaha;
	}

	public List<SuratUsahaItem> getSuratUsaha(){
		return suratUsaha;
	}

	public void setSuratKematian(List<SuratKematianItem> suratKematian){
		this.suratKematian = suratKematian;
	}

	public List<SuratKematianItem> getSuratKematian(){
		return suratKematian;
	}

	@Override
 	public String toString(){
		return 
			"Result{" + 
			"surat_pengantar_ektp = '" + suratPengantarEktp + '\'' + 
			",surat_bepergian = '" + suratBepergian + '\'' + 
			",surat_pengantar_skck = '" + suratPengantarSkck + '\'' + 
			",surat_kehilangan = '" + suratKehilangan + '\'' + 
			",surat_kelahiran = '" + suratKelahiran + '\'' + 
			",surat_wali = '" + suratWali + '\'' + 
			",surat_blm_menikah = '" + suratBlmMenikah + '\'' + 
			",surat_tidak_mampu = '" + suratTidakMampu + '\'' + 
			",surat_domisili = '" + suratDomisili + '\'' + 
			",surat_izin_keramaian = '" + suratIzinKeramaian + '\'' + 
			",surat_usaha = '" + suratUsaha + '\'' + 
			",surat_kematian = '" + suratKematian + '\'' + 
			"}";
		}
}