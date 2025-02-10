package com.example.demo.controllers;
import java.util.List;
import com.example.demo.models.Note;
import com.example.demo.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notes")
public class TaskController {

    private final NoteService noteService;

    @Autowired
    public TaskController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<Note> getAllNotes(){
        return this.noteService.getAllNotes();
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable long id){
        return this.noteService.getNoteById(id);
    }

    @PostMapping
    public void createNote(@RequestBody Note note){
        this.noteService.createNote(note);
    }

    @PatchMapping("/{id}/{title}/{content}")
    public Note updateNote(@PathVariable long id, @PathVariable String title, @PathVariable String content){
        return this.noteService.updateNote(id, title, content);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable long id){
        this.deleteNote(id);
    }


}
