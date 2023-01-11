package technology.sola.server;

import technology.sola.engine.networking.socket.SocketMessage;
import technology.sola.engine.server.ClientConnection;
import technology.sola.engine.server.SolaServer;

public class ServerMain {
  public static void main(String[] args) {
    SolaServer solaServer = new ExampleSolaServer();

    solaServer.start(60000);
  }

  private static class ExampleSolaServer extends SolaServer {
    protected ExampleSolaServer() {
      super(30);
    }

    @Override
    public void initialize() {

    }

    @Override
    public boolean isAllowedConnection(ClientConnection clientConnection) {
      return true;
    }

    @Override
    public void onConnectionEstablished(ClientConnection clientConnection) {
      System.out.println("Connection established " + clientConnection.getClientId());
    }

    @Override
    public void onDisconnect(ClientConnection clientConnection) {
      System.out.println("Disconnected - " + clientConnection.getClientId());
    }

    @Override
    public boolean onMessage(ClientConnection clientConnection, SocketMessage socketMessage) {
      return true;
    }
  }
}
