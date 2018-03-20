package ro.ubbcluj.controller;

import ro.ubbcluj.model.Entry;
import ro.ubbcluj.model.Member;
import ro.ubbcluj.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;

public class MemberController {
	
    private MemberRepository mr;
    
    public MemberController(MemberRepository newMr){    	
    	this.mr =newMr;    	
    }
    
    public void addMember(Member aMemebr) {
        mr.addMember(aMemebr);    	
    }

    public void addEntry(Entry oneEntry) {
        mr.addEntry(oneEntry);    	
    }

     public List<Entry> allEntries() {
        
    	
        List<Entry> allE = new ArrayList<Entry>();
        allE = this.mr.getAllEntries();
        return allE;
    }
} 