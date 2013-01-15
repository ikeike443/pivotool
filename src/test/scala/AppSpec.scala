package com.gmail.ikeike443.pivotool

import org.specs2.mutable._
import play.api.libs.ws._
import play.api.libs.concurrent._

class AppSpec extends Specification {
import play.core.StaticApplication
new StaticApplication(new java.io.File("."))
  "The 'Hello world' string" should {
    "contain 11 characters" in {
      "Hello world" must have size(11)
    }
    "start with 'Hello'" in {
      "Hello world" must startWith("Hello")
    }
    "end with 'world'" in {
      "Hello world" must endWith("world")
    }
  }
}
