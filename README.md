# CoffeeProblem
Coffee Coding problem for Bertram Labs



INSTRUCTIONS TO RUN:

Needed before running:
-Java Development Kit installed on System
-Git installed

1. Clone the Repository to the local machine using git commands "git clone https://github.com/pmckone/CoffeeProblem.git"
2. Navigate to the project Directory by opening a terminal or command prompt to the directory containing the Java source file ('CoffeePaymentGUI.java')
3. Compile the Java Source File using the javac command javac CoffeePaymentGUI.java
4. After successful compilation, run the application using the java command: java CoffePayementGUI or just run the code via your IDE
5. Once the application starts, a GUI window titled "Coffee Payment System" will appear. Press the "Calculate" button to determine who should pay for coffee today. The selected coworker's name will be displayed in the center of the window.

LOGIC/ASSUMPTIONS:
The Application simulates a system where coworkers take turns paying for coffee based on their drink preferences and the number of times they've already paid. It ensures fairness by rotating the queue and considering each coworker's drink costs and buy counts. decideWhosTurn method iterates through the queue of coworkers and selects the coworker with the highest drink cost who has yet to exceed the buy count threshold. If all coworkers have exceeded the buy count threshold, it prioritizes based on drink cost only. It increments the buy count for the selected coworker and returns their reference. One assumption that I made in the making of the Coffee Payment System was the program aims to distribute the responsibility of paying for coffee among coworkers in a fair manner. Fairness is achieved by considering the drink cost and the number of times each coworker brought coffee. As well the order of the rotation does not affect the fairness of the payment and that all coworkers have an equal chance to pay for coffee over time. Finally, I assumed that the program would not need to store coworker data between program executions. I assumed coworker data is temporary and does not need to be stored.

***NOTE***
The logic behind Jermeny and Emily being very late in the program is this reason their price of coffee was cheaper than the mean of the total coffee therefore for fairness I decided that they would only buy everyone coffee very limitedly until the threshold of everyone buying being met. 



