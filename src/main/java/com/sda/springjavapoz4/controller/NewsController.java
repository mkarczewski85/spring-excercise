package com.sda.springjavapoz4.controller;

import com.sda.springjavapoz4.model.News;
import com.sda.springjavapoz4.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    NewsService newsService;

    @GetMapping
    public ModelAndView getAllNews() {
        List<News> allNews = newsService.getAllNews();
        ModelAndView modelAndView = new ModelAndView("allNews");
        modelAndView.addObject("allNews", allNews);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getNews(@PathVariable("id") long id) {
        News singleNews = newsService.getNews(id);
        ModelAndView modelAndView = new ModelAndView("news");
        modelAndView.addObject("singleNews", singleNews);
        return modelAndView;
    }

    @PostMapping
    public String saveNews(@ModelAttribute News news) {

        newsService.saveNews(news);
        return "redirect:/news/" + Integer.toString(newsService.getAllNews().size() - 1);
    }
}
