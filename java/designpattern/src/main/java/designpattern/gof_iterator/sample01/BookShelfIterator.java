package designpattern.gof_iterator.sample01;

public class BookShelfIterator implements Iterator {

    private BookShelf bookShelf;

    private Book book;

    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    public boolean hasNext() {
        if (index < bookShelf.getLength()) {
            return true;
        } else {
            return false;
        }
    }

    public Object next() {
        book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}
