package com.h2.entities

import java.time.LocalDate

import com.h2.entities.types.Email

class Customer(val first: String, val last: String,
               val email: Email, val dateOfBirth: LocalDate) {
  override def toString: String = s"$first,$last => $email"
}
