# Unusual Spending Kata Kotlin

Based on [this kata](https://kata-log.rocks/unusual-spending-kata).

## Description

You work at a credit card company, and for a new feature, they want to start providing alerts to users when their spending in any particular category is higher than usual.

Each payment has an amount, description, and category.
A category is a collection of payments like “entertainment”, “restaurants”, and “golf.”

For a given user, fetch the payments for the current month and the previous month.
Compare the total amount paid for each month, per category.
A category should be marked for unusual spending when the customer spent at least 50% more this month compared to last month.
To notify the customer, compose an e-mail message listing these categories, looking somewhat like this:

```
Hello card user!

We have detected unusually high spending on your card in these categories:

* You spent $148 on groceries
* You spent $928 on travel

Love,

The Credit Card Company
```
