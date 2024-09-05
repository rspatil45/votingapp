package com.rspatil45.votingapp.controller;

import com.rspatil45.votingapp.dao.LeadCandidateDAO;
import com.rspatil45.votingapp.dao.StudentDAO;
import com.rspatil45.votingapp.entity.Candidate;
import com.rspatil45.votingapp.entity.Student;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@SessionAttributes("student")
@Controller
public class VoteController {
    @Autowired
    private StudentDAO studentDAO;
    @Autowired
    private LeadCandidateDAO leadCandidateDAO;
    @GetMapping("/")
    public String firstPage(Model model)
    {
        model.addAttribute("studentObj", new Student());
        return "vote";
    }

    @PostMapping("/showHomePage")
    public String showHomePage(@RequestParam("studentName") String studentName, Model model)
    {
        Student student = studentDAO.findStudentByStudentName(studentName);
        model.addAttribute("student",student);
        if(student.isHasVoted())
        {
            return "already-voted";
        }
        // get all candidates
        List<Candidate> candidateList = leadCandidateDAO.loadAllCandidates();
        model.addAttribute("candidateList", candidateList);
        return "take-vote";
    }
    @GetMapping("submitVote/{id}")
    public String processVote(Model model, @PathVariable("id") int candidateId, @SessionAttribute("student") Student student)
    {
        Candidate candidate = leadCandidateDAO.getCandidateById(candidateId);
        int updatedVoteCount = candidate.getNoOfVotes() + 1;
        candidate.setNoOfVotes(updatedVoteCount);
        leadCandidateDAO.updateCandidate(candidate);
        student.setHasVoted(true);
        studentDAO.updateStudent(student);
        return "thank-you";
    }

}
