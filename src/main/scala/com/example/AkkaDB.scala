package com.example

import akka.actor.{Actor, Status}
import com.example.Messages.{GetRequest, KeyNotFoundException, SetRequest}

import scala.collection.mutable
import akka.event.Logging

class AkkaDB extends Actor{

  val map = new mutable.HashMap[String,Object]
  val logger = Logging(context.system,this)

  override def receive = {
    case SetRequest(key, value) =>
      logger.info("received SetRequest - key: {} value: {}", key, value)
      map.put(key, value)
      sender() ! Status.Success
    case GetRequest(key) =>
      logger.info("received GetRequest - key: {}", key)
      val response: Option[String] = map.get(key)
      response match{
        case Some(x) => sender() ! x
        case None => sender() ! Status.Failure(new
            KeyNotFoundException(key))
      }
    case o => Status.Failure(new ClassNotFoundException)
  }
}