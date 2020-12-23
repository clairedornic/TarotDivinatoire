# Tarot project report

## 1. Project organisation 

I segmented this project into two parts. First I started to code the Tarot in console game. I didn’t know if I would be able to code all the features requested, so before creating the interface I wanted to make sure to code the main methods of the game. I managed to create the whole game in console (except the images because I wanted to integrate them at the same time as the interface). 

This first step of the project took me 3 weeks working regularly. Once the console game was finished, I moved on to the realization of the interface. Unlike the console game, the development of the interface was faster. On the other hand, I spent a lot of time researching to understand which Layout was the most suitable for each situation/class. I managed to develop a functional interface but, I didn’t have time to work on the aesthetic side.

## 2. Project structure

As for the project tree, I wanted to separate the console game from the interface as much as possible. To do this I created three folders. The first folder group the files of the console game (Card, Deck, Main), the second group the files of the interface and finally the last, group the images of the project. In total there are 3 classes for the console game and 9 classes for the interface.

## 3. Class and methods

At the console game level, the deck class simulates a deck of card thanks to an arraylist. This class have methods that can shows each card that is in the deck, adds a card to the deck, removes a card from the deck, searches for a card in the deck by name or ID and knows if there are cards in the deck.

The card class allows you to give a name, an ID, a description and an image to each card in the deck.

On the interface :
* The AddCardPanel class allows the user to add informations of a new card and save it.
* The AddClassicCardsPanel class allows the user to add all the classic cards of the Tarot in the deck.
* The DisplayImage class allows the retrieve of the photo chosen by the user, create a new one with a defined dimension and display it.
* The Menu class displays the menu that will be available throughout the application.
* The ModifyCard class allows you to update informations of a card.
* The ReadCardsPanel class display all the images of the cards of the deck.
* The SearchOrDeleteCardPanel class allows you to search for a card by name or ID, display it and delete it if the user wishes.
* The WelcomePanel class displays the welcome message.
* The Window class allows to create the application window.

## 4.  Feedback on the project

This project was long however it taught me a lot of things, I did not think to succeed to go so far in the project. The extra time that was given to the whole class was really helpful to me in finishing it. The interface gave me a hard time and especially with the different layout. The rendering is not the prettiest but it remains quite consistent overall.

I’m disappointed that I didn’t manage to set up the serialization and deserialization of the deck in the interface because I had managed to set it up in the console game.

## 5.  What could be improved/added to the application

* App design
* More user interactions
* Deck recording
* Other features
* Player profile
 
