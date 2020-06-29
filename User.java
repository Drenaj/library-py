package newPackage;

import java.util.*;

public class User {

    private ArrayList<Book> books;
    private int userId;
    private static int count;
    private boolean isBanned;

    public int getUserId() {
        return this.userId;
    }

    public User() {
        userId = count++;
        isBanned = false;
        books = new ArrayList<>();
    }

    public String borrowBook(String title) {
        //well it is not possible to borrow the book, by just saying its 
        //name to the librarian. You must take the book, and give it to the 
        //librarian. See the following method. 
        return null;
    }

    public String borrowBook(Book b) {
        String result = "";
        //first check if the user is banned or not
        if (!isBanned) {
            result = "there is no available copy";
            if (b.borrowMe()) {
                books.add(b);
                result = b.getReturnDate().toString();
            }
        } else {
            result = "you are banned, you cannot borrow any books";
        }
        return result;
    }

    public void returnBook(String title) {
        //the same argument is valid here as well.
    }

    public void returnBook(Book b) {
        Date today = new Date();
        if(today.after(b.getReturnDate()))
            isBanned = true;
        b.returnMe();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).equals(b)) {
                books.remove(i);
                break;
            }
        }
    }

}
