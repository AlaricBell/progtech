# Progtech  

The project I've been working on is meant to simulate a coffee shop and its basic storage functionalities like ordering a coffee or filling the storage.  
The main objective was the implementation of design patterns in a well structured way, things like user input is safe to use as far as it's about case sensitivity or invalid values however I didn't put the right effort into making it user friendly.

## Design Patterns

### MVC Architecture  
Implemented the widely used MVC pattern for best practice.
Its a design pattern that makes it easier for the developer to clearly see through the project structure by separating 3 main panels in the application.

### Models
* Coffees: (**Cost**: *double*, **Description**: *String*)
* FlavouredCoffees: (**Cost**: *double*, Description: *String*) **implements** Decorator pattern
* Storage: (store, remove, add, validate, get) **implements** Singleton pattern

### Views
The project was made for console usage, a simple prompter is implemented as baseclass in order to provide more flexibility, however since it's a simple project I did create 2 separate views for cost management and overall storage management to present how it should be done in  larger appliacations.

* Prompt: (Abstract, void promptOutput, void promptOutput(): *static*, String getUserInput(): *static*)
* StoragePrompter (storageOptions: *String*, coffeeOptions: *String*, needFlavourOptions: *String*, flavourOptions: *String*) extends Prompt
* CostPrompter (costChangeOption: *String*) extends Prompt

### Controllers
The project is based on basic storage functionalities, in my opinion one controller was more than enough and consistent for this kind of situation, since most of the implemented methods are depending on each other.

* Storage Controller
  * handleUserInput() `index`
  * removeCoffeeFromStorage() `destroy`
  * fillStorageByType() `store`
  * orderCoffee() `order`  
  * setPrice() `set`
  **Helpers:**  
  * chooseCoffeeType()
  * chooseFlavour()
  * makeCoffee()
  
### Singleton
In my opinion (Based on what I heard and read) Singleton is a highly controversial pattern and its usage should be avoided in most cases (I mean really... like 99%).
This pattern is based on the assumption that we will never need another instance of the certain class, however this is something we never know for sure when it comes to more complex projects. 
Since this project is simple making the Storage a singleton isn't troublesome and even useful in some cases. I want only one Strorage class and this pattern is an insurance that it will be that way.

### Decorator
There are lots of different types of coffees however most of them has additional flavours with the same base type, like vanilla cappucchino.
In order to differentiate them without separating them from their origins Decorator pattern was the perfect choice. 
All coffee models extend the same base Coffee class, the flavoured coffees keep a reference of their origin type so we can show their similarities and differences.

### Factory 
Factory pattern is meant to separate the logic of creating a new instance of a class. While the controller takes part in the creation the logic of deciding what class should be instanciated is implemented in the Factory pattern.

## Unit Test (JUnit5)
Unit: the most simple part of the application. 
In a well designed program most of the methods can be tested because a well-written method is simple and only focuses on one thing.
In my application the main logic the controller is working with is implemented in the Storage so the main focus was there.
JUnit is well implemented in many Java frameworks and it's easy to use / understand, also very popular.

* Store
  * checks if the object is stored in the container
  * checks if only one object is created
* Remove
  * checks if the object removed is the right type
  * checks if only a single instance is removed.
* Validation
  * checks if the number of distinct products is within the limit of the storage
* Get single coffee
  * checks if the object returned is the right type
  * checks if there is object to return
* Fill storage
  * checks if object is added to storage
  * ckecks if storage is filled
* Filter
  * checks if the returned object is the right type
  * checks if object is a collection
