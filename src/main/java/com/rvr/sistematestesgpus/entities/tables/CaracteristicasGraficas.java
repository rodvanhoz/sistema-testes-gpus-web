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
@Table(name = "CaracteristicasGraficas")
public class CaracteristicasGraficas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCaracGrafica;
	private String directX;
	private String openGL;
	private String openCL;
	private String vulkan;
	private String cuda;
	private String shaderModel;
	
	@JsonIgnore
	@OneToOne(mappedBy = "caracteristicasGraficas", cascade = CascadeType.ALL)
	private Gpus gpu;
	
	public CaracteristicasGraficas() {
		
	}
	
	public CaracteristicasGraficas(Integer idCaracGrafica, String directX, String openGL, String openCL, String vulkan,
			String cuda, String shaderModel) {
		this.idCaracGrafica = idCaracGrafica;
		this.directX = directX;
		this.openGL = openGL;
		this.openCL = openCL;
		this.vulkan = vulkan;
		this.cuda = cuda;
		this.shaderModel = shaderModel;
	}

	public Integer getIdCaracGrafica() {
		return idCaracGrafica;
	}

	public void setIdCaracGrafica(Integer idCaracGrafica) {
		this.idCaracGrafica = idCaracGrafica;
	}

	public String getDirectX() {
		return directX;
	}

	public void setDirectX(String directX) {
		this.directX = directX;
	}

	public String getOpenGL() {
		return openGL;
	}

	public void setOpenGL(String openGL) {
		this.openGL = openGL;
	}

	public String getOpenCL() {
		return openCL;
	}

	public void setOpenCL(String openCL) {
		this.openCL = openCL;
	}

	public String getVulkan() {
		return vulkan;
	}

	public void setVulkan(String vulkan) {
		this.vulkan = vulkan;
	}

	public String getCuda() {
		return cuda;
	}

	public void setCuda(String cuda) {
		this.cuda = cuda;
	}

	public String getShaderModel() {
		return shaderModel;
	}

	public void setShaderModel(String shaderModel) {
		this.shaderModel = shaderModel;
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
		result = prime * result + ((cuda == null) ? 0 : cuda.hashCode());
		result = prime * result + ((directX == null) ? 0 : directX.hashCode());
		result = prime * result + ((openCL == null) ? 0 : openCL.hashCode());
		result = prime * result + ((openGL == null) ? 0 : openGL.hashCode());
		result = prime * result + ((shaderModel == null) ? 0 : shaderModel.hashCode());
		result = prime * result + ((vulkan == null) ? 0 : vulkan.hashCode());
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
		CaracteristicasGraficas other = (CaracteristicasGraficas) obj;
		if (cuda == null) {
			if (other.cuda != null)
				return false;
		} else if (!cuda.equals(other.cuda))
			return false;
		if (directX == null) {
			if (other.directX != null)
				return false;
		} else if (!directX.equals(other.directX))
			return false;
		if (openCL == null) {
			if (other.openCL != null)
				return false;
		} else if (!openCL.equals(other.openCL))
			return false;
		if (openGL == null) {
			if (other.openGL != null)
				return false;
		} else if (!openGL.equals(other.openGL))
			return false;
		if (shaderModel == null) {
			if (other.shaderModel != null)
				return false;
		} else if (!shaderModel.equals(other.shaderModel))
			return false;
		if (vulkan == null) {
			if (other.vulkan != null)
				return false;
		} else if (!vulkan.equals(other.vulkan))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return idCaracGrafica + ": Dx " + directX + " / openGL " + openGL + " / vulkan " + vulkan + " / cuda " + cuda
				+ " / shaderModel " + shaderModel;
	}
	
}
