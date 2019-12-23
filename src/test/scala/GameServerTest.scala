import akka.actor.ActorSystem
import akka.http.scaladsl.model.ws.{Message, TextMessage}
import akka.http.scaladsl.server.Directives
import akka.http.scaladsl.testkit.{ScalatestRouteTest, WSProbe}
import akka.stream.{ActorMaterializer, FlowShape}
import akka.stream.scaladsl.{Flow, GraphDSL, Merge}
import org.scalatest.{FunSuite, Matchers}

class GameServerTest extends
  FunSuite with
  Matchers with
  ScalatestRouteTest {

  test("should test tester") {
    1 shouldEqual 2
  }

  test("should create empty GameService") {
    new GameService()
    //1 shouldBe 1
  }

  test("should be able to connect to the GameService websocket") {
    assertWebsocket("John") {wsClient =>
      isWebSocketUpgrade shouldEqual true
    }
  }

  test("should respond with correct message") {
    assertWebsocket("John") {wsClient =>
      wsClient.expectMessage("welcome John2")
      wsClient.sendMessage("hello2")
      wsClient.expectMessage("123123rqwerasdf")
    }
  }

  test("should register player") {
    assertWebsocket("John") { wsClient =>
      wsClient.expectMessage("welcome John")
    }
  }

  def assertWebsocket(playerName:String)(assertions : (WSProbe)=>Unit) : Unit = {
    val gameService = new GameService()
    val wsClient = WSProbe()
    WS(s"/?playerName=$playerName", wsClient.flow) ~> gameService.websocketRoute ~> check(assertions)
  }
}




