package com.NotePad;
import java.util.ArrayList;
import java.util.Scanner;

public class NoteTakingApp {
        private ArrayList<Note> notes;
        private Scanner scanner;

        public NoteTakingApp() {
            notes = new ArrayList<>();
            scanner = new Scanner(System.in);
        }

        public void run() {
            while (true) {
                System.out.println("Note Taking App");
                System.out.println("1. Create Note");
                System.out.println("2. View Notes");
                System.out.println("3. Edit Note");
                System.out.println("4. Exit");
                System.out.print("Select an option: ");

                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character

                switch (choice) {
                    case 1:
                        createNote();
                        break;
                    case 2:
                        viewNotes();
                        break;
                    case 3:
                        editNote();
                        break;
                    case 4:
                        System.out.println("Exiting the app...");
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            }
        }

        private void createNote() {
            System.out.print("Enter note title: ");
            String title = scanner.nextLine();
            System.out.print("Enter note content: ");
            String content = scanner.nextLine();

            Note note = new Note(title, content);
            notes.add(note);

            System.out.println("Note created successfully.");
        }

        private void viewNotes() {
            if (notes.isEmpty()) {
                System.out.println("No notes available.");
            } else {
                System.out.println("Available notes:");
                for (int i = 0; i < notes.size(); i++) {
                    System.out.println((i + 1) + ". " + notes.get(i).getTitle());
                }
            }
        }

        private void editNote() {
            viewNotes();
            if (notes.isEmpty()) {
                return;
            }

            System.out.print("Enter the note number to edit: ");
            int noteNumber = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            if (noteNumber < 1 || noteNumber > notes.size()) {
                System.out.println("Invalid note number.");
                return;
            }

            Note note = notes.get(noteNumber - 1);
            System.out.print("Enter updated content: ");
            String newContent = scanner.nextLine();
            note.setContent(newContent);

            System.out.println("Note updated successfully.");
        }
    }


