jersey_restful_webservice
=========================

[![Build Status](https://travis-ci.org/Rob-Leggett/jersey_restful_webservice.svg?branch=master)](https://travis-ci.org/Rob-Leggett/jersey_restful_webservice)

Jersey 2.5.1 RESTful Web Service with JPA 2.1 implemented using EclipseLink 2.5.2 and using Derby 10.10.1.1 In Memory Database

This is an example of an RESTful WebService using Jersey for the JAX-RS implementation, Genson for the JSON to Java / Java to JSON data binding, EclipseLink for the JPA implementation and Derby for the In Memory Database.

Jersey is Oracles implementation of the JAX-RS 2.0 API.

Genson simply binds the data from JSON to Java and vice versa, you do not have to configure POJO mapping in the web.xml or specify @XmlRootElement to POJO objects.

EclipseLink implements the Java JPA 2.0 API which is used for transaction management, persistence configuration and data binding between tables and POJOs via annotations.

Derby is used to store data also allowing you to run an embedded database, in memory database etc.

Jersey Test Framework 2.5.1 will execute unit tests and allow for the http response to be tested, this has been combined with Mockito to mock out the services however if you wish based out your configuration you can also perform end to end tests.

-------------------------
Test
-------------------------

Ensure the context root is set to jrws and post of web server is 8080 (for example purposes)


Once you have started up the application

http://localhost:8080/jrws
- Will navigate you to the index.jsp to ensure the application is running.

----------------------
Example Restful Calls
----------------------

Ensure you set the content-type in your request to application/json

SAVE:

url = http://localhost:8080/jrws/rest/customer/save
method = POST
data = {"id":"1", "firstName":"Robert", "lastName":"Leggett"}

RETRIEVE:

url = http://localhost:8080/jrws/rest/customer/retrieve/1
method = GET

DELETE:

url = http://localhost:8080/jrws/rest/customer/delete
method = POST
data = 1

Donations
====================

### How you can help?

Any donations received will be able to assist me provide more blog entries and examples via GitHub, any contributions provided is greatly appreciated.

Thanks for your support.

[![paypal](https://www.paypal.com/en_US/i/btn/btn_donateCC_LG.gif)](https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=EV2ZLZBABFJ34&lc=AU&item_name=Research%20%26%20Development&currency_code=AUD&bn=PP%2dDonationsBF%3abtn_donateCC_LG%2egif%3aNonHosted)
