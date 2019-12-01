# Questions and Exercises: Object-Oriented Programming Concepts

## Questions 
  1. Real-world objects contain (STATE) and (BEHAVIOR).
  2. A software object's state is stored in (FIELDS).
  3. A software object's behavior is exposed through (METHODS).
  4. Hiding internal data from the outside world and accesing it only though publicly
     exposed methods is known as data (ENCAPSULATION).
  5. A blueprint for a software object is called a (CLASS).
  6. Common behavior can be defined in a (SUPERCLASS) and inherited into a
     (CLASS/SUBCLASS) using the (extends) keyword.
  7. A collection of methods with no implementation is called an (INTERFACE).
  8. A namespace that organizes classes and interfaces by functionality is called a
     (PACKAGE).
  9. The term API stands for (APPLICATION PROGRAM INTERFACE)

## Exercises
  1. Objeto: TERMO
	
	class Termo {
	  // Fields
	  int storage=0; //Can go from 0% to 100%
	  int dialing=0; // It's dialing liquid(1) or not(0)
	  int open=0;    // It's open(1) or not (0)
	  int operative=1;

	  // Methods
	   void fillIn(int filled) {
	     storage+=filled; 
	   }
	   
	   void dialLiquid(int dialed) {
	     storage-=dialed;
	     dialing=1;
	   }

	   void quitDialing() {
	     dialing=0;
	   }
	
	   void openCrust() {
	     open=1;
	   }

	   void closeCrust() {
	     open=0;
	   }

	   void declareBroken() {
	     operative=0;
	   }

	   void declareRepaired() {
	     operative=1;
	   }

	}

  2. Example of interface Termo for class StanleyTermo

	interface Termo {
	  void fillIn(int flled);

	  void dialLiquid(int dialed);

	  void quitDialing();

	  void openCrust();

	  void closeCrust();

	  void declareBroken();

	  void declareRepaired();
	}


	class StanleyTermo implements Termo {
	  int storage=0; 
	  int dialing=0; 
	  int open=0; 
	  int operative=1;

	   public void fillIn(int filled) {
	     storage+=filled; 
	   }
	   
	   public void dialLiquid(int dialed) {
	     storage-=dialed;
	     dialing=1;
	   }

	   public void quitDialing() {
	     dialing=0;
	   }
	
	   public void openCrust() {
	     open=1;
	   }

	   public void closeCrust() {
	     open=0;
	   }

	   public void declareBroken() {
	     operative=0;
	   }

	   public void declareRepaired() {
	     operative=1;
	   }
	}


  2.1 When not correctly stating all methods of the interface in the class that implements it,
      the current message appears:
	'Error:(1, 8) java: StanleyTermo is not abstract and does not override abstract method declareRepaired() in Termo'
      This happens because we didn't Override all the methods like the interface demands it.

