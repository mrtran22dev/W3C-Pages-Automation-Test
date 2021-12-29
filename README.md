The purpose of this project is to utitlize Maven/Selenium/Cucumber to perform automated testing for specified W3 webpages.  The W3 pages tested are:

- W3 Bad page (404)
- W3 Multi-modal page
- W3 HTML/CSS page

The following validations for each page are performed via automation for both Chrome/Firefox browsers:

- Check page returned status/response code
- Check browser for console log errors after page load
- Check all links redirects to valid page (non-4xx)

<i><u>NOTE:</i></u> To run complete automation suite, after cloning of project, user can execute the following Maven command in Terminal or IDE GUI interface:
<pre>mvn clean test</pre>

After running the test suite, there will be an HTML test report generated in following Maven project path:
<pre>/target/cucumber-reports/test-report.html</pre>

![Screen Shot 2021-12-29 at 11 34 10 AM](https://user-images.githubusercontent.com/42190310/147699327-fef93393-b253-4165-8378-71c58873900e.png)

Alternatively, user can run scenarios via the feature files located in:
<pre>src/test/resources/features</pre>

<i><u>NOTE:</i></u> There is a config file that allows the user to switch between using the Chrome/Firefox drivers locally, or using 'RemoteWebDriver' from Selenium Stand-alone Grid drivers.
This config was initially setup to test/debug some Docker issues.</br></br>
The config file is located in the path (below).  User can change the 'locale' key/value to <b><i>local</b></i> or <b><i>remote</b></i>

<pre>src/test/resources/reference.conf</pre>

My Docker Hub link:
https://hub.docker.com/u/mrtran22dev
