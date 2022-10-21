# Sr. Software Engineer Coding Exercise

# Summary
Write a Java command line program `quotely` which takes as an argument `English` or `Russian` and returns a quote from the forismatic API with the correct language.
If a language is not specified, default to English.

# How to Run

### Build
```
$ mvn clean install
```
### Install
Add an alias in your `~/.bashrc` file 
```
alias quotely='java -cp ~/.m2/repository/org/example/quotely/1.0-SNAPSHOT/quotely-1.0-SNAPSHOT.jar com.example.QuotelyGenerator'
```
```
$ source ~/.bashrc
```
### Usage
Valid inputs are: no input, "English" or "Russian"
```
//  To generate a quote in English
$ quotely english
$ quotely

//  To generate a quote in Russian 
$ quotely russian
```
# Possible Enhancements
- `Quotes.java` is a POJO to represent the Forismatic (third party) API response. In the future, if we want to cache or store generated quotes, we can use this POJO.
- Ways to improve test suite:
  - Mock `HttpClient` used in `QuoteService.java` so that we are not bombarding the third party API every time we run tests
  - Mocking `HttpClient` also helps to test the use-case of catching exceptions 
- `QuoteService.getQuote` method can be made even more robust if we add separate catch blocks for each expected exception: `URISyntaxException, IOException, InterruptedException`
  - the benefit of doing this is that we can implement different ways to proceed depending on the exception (or return more meaningful messages to the end user)
  - the current implementation has one `catch (Exception e)` block for simplicity and because right now the behavior, regardless of exception, is the same - to return an error message
- The third party API returns status 200 OK, if an invalid language param is sent. The error message is returned as part of the response body. `QuoteService.getQuote` can be updated to parse the response in more depth.
# Instructions

Please write a java program which 
1. Operates on the command line
1. Accepts a language as an argument (either `English` or `Russian`)
1. Fetches results from the forismatic.com quote api (http://forismatic.com/en/api/)
1. Displays to stdout the quote and author

# Time Limit

We want to balance the value of coding exercises with the time obligation that we ask of our candidates. Please limit your time investment to two hours. If as you approach 2 hours, you find you are not almost done, document what remaining steps you would complete given more time, and submit your partial work.

# External Libraries

You may use any external library you wish, but please do not use this or https://github.com/VEINHORN/forismatic-api-java similar client libraries which reduce the exercise to a couple API calls. This limits the utility of the exercise.

# Evaluation Criteria

We are looking for:

1. Simple, easy to understand code
1. Runnable test suite
1. Project organization
1. Any documentation necessary to run and evaluate the program

A goal is for this project to not take a burdensome amount of time. Please include in your submission how long you spent doing this exercise so we can adjust it as appropriate.

# Submission

When complete, please provide a link to your projects GitHub repo (or public source control service of choice). You can do this by replying to the email from the recruiting team or emailing recruiting@gremlin.com.

# Other Notes
If you have any questions, please reach out to recruiting@gremlin.com.

If you spend more than 2 hours on this, feel free to submit partial work. We want to be respectful of people's time commitments, and we can learn a lot about your work even if it's incomplete.

Please take care not to hammer this public API. Be kind.

