package newPackage;

import java.util.*;

public class TestClass {

    private static ArrayList<User> users;
    private static ArrayList<Book> books;
    private static Scanner scn;
    public static void main(String[] args) {
        users = new ArrayList<>();
        books = new ArrayList<>();
        scn = new Scanner(System.in);
    }

    private static void addNewUser() {
        User u = new User();
        System.out.println("Your id is: "+u.getUserId());
        users.add(u);
    }

    private static void addNewBook() {
        System.out.print("Enter book title: ");
        String title = scn.next();
        System.out.print("Enter isbn: ");
        int isbn = scn.nextInt();
        Book b = new Book(isbn, title);
        //if the book is already in the list, increase its nofCopies by 1
        //else add it
        int idx = findBookIndex(b);
        if(idx !=-1)
            books.add(b);
        else
            books.get(idx).increaseNumberOfCopies();
            
    }

    private static int findBookIndex(Book b){
        for(int i=0;i<books.size();i++){
            if(books.get(i).equals(b))
                return i;            
        }
        return -1;
    }
    public static void borrowB() {
        System.out.print("Enter user id");
        int uid = scn.nextInt();
        System.out.print("Enter book title");
        String bTitle  = scn.next();
        //find teh user from list of users, find the book from list of books
        int uIdx = -1;
        for(int i=0;i<users.size();i++){
            if(users.get(i).getUserId()==uid){
                uIdx = i;
                break;
            }
        }
        if(uIdx==-1){
            System.out.println("there is no such user");
            return;
        }
        int bIdx = -1;
        for(int i=0;i<books.size();i++){
            if(books.get(i).getTitle().equals(bTitle)){
                bIdx = i;
                break;
            }
        }
        if(bIdx==-1){
            System.out.println("there is no such book");
            return;
        }
        
        String result = users.get(uIdx).borrowBook(books.get(bIdx));
        System.out.println(result);
        
    }
//please note that asking id and title, finding the book and the user idx 
// are common in both methods. So seperate them to a new method!!!
    public static void returnB() {
        System.out.print("Enter user id");
        int uid = scn.nextInt();
        System.out.print("Enter book title");
        String bTitle  = scn.next();
        //find teh user from list of users, find the book from list of books
        int uIdx = -1;
        for(int i=0;i<users.size();i++){
            if(users.get(i).getUserId()==uid){
                uIdx = i;
                break;
            }
        }
        if(uIdx==-1){
            System.out.println("there is no such user");
            return;
        }
        int bIdx = -1;
        for(int i=0;i<books.size();i++){
            if(books.get(i).getTitle().equals(bTitle)){
                bIdx = i;
                break;
            }
        }
        if(bIdx==-1){
            System.out.println("there is no such book");
            return;
        }
        //the crucial code is the following line!!!
        users.get(uIdx).returnBook(books.get(bIdx));
    }

    /**
     *
     * @param args
     */
    public static void menu() {
        int choice;
        boolean quit = false;
        while (!quit) {
            System.out.println("1. Add a new book");
            System.out.println("2. Add a user");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("0. Quit");
            System.out.print("Choice: ");
            choice = scn.nextInt();
            switch (choice) {
                case 1:
                    addNewBook();
                    break;
                case 2:
                    addNewUser();
                    break;
                case 3:
                    borrowB();
                    break;
                case 4:
                    returnB();
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Your choice is invalid, try again");
            }//end of switch
        }//end of while
    }

}
