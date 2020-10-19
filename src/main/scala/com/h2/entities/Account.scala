package com.h2.entities

class Account(c: Customer, p: Product, b: Int) {
  val customer: Customer = c
  val product: Product = p
  private var balance: Int = b

  def deposit(amount: Int): Unit = {
    println(s"Depositing $amount to $customer account")
    balance += amount
  }

  def withdraw(amount: Int): Unit = {
    println(s"withdrawing $amount to $customer account")
    balance -= amount
  }

  override def toString: String = s"$customer with $product has remaining balance of $balance"
}
