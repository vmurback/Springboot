package org.generation.farmacea.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
			
		@NotNull
		private String higiene;
		
		@NotNull
		private String alimento;
		
		@NotNull
		private String medicamento;
		
		@NotNull
		private String cosmetico;
		
		@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
		@JsonIgnoreProperties ("categoria")
		private List<Produto> produto;
		
		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}


		public String getHigiene() {
			return higiene;
		}


		public void setHigiene(String higiene) {
			this.higiene = higiene;
		}


		public String getAlimento() {
			return alimento;
		}


		public void setAlimento(String alimento) {
			this.alimento = alimento;
		}


		public String getMedicamento() {
			return medicamento;
		}


		public void setMedicamento(String medicamento) {
			this.medicamento = medicamento;
		}


		public String getCosmetico() {
			return cosmetico;
		}


		public void setCosmetico(String cosmetico) {
			this.cosmetico = cosmetico;
		}


		public List<Produto> getProduto() {
			return produto;
		}


		public void setProduto(List<Produto> produto) {
			this.produto = produto;
		}
		
}
