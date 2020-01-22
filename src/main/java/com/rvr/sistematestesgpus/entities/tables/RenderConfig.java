package com.rvr.sistematestesgpus.entities.tables;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "RenderConfig")
public class RenderConfig implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRenderConfig;
	private Integer shadingUnits;
	private Integer tmus;
	private Integer rops;
	private Integer smCount;
	private Integer L1Cache;
	private Integer L2Cache;
	private Integer tensorCores;
	private Integer rtCores;
	
	@JsonIgnore
	@OneToOne(mappedBy = "renderConfig", cascade = CascadeType.ALL)
	private Gpus gpu;
	
	public RenderConfig() {
		
	}
	
	public RenderConfig(Integer idRenderConfig, Integer shadingUnits, Integer tmus, Integer rops, Integer smCount,
			Integer l1Cache, Integer l2Cache, Integer tensorCores, Integer rtCores) {
		this.idRenderConfig = idRenderConfig;
		this.shadingUnits = shadingUnits;
		this.tmus = tmus;
		this.rops = rops;
		this.smCount = smCount;
		this.L1Cache = l1Cache;
		this.L2Cache = l2Cache;
		this.tensorCores = tensorCores;
		this.rtCores = rtCores;
	}

	public Integer getIdRenderConfig() {
		return idRenderConfig;
	}

	public void setIdRenderConfig(Integer idRenderConfig) {
		this.idRenderConfig = idRenderConfig;
	}

	public Integer getShadingUnits() {
		return shadingUnits;
	}

	public void setShadingUnits(Integer shadingUnits) {
		this.shadingUnits = shadingUnits;
	}

	public Integer getTmus() {
		return tmus;
	}

	public void setTmus(Integer tmus) {
		this.tmus = tmus;
	}

	public Integer getRops() {
		return rops;
	}

	public void setRops(Integer rops) {
		this.rops = rops;
	}

	public Integer getSmCount() {
		return smCount;
	}

	public void setSmCount(Integer smCount) {
		this.smCount = smCount;
	}

	public Integer getL1Cache() {
		return L1Cache;
	}

	public void setL1Cache(Integer l1Cache) {
		L1Cache = l1Cache;
	}

	public Integer getL2Cache() {
		return L2Cache;
	}

	public void setL2Cache(Integer l2Cache) {
		L2Cache = l2Cache;
	}

	public Integer getTensorCores() {
		return tensorCores;
	}

	public void setTensorCores(Integer tensorCores) {
		this.tensorCores = tensorCores;
	}

	public Integer getRtCores() {
		return rtCores;
	}

	public void setRtCores(Integer rtCores) {
		this.rtCores = rtCores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Gpus getGpu() {
		return gpu;
	}

	public void setGpu(Gpus gpu) {
		this.gpu = gpu;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((L2Cache == null) ? 0 : L2Cache.hashCode());
		result = prime * result + ((rops == null) ? 0 : rops.hashCode());
		result = prime * result + ((rtCores == null) ? 0 : rtCores.hashCode());
		result = prime * result + ((shadingUnits == null) ? 0 : shadingUnits.hashCode());
		result = prime * result + ((smCount == null) ? 0 : smCount.hashCode());
		result = prime * result + ((tensorCores == null) ? 0 : tensorCores.hashCode());
		result = prime * result + ((tmus == null) ? 0 : tmus.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RenderConfig other = (RenderConfig) obj;
		if (L2Cache == null) {
			if (other.L2Cache != null)
				return false;
		} else if (!L2Cache.equals(other.L2Cache))
			return false;
		if (rops == null) {
			if (other.rops != null)
				return false;
		} else if (!rops.equals(other.rops))
			return false;
		if (rtCores == null) {
			if (other.rtCores != null)
				return false;
		} else if (!rtCores.equals(other.rtCores))
			return false;
		if (shadingUnits == null) {
			if (other.shadingUnits != null)
				return false;
		} else if (!shadingUnits.equals(other.shadingUnits))
			return false;
		if (smCount == null) {
			if (other.smCount != null)
				return false;
		} else if (!smCount.equals(other.smCount))
			return false;
		if (tensorCores == null) {
			if (other.tensorCores != null)
				return false;
		} else if (!tensorCores.equals(other.tensorCores))
			return false;
		if (tmus == null) {
			if (other.tmus != null)
				return false;
		} else if (!tmus.equals(other.tmus))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return idRenderConfig + ": " + shadingUnits + " / TMUs: " + tmus + " / ROPs: " + rops;
	}
}
