class Coworker {
    String name;
    String favoriteDrink;
    double drinkCost;
    int buyCount;

    public Coworker(String name, String favoriteDrink, double drinkCost) {
        this.name = name;
        this.favoriteDrink = favoriteDrink;
        this.drinkCost = drinkCost;
        this.buyCount = 0;
    }
    public void incrementBuyCount() {
        buyCount++;
    }

    public int getBuyCount() {
        return buyCount;
    }
}