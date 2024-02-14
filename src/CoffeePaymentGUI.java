import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
public class CoffeePaymentGUI extends JFrame implements ActionListener {
    private Queue<Coworker> coworkers;
    private JLabel resultLabel;
    @SuppressWarnings("unused")
    private int roundsCompleted = 0;
    private int threshold = 2;

    public CoffeePaymentGUI() {
        setTitle("Coffee Payment System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        coworkers = new LinkedList<>();
        coworkers.offer(new Coworker("Bob", "cappuccino", 3.50));
        coworkers.offer(new Coworker("David", "flat white", 3.50));
        coworkers.offer(new Coworker("Jeremy", "black coffee", 2.00));
        coworkers.offer(new Coworker("Alice", "latte", 4.00));
        coworkers.offer(new Coworker("Emily", "espresso", 3.00));
        coworkers.offer(new Coworker("Michael", "mocha", 4.50));
        coworkers.offer(new Coworker("Sarah", "chai latte", 4.00));
        

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);

        resultLabel = new JLabel("Press the button to determine who should pay for coffee today.");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateButton);

        add(resultLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Calculate")) {
            Coworker nextToPay = decideWhosTurn(coworkers);
            resultLabel.setText("It's " + nextToPay.name + "'s turn to pay for coffee today.");
            rotateQueue(coworkers);
            roundsCompleted++; // Increment the number of rounds completed
        }
    }
    
    public Coworker decideWhosTurn(Queue<Coworker> coworkers) {
    // Select the coworker with the highest drink cost who hasn't exceeded the buy count threshold
    Coworker nextToPay = null;
    for (Coworker coworker : coworkers) {
        if (nextToPay == null || (coworker.drinkCost > nextToPay.drinkCost && coworker.getBuyCount() < threshold)) {
            nextToPay = coworker;
        }
    }

    // If all coworkers have exceeded the buy count threshold, prioritize based on drink cost only
    if (nextToPay == null) {
        for (Coworker coworker : coworkers) {
            if (nextToPay == null || coworker.drinkCost > nextToPay.drinkCost) {
                nextToPay = coworker;
            }
        }
    }

    // Increment the buy count for the coworker who is going to pay
    if (nextToPay != null) {
        nextToPay.incrementBuyCount();
    }

    // Return the selected coworker
    return nextToPay;
    }

    public void rotateQueue(Queue<Coworker> queue) {
        Coworker head = queue.poll();
        queue.offer(head);
    }
    
    public double calculateTotalCost(Queue<Coworker> coworkers) {
        double totalCost = 0;
        for (Coworker coworker : coworkers) {
            totalCost += coworker.drinkCost;
        }
        return totalCost;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CoffeePaymentGUI());
    }
}



