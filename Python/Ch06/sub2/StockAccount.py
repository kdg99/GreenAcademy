from sub1.Account import Account

class StockAccount (Account):
    
    def __init__(self, bank, id, name, stock, amount, price):
        super().__init__(bank, id, name)
        
        self.stock = stock
        self.amount = amount
        self.price = price

    def sell(self, amount, price):
        self.__balance += amount + price
        self.amount -= 1
    
    def buy(self, amount, price):
        self.__balance -= amount + price
        self.amount += 1
    
    def show(self, amount):
        super.show()
        print('주식종목 :', self.stock)
        print('주식수량 :', self.amount)
        print('주식가격 :', self.price)