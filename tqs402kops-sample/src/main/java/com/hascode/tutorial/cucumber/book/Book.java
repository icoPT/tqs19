package com.hascode.tutorial.cucumber.book;

import java.time.LocalDateTime;
import java.util.Date;

public class Book {
	private final String title;
	private final String author;
	private final LocalDateTime published;

	public Book(final String title, final String author, final LocalDateTime published) {
		this.title = title;
		this.author = author;
		this.published = published;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public LocalDateTime getPublished() {
		return published;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [title=").append(title).append(", author=").append(author).append(", published=").append(published).append("]");
		return builder.toString();
	}
}
