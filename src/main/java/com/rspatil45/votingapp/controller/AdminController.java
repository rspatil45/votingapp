package com.rspatil45.votingapp.controller;

import com.rspatil45.votingapp.dao.LeadCandidateDAO;
import com.rspatil45.votingapp.entity.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    public LeadCandidateDAO leadCandidateDAO;
    @GetMapping("/liveVoteCount")
    public String showLiveVoteCount(Model model)
    {
        List<Candidate> candidateList = leadCandidateDAO.loadAllCandidates();
        model.addAttribute("candidateList", candidateList);
        return "live-count";
    }
}
