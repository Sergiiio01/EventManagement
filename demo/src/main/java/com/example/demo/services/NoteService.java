package com.example.demo.services;


import com.example.demo.models.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {

    private final List<Note> notes = new ArrayList<>();
    private long nextId=1L;

    public NoteService(){
        notes.add(new Note(nextId++, "Note 1", "Description of the Note 1"));
        notes.add(new Note(nextId++, "Note 2", "Description of the Note 2"));
        notes.add(new Note(nextId++, "Note 3", "Description of the Note 3"));
    }


    public List<Note> getAllNotes(){
        return this.notes;
    }

    public Note getNoteById(long id){
        for(Note note: this.notes){
            if (note.getId()==id){
                return  note;
            }
        }
        return null;
    }


    public void createNote(Note note){
        this.notes.add(note);
    }

    public Note updateNote(long id, String title, String description){
        for(Note note: this.notes){
            if (note.getId()==id){
                note.setTitle(title);
                note.setContent(description);
                return note;
            }
        }
        return null;
    }

    public void deleteNote(long id){
        for(Note note: this.notes){
            if (note.getId()==id){
                this.notes.remove(note);
            }
        }
    }
}
