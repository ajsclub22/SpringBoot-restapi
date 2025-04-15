package com.springboot.rest.repo;

import com.springboot.rest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer>
{

    List<JobPost> findByPostProfileContaining(String keyword);
}
//
//private final List<JobPost> jobs = new ArrayList<>(
//        List.of(
//                new JobPost(1, "Java Developer", "Req a Skill Java Dev", 2, List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
//                new JobPost(2, "React Developer", "Req a Skill FrontEnd Dev", 2, List.of("React", "JavaScript", "Vue")),
//                new JobPost(3, "DevOps Engineer", "Req a Skill DevOps Engineer", 2, List.of("Ci/Cd Pipe lines", "Deployment", "BitBucket", "Cloud"))
//        ));
//
//public List<JobPost> getAllJob(){
//    return jobs;
//}
//
//public void addJob(JobPost job){
//    jobs.add(job);
//}
//
//public JobPost getJob(int postId) {
//    System.out.println(jobs);
//    for(JobPost job: jobs){
//        System.out.println("in repo job");
//        if(job.getPostId() == postId)
//            return job;
//    }
//    return null;
//}
//
//public void updateJob(JobPost jobPost) {
//    for(JobPost job:jobs){
//        if(job.getPostId() == jobPost.getPostId()){
//            job.setPostDesc(jobPost.getPostDesc());
//            job.setPostProfile(jobPost.getPostProfile());
//            job.setReqExperience(jobPost.getReqExperience());
//            job.setPostTechStack(jobPost.getPostTechStack());
//            break;
//        }
//    }
//}
//
//public boolean deleteJob(int postId) {
//    for(JobPost job:jobs){
//        if(postId == job.getPostId()) {
//            jobs.remove(job);
//            return true;
//        }
//    }
//    return false;
//}
