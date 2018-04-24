package ro.ubbcluj.repository;

import ro.ubbcluj.model.Member;

import java.io.*;

import java.util.ArrayList;
import java.util.List;


public class MemberRepository {
    public List<Member> members = new ArrayList<Member>();

    private final static String filenameMember = "membersF.txt";

    public MemberRepository() {
//        this.loadFromFile();
    }

    private void loadFromFile() {
        try {
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            String currentLine = null;

            fileReader = new FileReader(filenameMember);
            bufferedReader = new BufferedReader(fileReader);

            while ((currentLine = bufferedReader.readLine()) != null) {
                String line[] = currentLine.split(";");
                Member m = new Member(line[0], line[1]);
                this.members.add(m);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    private void writeToFile(Member m) {
        try (FileWriter fw = new FileWriter(filenameMember,true);
             BufferedWriter bw= new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw))
        {
            out.println(m.toString());

        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void addMember(Member m) {
        members.add(m);
        writeToFile(m);
    }
}