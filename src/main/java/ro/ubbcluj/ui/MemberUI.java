package ro.ubbcluj.ui;

import ro.ubbcluj.controller.EntryController;
import ro.ubbcluj.controller.MemberController;
import ro.ubbcluj.model.Entry;

import java.util.List;
import java.util.Scanner;

public class MemberUI {
	private MemberController memberController;
	private EntryController entryController;

	Scanner in;

	public MemberUI(MemberController memberController, EntryController entryController) {
		this.memberController = memberController;
		this.entryController = entryController;
		this.in = new Scanner(System.in);
	}

	public MemberController getMemberController() {
		return this.memberController;
	}

	public Scanner getIn() {
		return this.in;
	}

	public void setMemberController(MemberController newCtrl) {
		this.memberController = newCtrl;
	}

	public void setIn(Scanner newIn) {
		this.in = newIn;
	}

	public void printMenu() {
		String menu;
		menu = "Budget Admin Menu: \n";
		menu += "\t 1 - to add a new member; \n";
		menu += "\t 2 - to add a new income/cost; \n";
		menu += "\t 3 - to list the current income/cost; \n";
		menu += "\t 0 - exit \n";

		System.out.println(menu);
	}


	public void Run() {
		printMenu();


		int cmd = in.nextInt();
		in.nextLine();

		while (cmd != 0) {
			if (cmd == 1) {
				try {
					System.out.println("Enter name:");
					String name = in.nextLine();
					System.out.println("Enter id:");
					String id = in.nextLine();
					memberController.addMember(id, name);
					System.out.println("Member added!");
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			if (cmd == 2) {

				try {
					System.out.println("Enter type:");
					String type = in.nextLine();

					System.out.println("Enter the value:");
					String valueS = in.nextLine();
					int valueInt = Integer.parseInt(valueS);

					System.out.println("Enter the id of the member:");
					String idS = in.nextLine();
					int idInt = Integer.parseInt(idS);
					entryController.addEntry(type, valueInt, idInt);
					System.out.println("Entry added!");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}


			}
			if (cmd == 3) {
				System.out.println("list entries for member: ");
				int id = Integer.parseInt(in.nextLine());
				List<Entry> allE = entryController.allEntries(id);
				for (int j = 0; j < allE.size(); j++)
					System.out.println(allE.get(j).toString());
			}

			printMenu();
			cmd = in.nextInt();
			in.nextLine();
		}
	}
}
