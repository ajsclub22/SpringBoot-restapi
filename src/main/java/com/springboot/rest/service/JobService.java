package com.springboot.rest.service;

import com.springboot.rest.model.JobPost;
import com.springboot.rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepo repo;

    public List<JobPost> getAllJob(){
        return repo.findAll();
    }
    public void addJob(JobPost job){
        repo.save(job);
    }

    public JobPost getJob(int postId) {
        System.out.println("in service");
        return repo.findById(postId).orElse(null);
    }

    public void updateJob(JobPost job) {
        repo.save(job);
    }

    public void deleteJob(int postId) {
         repo.deleteById(postId);
    }

    public void load()
    {
        List<JobPost> jobs = new ArrayList<>(
        List.of(
                new JobPost(1, "Java Developer", "Req a Skill Java Dev", 2, List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
                new JobPost(2, "React Developer", "Req a Skill FrontEnd Dev", 2, List.of("React", "JavaScript", "Vue")),
                new JobPost(3, "DevOps Engineer", "Req a Skill DevOps Engineer", 2, List.of("Ci/Cd Pipe lines", "Deployment", "BitBucket", "Cloud"))
        ));
        repo.saveAll(jobs);
    }

    public List<JobPost> searchByKeyword(String keyword)
    {
        return repo.findByPostProfileContaining(keyword);
    }
}
