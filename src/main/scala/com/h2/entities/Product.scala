package com.h2.entities

import com.h2.entities.types.Dollars

abstract class Product {
  val name: String

  override def toString: String = "product=" + name
}

//Deposits
abstract class Deposits extends Product {
  val interestRatePerYear: Double
  val minimumBalancePerMonth: Dollars
}

abstract class Checkings extends Deposits

abstract class Savings extends Deposits {
  val transactionsAllowedPerMonth: Int
}

//Checking
class CoreChecking(val minimumBalancePerMonth: Dollars,
                   val interestRatePerYear: Double) extends Checkings {
  println("Created Core Checking Product")
  override val name: String = "Core Checking"
}

class StudentCheckings(val minimumBalancePerMonth: Dollars,
                       val interestRatePerYear: Double) extends Checkings {
  println("Created Student Checking Product")
  override val name: String = "Student Checking"
}

//Savings
class RewardsSavings(val minimumBalancePerMonth: Dollars,
                     val interestRatePerYear: Double,
                     val transactionsAllowedPerMonth: Int) extends Savings {
  println("Created Rewards Savings Product")
  override val name: String = "Rewards Savings"
}

//Lending
abstract class Lending extends Product {
  val annualFee: Double
  val apr: Double
  val rewardsPercent: Double
}

class CreditCard(val annualFee: Double,
                 val apr: Double,
                 val rewardsPercent: Double) extends Lending {
  println("Created Credit Card Product")
  override val name: String = "Credit Card"
}
