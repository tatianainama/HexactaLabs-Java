package ar.com.hexacta.tpl.model;

import java.io.Serializable;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;

// @Entity
public class Book extends Entidad implements Serializable {

    private static final long serialVersionUID = 604529088687479075L;

    // @Id
    // @Column(name = "BOOK_ID")
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long id;

    // @Version
    // @Column(name = "VERSION")
    // private Long version;

    // @Column(name = "NAME")
    private String name;

    // @Column(name = "DESCRIPTION")
    private String description;

    // @Column(name = "PUBLISHER")
    private String publisher;

    // @Column(name = "COUNTRY")
    private String country;
    
    private String isbn;

    private Boolean enabled;

    // @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // @Column(name = "BOOK_CATEGORY")
    private Set<BookCategory> bookCategories;

    // @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // @Column(name = "BOOK_COPY")
    private Set<BookCopy> bookCopies;


    // Hibernate needs this

    public Book() {
        super();
        this.enabled = Boolean.TRUE;
    }

    public Book(final String name) {
        this();
        this.name = name;
    }

    public Book(final String aName, final String aDescription, final String aPublisher, final String aCountry, final String isbn,

    final Set<BookCategory> bookCategories, final Set<BookCopy> bookCopies, final Set<Comment> bookComments) {
        this(aName);
        this.description = aDescription;
        this.publisher = aPublisher;
        this.country = aCountry;
        this.bookCategories = bookCategories;
        this.bookCopies = bookCopies;
        this.isbn = isbn;
    }

    public Set<BookCategory> getBookCategories() {
        return bookCategories;
    }

    public String getDescription() {
        return description;
    }

    @JsonIgnore
    public Set<BookCopy> getBookCopies() {
        return this.bookCopies;
    }

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setBookCategories(final Set<BookCategory> bookCategories) {
        this.bookCategories = bookCategories;
    }

    public void setBookCopies(final Set<BookCopy> bookCopies){
    	this.bookCopies = bookCopies;
    }
    
    public void setDescription(final String description) {
        this.description = description;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setPublisher(final String publisher) {
        this.publisher = publisher;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public void setISBN (final String isbn){
    	this.isbn = isbn;
    }
    
    public String getISBN (){
    	return this.isbn;
    }

    public void setEnabled(Boolean enable){
    	this.enabled = enable;
    }
    
    @JsonIgnore
    public boolean getEnabled(){
    	return this.enabled;
    }
    
    public void clearBookCategories(){
    	this.bookCategories.clear();
    }
    
    public void addBookCategories(Set<BookCategory> added){
    	this.bookCategories.addAll(added);
    }
}
