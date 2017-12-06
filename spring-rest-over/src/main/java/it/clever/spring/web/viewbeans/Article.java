/**
 * Article.java
 *
 * robgion
 * www.2clever.it
 * 
 * 06 nov 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.web.viewbeans;

import java.util.List;

/**
 * @author robgion
 *
 * Bean che viene utilizzato per i dati provenienti dall'interfaccia grafica.
 */
public class Article {

	private String title;
	private String url;
	private List<String> categories;
	private List<String> tags;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
}
