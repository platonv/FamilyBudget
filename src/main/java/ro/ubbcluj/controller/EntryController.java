package ro.ubbcluj.controller;

import ro.ubbcluj.exceptions.InvalidTypeException;
import ro.ubbcluj.model.Entry;
import ro.ubbcluj.repository.EntryRepository;

import java.util.List;

public class EntryController {
    private EntryRepository entryRepository;

    public EntryController(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public void addEntry(String typeEntry, int value, int idMemeber) throws Exception {
        if(typeEntry.equals("cost") || typeEntry.equals("income")){
            Entry entry= new Entry(typeEntry,value,idMemeber);
            entryRepository.addEntry(entry);
        }
        else{
            throw new InvalidTypeException();
        }

    }

    public List<Entry> allEntries(int id) {
        return this.entryRepository.getEntriesForMember(id);
    }
}