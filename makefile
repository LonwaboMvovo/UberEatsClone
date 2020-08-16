SRCDIR = src
BINDIR = bin
DOCDIR = doc
TESTDIR = test

JUNIT = ../junit/junit-4.12.jar -sourcepath ./src ./src/$*.java

JAVAC = javac
JFLAGS = -g -d $(BINDIR) -cp $(BINDIR)

vpath %.java $(SRCDIR):$(TESTDIR)
vpath %.class $(BINDIR)

.SUFFIXES: .java .class

.java.class:
	$(JAVAC) $(JFLAGS) $<

classes: Database.class Dish.class Order.class Person.class Restaurant.class UberEatsMobileApp.class UberEatsRestaurantApp.class

default: $(CLASSES)
	
Database.class: Database.java 
	javac -d $(BINDIR) -cp $(JUNIT)
Dish.class: Dish.java 
	javac -d $(BINDIR) -cp $(JUNIT)
Order.class: Order.java 
	javac -d $(BINDIR) -cp $(JUNIT)
Person.class: Person.java 
	javac -d $(BINDIR) -cp $(JUNIT)
Restaurant.class: Restaurant.java 
	javac -d $(BINDIR) -cp $(JUNIT)
UberEatsMobileApp.class: UberEatsMobileApp.java 
	javac -d $(BINDIR) -cp $(JUNIT)
UberEatsRestaurantApp.class: UberEatsRestaurantApp.java 
	javac -d $(BINDIR) -cp $(JUNIT)

clean:
	rm -f  $(BINDIR)/*.class
	rm -Rf doc