/**
 * ArticleRestController.java
 *
 * robgion
 * www.2clever.it
 * 
 * 18 lug 2017
 * For further information please write to info@2clever.it
 */
package it.clever.spring.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.clever.spring.web.viewbeans.Article;

@RestController
@SessionAttributes("articles")
@RequestMapping("/")
public class ArticleRestController {

	@PostMapping(value = "/save-article")
	public ResponseEntity<?> saveArticle(@RequestBody Article article,
			@ModelAttribute("articles") List<Article> articles, HttpSession session) {

		articles.add(article);

		return ResponseEntity.ok(articles);
	}


	@Bean
	@ModelAttribute("articles")
	public List<Article> articles(HttpServletRequest request) {
		return new ArrayList<Article>();
	}

}
