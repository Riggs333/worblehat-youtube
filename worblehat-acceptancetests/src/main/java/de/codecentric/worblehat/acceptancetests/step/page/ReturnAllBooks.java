package de.codecentric.worblehat.acceptancetests.step.page;

import de.codecentric.worblehat.acceptancetests.adapter.SeleniumAdapter;
import de.codecentric.worblehat.acceptancetests.adapter.wrapper.Page;
import de.codecentric.worblehat.acceptancetests.adapter.wrapper.PageElement;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReturnAllBooks {
    private final SeleniumAdapter seleniumAdapter;

    @Autowired
    public ReturnAllBooks(SeleniumAdapter seleniumAdapter) {
        this.seleniumAdapter = seleniumAdapter;
    }

    // *******************
    // *** G I V E N *****
    // *******************

    // *****************
    // *** W H E N *****
    // *****************

    @When("borrower $borrower returns all his books")
    public void whenUseruserReturnsAllHisBooks(String borrower1) {
        seleniumAdapter.gotoPage(Page.RETURNBOOKS);
        seleniumAdapter.typeIntoField("emailAddress", borrower1);
        seleniumAdapter.clickOnPageElement(PageElement.RETURNALLBOOKSBUTTON);
    }

}
