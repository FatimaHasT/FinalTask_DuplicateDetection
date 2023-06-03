PlaceLab Testing - Duplicate Detection module

This repository contains the automated tests and .json file for the PlaceLab project. The tests cover the Smoke Testing of the Content Classification - Duplicate Detection module, both through the user interface and API.

Automation

Automated Smoke Test

An automated smoke test for the Content Classification - Duplicate Detection module is available in the SmokTest file. This test script utilizes the Selenium framework to interact with the user interface.

To run the automated smoke test in terminal:
mvn clean install -Demail="fatimahasanovic1994@gmail.com" -Dpassword="Sarajevo.123" -Dbrowser="chrome" -Dtest=SmokeTest


API Testing

API Smoke Test

An API smoke test for the Content Classification - Duplicate Detection module is available in the Final Task.postman_collection.json file. This Postman collection contains a series of API requests and assertions.

To execute the API smoke test:

Import the Final Task.postman_collection.json file into Postman.

Run the collection and observe the results.
