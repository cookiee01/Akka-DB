package com.example

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import com.example.Messages.SetRequest
import org.scalatest.{BeforeAndAfterEach, FunSpec, Matchers}

class AkkaDBSpec extends FunSpec with Matchers with BeforeAndAfterEach{

  implicit val system = ActorSystem()
  describe("akkaDb"){
    describe("given SetRequest"){
      it("It should place key/value in map"){
        val actorRef = TestActorRef(new AkkaDB)
        actorRef ! SetRequest("key","value")
        val akkaDb = actorRef.underlyingActor
        akkaDb.map.get("key") should equal (Some("value"))
      }
    }
  }
}
