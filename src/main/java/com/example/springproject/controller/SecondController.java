package com.example.springproject.controller;

import com.example.springproject.model.Post;
import com.example.springproject.model.User;
import com.example.springproject.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

/** controller file
 * @author mariyapolous
 *
 */

@Controller
public class SecondController {

    @Autowired
    private PostRepo postRepo;


    @GetMapping("/blog")
    public String blog(Model model){
        Iterable<Post> posts = postRepo.findAll();
        model.addAttribute("posts", posts);
        return "myblog";

    }


    @GetMapping("/blog/add")
    public String blogAdd(Model model){
        return "blog-add";

    }

    @PostMapping("/blog/add")
    public String blogPostAdd(User user, @RequestParam String title, @RequestParam String full_text, @RequestParam Date createDate, Model model){

        Post post = new Post(user, title, full_text, createDate);
        postRepo.save(post);
        return "redirect:/myblog";

    }

    @GetMapping("/myblog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model){
        if(!postRepo.existsById(id)){
            return "redirect:/myblog";
        }


        Optional<Post> post = postRepo.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);

        return "blog-details";

    }
}
