package newPackage;

import java.util.Date;

public class Book {

	private int isbn;
	private String title;
	private Date borrowDate;
	private Date returnDate;
	private int nofCopies = 1;

	public int getIsbn() {
		return this.isbn;
	}

	public String getTitle() {
		return this.title;
	}

	public Date getBorrowDate() {
		return this.borrowDate;
	}

	public Date getReturnDate() {
		return this.returnDate;
	}

	/**
	 * 
	 * @param isbn
	 * @param title
	 */
	public Book(int isbn, String title) {
		this.isbn = isbn;
                this.title = title;
	}

	public boolean borrowMe() {
            if(nofCopies>=1){
                nofCopies--;
                borrowDate = new Date();
                int d = (1+ borrowDate.getMonth())%12;
                returnDate = borrowDate;
                returnDate.setMonth(d);
                return true;
            }
            return false;
	}

	public void returnMe() {
		nofCopies++;
                borrowDate = null;
                returnDate = null;
	}

	public boolean equals(Book b) {
		return (this.isbn==b.isbn && this.title.equals(b.title));
	}
        
        public void increaseNumberOfCopies(){
            nofCopies++;
        }
}