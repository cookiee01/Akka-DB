package com.example

import akka.actor.Actor
import com.example.Messages.{GetRequest,SetRequest,KeyNotFoundException}
import scala.collection.mutable
import akka.event.Logging

class AkkaDB extends Actor{

  val map = new mutable.HashMap[String,Object]
  val logger = Logging(context.system,this)

  override def receive: Receive = {
    case SetRequest(key,value)=>{logger.info("received SetRequest - key: {} value: {}", key, value)
      map.put(key, value)}
    case o => logger.info(s"Received unknown request :{$o}")
  }
}