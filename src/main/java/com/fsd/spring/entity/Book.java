package com.fsd.spring.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "BOOK")
@Component
public class Book implements Comparable<Book>, Serializable {
	private static final long serialVersionUID = 1l;

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment") 
	@Column(name = "BOOKID")
	private Long bookId;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "PRICE")
	private double price;

	@Column(name = "VOLUME")
	private int volume;

	@Column(name = "PUBLISH_DATE")
	@Temporal(TemporalType.DATE)
	private Date publishDate;
	
	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	@Override
	public int compareTo(Book book) {
		return this.bookId.compareTo(book.getBookId());
	}

	@Override
	public String toString() {
		return "\nBook{" + "bookId=" + bookId + ", title='" + title + '\'' + ", price=" + price + ", volume=" + volume
				+ ", publishDate=" + publishDate + '}';
	}
}
