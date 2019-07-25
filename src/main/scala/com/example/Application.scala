package com.example

import akka.actor.{ActorSystem, Props}

object Application extends App{

    val system = ActorSystem("akkademy")
    system.actorOf(Props[AkkaDB], name = "akkademy-db")

}
