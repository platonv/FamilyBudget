package ro.ubbcluj;

import ro.ubbcluj.controller.EntryController;
import ro.ubbcluj.controller.MemberController;
import ro.ubbcluj.repository.EntryRepository;
import ro.ubbcluj.repository.MemberRepository;
import ro.ubbcluj.ui.MemberUI;

public class App {
	public static void main(String[] args) {
	    MemberRepository memberRepo = new MemberRepository();
		EntryRepository entryRepository = new EntryRepository();

		EntryController entryController = new EntryController(entryRepository);
		MemberController memberController = new MemberController(memberRepo);

		MemberUI console = new MemberUI(memberController, entryController);

		console.Run();
	}
}
