package com.h2.entities

import com.h2.entities.types.Dollars

abstract class Account {
  val customer: Customer
  val product: Product
  def getBalance: Dollars
}

class DepositsAccount(val customer:Customer, val product:Product, private var balance: Dollars) extends Account {
  def deposit(amount: Int): Unit = {
    require(amount > 0, "amount deposit should be greater then zero.")
    println(s"Deposit $amount to $customer account")
    balance += amount
  }

  def withdraw(amount: Int): Unit = {
    require(amount > 0 && balance > amount, "amount should be greater tha zero and requested amount should be less than or equal to balance")
    println(s"Withdrawing $amount to $customer account")
    balance -= amount
  }

  override def getBalance: Dollars = balance

  override def toString = s"$customer with $product has remaining balance of $balance"
}

class LendingAccount(val customer: Customer, val product: Product, private var balance: Dollars) extends Account {
  def payBill(amount: Int): Unit = {
    require(amount > 0, "The payment must be made for amount greater than zero.")
    println(s"Paying bill of $amount against $customer account")
    balance += amount
  }

  def withdraw(amount: Int): Unit = {
    require(amount > 0, "The withdrawal amount must be greater than zero.")
    println(s"debiting $amount from $customer account")
    balance -= amount
  }

  override def getBalance: Dollars = balance

  override def toString = s"$customer with $product has remaining balance of $balance"
}
