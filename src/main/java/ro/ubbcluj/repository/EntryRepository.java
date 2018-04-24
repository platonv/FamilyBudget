package ro.ubbcluj.repository;

import ro.ubbcluj.model.Entry;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EntryRepository {
    private final static String filenameBudget = "budgetF.txt";

    public List<Entry> entries = new ArrayList<Entry>();

    public EntryRepository() {
//        this.loadFromFile();
    }

    public void addEntry(Entry e) {
        entries.add(e);
        writeToFile(e);
    }

    private void loadFromFile() {
        try {
            FileReader fileReaderEntry = null;
            BufferedReader bufferedReaderEntry = null;
            String currentLineEntry = null;

            fileReaderEntry = new FileReader(filenameBudget);
            bufferedReaderEntry = new BufferedReader(fileReaderEntry);

            while ((currentLineEntry = bufferedReaderEntry.readLine()) != null) {
                String line[] = currentLineEntry.split(";");
                int valueEntry = Integer.parseInt(line[1]);
                int idEntryMember = Integer.parseInt(line[2]);
                Entry e = new Entry(line[0], valueEntry, idEntryMember);
                this.entries.add(e);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    private void writeToFile(Entry e) {
        try (FileWriter fw = new FileWriter(filenameBudget, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(e.toString());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public List<Entry> getEntriesForMember(int id) {
        return this.entries.stream().filter(e -> e.getIdMember() == id).collect(Collectors.toList());
    }
}
