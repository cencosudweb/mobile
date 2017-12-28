/**
 *@name CuadraturaVtavPd.java
 * 
 *@version 1.0 
 * 
 *@date 07-03-2017
 * 
 *@author EA7129
 * 
 *@copyright Cencosud. All rights reserved.
 */

package com.cencosud.mobile.dao.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 *  @description Clase Channel
 *
 */

@Entity
@Table(name = "cuadratura_vtav_pd")
public class CuadraturaVtavPd implements Serializable {

	private static final long serialVersionUID = 5468480017252581493L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tc_po_line_id")
	private String tcPoLineId;
	
	@Column(name = "n_Solicitud_cliente")
	private String nSolicitudCliente;
	
	@Column(name = "n_orden_distribu")
	private String nOrdenDistribu;
	
	@Column(name = "fecha_creacion_orden")
	private String fechaCreacionOrden;
	
	@Column(name = "fechacompromiso")
	private String fechaCompromiso;
	
	@Column(name = "estorden")
	private String estOrden;
	
	@Column(name = "estLineaorden")
	private String estLineaOrden;
	
	@Column(name = "estado_od")
	private String estadoOd;
	
	@Column(name = "sku")
	private String sku;
	
	@Column(name = "descsku")
	private String descSku;
	
	
	@Column(name = "cantsku")
	private String cantSku;
	
	@Column(name = "despacho")
	private String despacho;
	
	@Column(name = "tipo_orden")
	private String tipoOrden;
	
	@Column(name = "ano")
	private String ano;
	
	
	@Column(name = "descripcion_tipo_orden")
	private String descripcionTipoOrden;
	
	@Column(name = "tipo_venta")
	private int tipoVenta;
	
	@Column(name = "tipo_numero_distribuicion")
	private int tipoNumeroDistribuicion;
	
	@Column(name = "horario")
	private int horario;
	
	@Column(name = "horario2")
	private int horario2;
	
	@Column(name = "fecha_creacion")
	private String fechaCreacion;
	
	public CuadraturaVtavPd(){}
	
	public CuadraturaVtavPd(Long id){
		this.id = id;
	}
	
	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the tcPoLineId
	 */
	public String getTcPoLineId() {
		return tcPoLineId;
	}

	/**
	 * @param tcPoLineId the tcPoLineId to set
	 */
	public void setTcPoLineId(String tcPoLineId) {
		this.tcPoLineId = tcPoLineId;
	}

	/**
	 * @return the nSolicitudCliente
	 */
	public String getnSolicitudCliente() {
		return nSolicitudCliente;
	}

	/**
	 * @param nSolicitudCliente the nSolicitudCliente to set
	 */
	public void setnSolicitudCliente(String nSolicitudCliente) {
		this.nSolicitudCliente = nSolicitudCliente;
	}

	/**
	 * @return the nOrdenDistribu
	 */
	public String getnOrdenDistribu() {
		return nOrdenDistribu;
	}

	/**
	 * @param nOrdenDistribu the nOrdenDistribu to set
	 */
	public void setnOrdenDistribu(String nOrdenDistribu) {
		this.nOrdenDistribu = nOrdenDistribu;
	}

	/**
	 * @return the fechaCreacionOrden
	 */
	public String getFechaCreacionOrden() {
		return fechaCreacionOrden;
	}

	/**
	 * @param fechaCreacionOrden the fechaCreacionOrden to set
	 */
	public void setFechaCreacionOrden(String fechaCreacionOrden) {
		this.fechaCreacionOrden = fechaCreacionOrden;
	}

	/**
	 * @return the fechaCompromiso
	 */
	public String getFechaCompromiso() {
		return fechaCompromiso;
	}

	/**
	 * @param fechaCompromiso the fechaCompromiso to set
	 */
	public void setFechaCompromiso(String fechaCompromiso) {
		this.fechaCompromiso = fechaCompromiso;
	}

	/**
	 * @return the estOrden
	 */
	public String getEstOrden() {
		return estOrden;
	}

	/**
	 * @param estOrden the estOrden to set
	 */
	public void setEstOrden(String estOrden) {
		this.estOrden = estOrden;
	}

	/**
	 * @return the estLineaOrden
	 */
	public String getEstLineaOrden() {
		return estLineaOrden;
	}

	/**
	 * @param estLineaOrden the estLineaOrden to set
	 */
	public void setEstLineaOrden(String estLineaOrden) {
		this.estLineaOrden = estLineaOrden;
	}

	/**
	 * @return the estadoOd
	 */
	public String getEstadoOd() {
		return estadoOd;
	}

	/**
	 * @param estadoOd the estadoOd to set
	 */
	public void setEstadoOd(String estadoOd) {
		this.estadoOd = estadoOd;
	}

	/**
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * @param sku the sku to set
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}

	/**
	 * @return the descSku
	 */
	public String getDescSku() {
		return descSku;
	}

	/**
	 * @param descSku the descSku to set
	 */
	public void setDescSku(String descSku) {
		this.descSku = descSku;
	}

	/**
	 * @return the cantSku
	 */
	public String getCantSku() {
		return cantSku;
	}

	/**
	 * @param cantSku the cantSku to set
	 */
	public void setCantSku(String cantSku) {
		this.cantSku = cantSku;
	}

	/**
	 * @return the despacho
	 */
	public String getDespacho() {
		return despacho;
	}

	/**
	 * @param despacho the despacho to set
	 */
	public void setDespacho(String despacho) {
		this.despacho = despacho;
	}

	/**
	 * @return the tipoOrden
	 */
	public String getTipoOrden() {
		return tipoOrden;
	}

	/**
	 * @param tipoOrden the tipoOrden to set
	 */
	public void setTipoOrden(String tipoOrden) {
		this.tipoOrden = tipoOrden;
	}

	/**
	 * @return the ano
	 */
	public String getAno() {
		return ano;
	}

	/**
	 * @param ano the ano to set
	 */
	public void setAno(String ano) {
		this.ano = ano;
	}

	/**
	 * @return the descripcionTipoOrden
	 */
	public String getDescripcionTipoOrden() {
		return descripcionTipoOrden;
	}

	/**
	 * @param descripcionTipoOrden the descripcionTipoOrden to set
	 */
	public void setDescripcionTipoOrden(String descripcionTipoOrden) {
		this.descripcionTipoOrden = descripcionTipoOrden;
	}

	/**
	 * @return the tipoVenta
	 */
	public int getTipoVenta() {
		return tipoVenta;
	}

	/**
	 * @param tipoVenta the tipoVenta to set
	 */
	public void setTipoVenta(int tipoVenta) {
		this.tipoVenta = tipoVenta;
	}

	/**
	 * @return the tipoNumeroDistribuicion
	 */
	public int getTipoNumeroDistribuicion() {
		return tipoNumeroDistribuicion;
	}

	/**
	 * @param tipoNumeroDistribuicion the tipoNumeroDistribuicion to set
	 */
	public void setTipoNumeroDistribuicion(int tipoNumeroDistribuicion) {
		this.tipoNumeroDistribuicion = tipoNumeroDistribuicion;
	}

	/**
	 * @return the horario
	 */
	public int getHorario() {
		return horario;
	}

	/**
	 * @param horario the horario to set
	 */
	public void setHorario(int horario) {
		this.horario = horario;
	}

	/**
	 * @return the horario2
	 */
	public int getHorario2() {
		return horario2;
	}

	/**
	 * @param horario2 the horario2 to set
	 */
	public void setHorario2(int horario2) {
		this.horario2 = horario2;
	}

	/**
	 * @return the fechaCreacion
	 */
	public String getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	

	
}
