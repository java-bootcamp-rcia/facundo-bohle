package com.globant.abstractfactory.connection;


public interface SQLConnection {

// All connections must establish a session with its respective server.
  void connect();
}
