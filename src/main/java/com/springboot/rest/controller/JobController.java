package com.springboot.rest.controller;

import com.springboot.rest.model.JobPost;
import com.springboot.rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    @Autowired
    private JobService service;

    @GetMapping("/jobposts")
    public List<JobPost> getAllJob(){
        System.out.println("in get get get" );
        return service.getAllJob();
    }

    @PostMapping("/jobpost")
    public JobPost addJob(@RequestBody JobPost job){
        System.out.println("in potttt");
        service.addJob(job);
        System.out.println(job);
        return service.getJob(job.getPostId());
    }

    @GetMapping("/jobpost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId){
        System.out.println("in controleer");
        return service.getJob(postId);

    }

    @PutMapping("/jobpost")
    public JobPost updateJob(@RequestBody JobPost job){
        service.updateJob(job);
        return service.getJob(job.getPostId());
    }

    @DeleteMapping("jobpost/{postId}")
    public String deleteJob(@PathVariable("postId") int postId){
        service.deleteJob(postId);
        return "Not found";
    }

    @GetMapping("/load")
    public String load()
    {
        service.load();
        return "Loaded";
    }

    @GetMapping("/jobpost/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword)
    {
        return service.searchByKeyword(keyword);
    }
}
