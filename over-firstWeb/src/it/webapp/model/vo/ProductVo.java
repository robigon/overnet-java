/**
 * ProductVo.java
 *
 * robgion
 * www.2clever.it
 * 
 * 25 ott 2017
 * For further information please write to info@2clever.it
 */
package it.webapp.model.vo;

/**
 * @author robgion
 *
 */
public class ProductVo {

	private Long id;
	private String code; 
	private String description;
	private Double price;
	private int version;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
}
