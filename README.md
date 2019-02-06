# All Day Lab - CodeClan Towers


You are being asked to model a hotel. This hotel will contain collections of different rooms (bedrooms, conference rooms, dining rooms, etc).


## MVP

* Create 3 different types of rooms which have properties/methods of their own:

  - `Bedroom` which has a room number, capacity, collection of guests and a type (e.g. Single/Double.)

  - Other types of rooms must have a capacity, collection of guests and any other properties you wish.

* Create a `Guest` class so that guests can be checked in/out of rooms.

* Create a `Hotel` class, which has several separate collections for different types of rooms.

* The hotel will be able check guests in/out of rooms.


### Extensions

* Create a `Booking` class which has a bedroom and a number of nights.
* Create a `bookRoom()` method in `Hotel`. This should book a specific bedroom for a number of nights. This should return a new booking object.
* Add a nightly rate to the bedrooms and write a method to return the total bill for the booking. (nightly rate * number of nights)

### Advanced Extensions

* Add functionality to the hotel so it can see a list of vacant bedrooms.
* Amend `bookRoom()` so that hotel will only be able to check guests into empty bedrooms.
* Any other extensions you can think of!

#### Remember
Use __TDD__, with separate test files for each class.
