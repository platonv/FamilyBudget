package ro.ubbcluj.controller;

import ro.ubbcluj.model.Member;
import ro.ubbcluj.repository.MemberRepository;

public class MemberController {

    private MemberRepository mr;

    public MemberController(MemberRepository newMr){
        this.mr =newMr;
    }

    public boolean validateMemberName(String name) {
        if (name.matches(".*\\d+.*")) {
            return false;
        } else {
            return true;
        }
    }

    public void addMember(String id,String name)
    {
        Member member= new Member(id,name);
        mr.addMember(member);
    }
}
