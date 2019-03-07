package feature.book;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hascode.tutorial.cucumber.book.Book;
import com.hascode.tutorial.cucumber.book.Library;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookSearchSteps {
	Library library = new Library();
	List<Book> result = new ArrayList<>();

	@Given("(a|another) book with the title {string}, written by {string}, published in {date_iso_local_date_time}")
	public void addNewBook(final String title, final String author, final LocalDateTime published) {
		Book book = new Book(title, author, published);
		library.addBook(book);
	}

	@When("the customer searches for books published between {date_iso_local_date_time} and {date_iso_local_date_time}")
	public void setSearchParameters(final LocalDateTime from, final LocalDateTime to) {
		result = library.findBooks(from, to);
	}

	@Then("{int} books should have been found")
	public void verifyAmountOfBooksFound(final int booksFound) {
		assertThat(result.size(), equalTo(booksFound));
	}

	@Then("Book {int} should have the title {string}")
	public void verifyBookAtPosition(final int position, final String title) {
		assertThat(result.get(position - 1).getTitle(), equalTo(title));
	}
}
