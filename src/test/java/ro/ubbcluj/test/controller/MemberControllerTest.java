package ro.ubbcluj.test.controller;

import org.junit.jupiter.api.Test;
import ro.ubbcluj.controller.MemberController;
import ro.ubbcluj.repository.MemberRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemberControllerTest {
    @Test
    public void testValidateMember() {
        MemberController memberController = new MemberController(new MemberRepository());
        assertEquals(memberController.validateMemberName("Vlad1"), false, "validate Vlad1 did not return false");
        assertEquals(memberController.validateMemberName("Vlad"), true, "validate Vlad1 did not return true");
    }
}
