
# Java Design Patterns Demo Projects

This repository contains demo projects showcasing the implementation of different design patterns in Java, including:

* Adapter pattern
* Abstract factory pattern
* Command pattern
* Strategy pattern
* Decorator pattern

Additionally, there is also a demo project for 
* generics



All of these projects were completed as tasks for the "Advanced Object-Oriented Programming" course in Java.


## Adapter Design Pattern

In this problem, we have a client that works with objects that implement a specific interface for operations on a sequential data structure. The client needs to work with a new data structure that does not implement the same interface. We need to solve this problem by using the Adapter Pattern, which allows the client to work with the new data structure without changing their code. Specifically, we will create an expected class called ArrayListLikeSequentialDataStructure that implements the required interface using an ArrayList as a composition element. Then, we will use the Adapter Pattern to allow the client to work with an array of elements instead of an ArrayList. Finally, we will test the solution by creating an array of integers, creating an ArrayList from it, and then testing all methods with both the ArrayList and the adapted array.


## Abstract Factory Design Patterns

The abstract factory pattern is used to create families of related objects without specifying their concrete classes. The main idea behind this pattern is to provide an interface for creating families of objects, but leave the actual implementation of the classes to the subclasses that implement the factory method. In this specific task, the goal is to create an application for reserving any type of transportation in the logistics chain, including air, sea, truck, and van transport. The application should be agnostic to the actual process of creating the transport and should not require any changes in the client code if a new type of transport is added.


## Command Design Pattern

In this task we needed to create a GUI application for viewing CSV files with a menu bar containing File and Edit menus, keyboard shortcuts for commands, and a toolbar with Open, Save, Delete row, Delete column, Clear table, Undo, and Redo commands. The application should display data from any CSV file with a header and allow users to save data to a CSV file. Implement all commands using the Command pattern and ensure that Undo and Redo have their own logic for each command. The dialog for opening and saving files should show the data folder as part of the starting repository, and the console should display the state of the UndoStack and RedoStack.


## Strategy Design Pattern

This task involves creating a Java application that dynamically selects a sharing algorithm at runtime using the strategy pattern and parameterization. The application must define three sharing algorithms: ModuloDiv, IntDivision, and ExpoDiv. All strategies must follow the DIV_Strategy interface, which is parameterized with a class that extends the Number class. The ExpoDiv algorithm requires an Exponent class that extends the Number class. The task requires creating an object of the DIV_CLS class that includes all allowed sharing strategies and testing each strategy by dividing two numbers. The expected output should include the input numbers, the selected sharing algorithm, and the resulting quotient.


## Decorator Design Pattern

The decorator pattern is used to dynamically add desired behaviors to objects of a well-defined class. In this task, you are asked to create an application that can write a text file in its original form, then save it compressed or encrypted, and of course, a combination of both. Additional conditions are that the source of the text that represents the starting content of the file can be obtained from any existing .txt file or by fetching the entire content of a web page, knowing the URL of that page. The starting interface is DataSource, which has two methods: writeData and readData. Another interface that is given is DataProvider, which has one method, provideDataFromSource. The compression and encryption are implemented through an abstract class that wraps any DataSource. You are suggested to look at the API of Deflater and Inflater for compression and the Base64 class for encoding and decoding. In any case, the text is written to a file, regardless of any possible wrapping combinations or a pure txt file.

## Generics

The task requires creating a Java program that uses generics to create a list of User objects and then shuffles the list. It then needs to create a recursive method that gets all possible pairs from the shuffled list. The User class should be updated to be comparable using the CompareTwo class based on the ID value of the user. Finally, the program should use CompareTwo to compare all pairs from the shuffled list and print the results.
