package ro.ubbcluj;

import ro.ubbcluj.controller.MemberController;
import ro.ubbcluj.repository.MemberRepository;
import ro.ubbcluj.ui.MemberUI;

public class App {
	public static void main(String[] args) {
	    MemberRepository repo = new MemberRepository();
		
		MemberController ctrl = new MemberController(repo);

		MemberUI console = new MemberUI(ctrl);

		console.Run();
	}
}
